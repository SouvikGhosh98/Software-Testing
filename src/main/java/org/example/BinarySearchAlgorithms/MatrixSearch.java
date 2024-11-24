package org.example.BinarySearchAlgorithms;

public interface MatrixSearch {
    <T extends Comparable<T>> int[] find(T matrix[][], T key);
}