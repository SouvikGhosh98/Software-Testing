package org.example.GraphAlgorithms;

import java.util.*;

public class LargeIsland {

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

    public int largestIsland(int[][] grid) {
        int n=grid.length;

        int ans=0;

        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};

        Disjoint ds=new Disjoint(n*n);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int cellVal=i*n+j;
                    for(int k=0;k<4;k++)
                    {
                        int x=i+row[k];
                        int y=j+col[k];

                        if(x>=0&&x<n&&y>=0&&y<n&&grid[x][y]==1)
                        {
                            int nVal=x*n+y;

                            if(ds.findParent(cellVal)!=ds.findParent(nVal))
                                ds.unionBySize(cellVal,nVal);

                        }
                    }
                }
            }
        }

        for(int i=0;i<ds.size.size();i++)
            ans=Math.max(ans,ds.size.get(i));

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> hs=new HashSet<>();
                    for(int k=0;k<4;k++)
                    {
                        int x=i+row[k];
                        int y=j+col[k];

                        if(x>=0&&x<n&&y>=0&&y<n&&grid[x][y]==1)
                        {
                            int nodeVal=x*n+y;

                            hs.add(ds.findParent(nodeVal));
                        }
                    }

                    ArrayList<Integer> temp=new ArrayList<>(hs);
                    int s=0;
                    for(int p=0;p<temp.size();p++)
                    {
                        s+=ds.size.get(temp.get(p));
                    }

                    ans=Math.max(ans,s+1);
                }
            }
        }

        return ans;
    }
}