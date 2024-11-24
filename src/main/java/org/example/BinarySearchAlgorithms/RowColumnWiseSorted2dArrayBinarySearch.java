package org.example.BinarySearchAlgorithms;

public class RowColumnWiseSorted2dArrayBinarySearch implements MatrixSearch {

	@Override
	public <T extends Comparable<T>> int[] find(T[][] matrix, T key) {
		return search(matrix, key);
	}

	public static <T extends Comparable<T>> int[] search(T[][] matrix, T target) {
		int rowPointer = 0; //The pointer at 0th row
		int colPointer = matrix.length - 1; //The pointer at end column

		while (rowPointer < matrix.length && colPointer >= 0) {
			int comp = target.compareTo(matrix[rowPointer][colPointer]);

			if (comp == 0) {
				return new int[] { rowPointer, colPointer };
			} else if (comp > 0) {
				rowPointer++; //Incrementing the row pointer if the target is greater
			} else {
				colPointer--; //Decrementing the column pointer if the target is lesser
			}
		}
		return new int[] { -1, -1 }; //The not found condition
	}
}