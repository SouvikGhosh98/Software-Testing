package org.example.GraphAlgorithms;

import java.util.*;

public class ConnectNetwork {

    static class Disjoint {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;

            int p = findParent(parent.get(node));
            parent.set(node, p);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int up = findParent(u);
            int vp = findParent(v);

            if (up == vp)
                return;

            if (size.get(up) < size.get(vp)) {
                parent.set(up, vp);
                int newSize = size.get(up) + size.get(vp);
                size.set(vp, newSize);
            } else {
                parent.set(vp, up);
                int newSize = size.get(up) + size.get(vp);
                size.set(up, newSize);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);

        int extraCables = 0;
        int components = 0;

        // Process each connection and union the components
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (ds.findParent(u) != ds.findParent(v)) {
                ds.unionBySize(u, v);
            } else {
                extraCables++;
            }
        }

        // Count the number of connected components
        for (int i = 0; i < ds.parent.size(); i++) {
            if (ds.parent.get(i) == i) {
                components++;
            }
        }

        components--; // Because the last component is already accounted for

        // If we have enough extra cables to connect all components
        if (extraCables >= components) {
            return components;
        }

        // Not enough cables to connect the components
        return -1;
    }
}