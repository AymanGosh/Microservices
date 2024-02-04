package com.oui.hw3;

/**
 * The `Ex13` class contains solutions for four different problems.
 * 
 * @author Ayman Abadlrhman
 */
public class Ex13 {

	public static void main(String[] args) {

		System.out.println("----------------------------------------");
		System.out.println("***         Q1  - maxMult3           ***");
		System.out.println("----------------------------------------");
		System.out.println("arr:[-8,1,-4,11,9,-15,10,8,-3]");
		int[] arr = { -8, 1, -4, 11, 9, -15, 10, 8, -3 };
		int result1 = Ex13.maxMult3(arr);
		if (result1 == 1320)
			System.out.println("Passed, result is 1320");
		else
			System.out.println("Failed,  expected: 1320   student's result: " + result1);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("***      Q2  - findMedian            ***");
		System.out.println("----------------------------------------");
		{
			int[] arr1 = { 1, 12, 15, 26, 38 };
			int[] arr2 = { 12, 13, 18, 30, 45 };
			System.out.println("arr1: [1,12,15,26,38]");
			System.out.println("arr1: [12,13,18,30,45]");
			int result2 = Ex13.findMedian(arr1, arr2);
			if (result2 == 16)
				System.out.println("Passed, result is 16");
			else
				System.out.println("Failed,  expected: 16  student's result: " + result2);
		}
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("***         Q3  - minimalSt          ***");
		System.out.println("----------------------------------------");
		System.out.println("Testing : st1=\"B\" st2=\"A\"");
		String st1 = "B";
		String st2 = "A";
		String result3 = Ex13.minimalSt(st1, st2);
		if (result3.equals("AB") || result3.equals("BA"))
			System.out.println("Passed, result is " + result3);
		else
			System.out.println("Failed,  expected: \"AB\" or \"BA\"   student's result: " + result3);
		System.out.println("Testing : st1=\"AA\" st2=\"A\"");
		st1 = "AA";
		st2 = "A";
		result3 = Ex13.minimalSt(st1, st2);
		if (result3.equals("AA"))
			System.out.println("Passed, result is " + result3);
		else
			System.out.println("Failed,  expected: \"AA\"  student's result: " + result3);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("***         Q4  - maxSnake           ***");
		System.out.println("----------------------------------------");
		System.out.println("testing with matrix:");
		System.out.println("4 5 2 3 1");
		System.out.println("3 4 1 4 4");
		System.out.println("1 5 6 7 8");
		System.out.println("3 4 5 8 9");
		System.out.println("3 2 2 7 6");
		int[][] mat = { { 4, 5, 2, 3, 1 }, { 3, 4, 1, 4, 4 }, { 1, 5, 6, 7, 8 }, { 3, 4, 5, 8, 9 }, { 3, 2, 2, 7, 6 } };
		int result4 = Ex13.maxSnake(mat);
		if (result4 == 13)
			System.out.println("Passed, result is " + result4);
		else
			System.out.println("Failed,  expected: 13   student's result: " + result4);

		System.out.println();
	}

	/**********************************************************/
	// q1
	/**
	 * Finds the maximum product of three integers in an array that is a multiple of
	 * 3.
	 * 
	 * Time_Complexity: O(n) Space_Complexity:O(1)
	 * 
	 * @param arr An array of integers.
	 * @return The maximum product of three integers.
	 */
	public static int maxMult3(int[] arr) {
		// Check if the array has less than 3 elements
		if (arr.length < 3) {
			return Integer.MIN_VALUE;
		}
		// Initialize variables to track the top three maximum and minimum values
		int min1, min2, max1, max2, max3;
		min1 = min2 = Integer.MAX_VALUE;
		max1 = max2 = max3 = Integer.MIN_VALUE;
		// Iterate through the array to find the top three maximum and minimum values
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			// Update top three maximum values
			if (number > max1) {
				max3 = max2;
				max2 = max1;
				max1 = number;
			} else if (number > max2) {
				max3 = max2;
				max2 = number;
			} else if (number > max3) {
				max3 = number;
			}
			// Update top two minimum values
			if (number < min1) {
				min2 = min1;
				min1 = number;
			} else if (number < min2) {
				min2 = number;
			}
		}
		// Calculate two possible results based on maximum and minimum values
		int result1 = max1 * max2 * max3;
		int result2 = max1 * min1 * min2;
		// Return the maximum of the two results
		if (result1 > result2) {
			return result1;
		} else {
			return result2;
		}
	}

	/**********************************************************/
	// q2
	/**
	 * Finds the median of two sorted arrays.
	 * 
	 * Time_Complexity: O(m + n) Space_Complexity:O(m + n)
	 * 
	 * @param arr1 The first sorted array.
	 * @param arr2 The second sorted array.
	 * @return The median of the merged arrays.
	 */
	public static int findMedian(int[] arr1, int[] arr2) {
		// Merge the two sorted arrays
		int[] mergeTwoSortedArrays = mergeTwoSortedArrays(arr1, arr2);
		// Get the length of the merged array
		int length = mergeTwoSortedArrays.length;
		// Check if the merged array is empty
		if (length == 0) {
			return 0; // Return a default value for empty arrays
		}
		// Calculate the index of the median
		int midIndex = length / 2;
		// Check if the length of the merged array is even or odd
		if (length % 2 == 0) {
			// If even, calculate the average of the middle two elements
			int median = (mergeTwoSortedArrays[midIndex] + mergeTwoSortedArrays[midIndex - 1]) / 2;
			return median;
		} else {
			// If odd, return the middle element as the median
			return mergeTwoSortedArrays[midIndex];
		}
	}

	/**
	 * Merges two sorted arrays into a single sorted array.
	 * 
	 * @param arr1 The first sorted array.
	 * @param arr2 The second sorted array.
	 * @return The merged sorted array.
	 */
	private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		// Get the lengths of the input arrays
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		// Create an array to store the merged result
		int[] mergedArray = new int[arr1Length + arr2Length];
		// Initialize indices for arr1, arr2, and mergedArray
		int index1 = 0, index2 = 0, mergedIndex = 0;
		// Merge the arrays while maintaining sorted order
		while (index1 < arr1Length && index2 < arr2Length) {
			if (arr1[index1] < arr2[index2]) {
				// If the element in arr1 is smaller, add it to mergedArray
				mergedArray[mergedIndex++] = arr1[index1++];
			} else {
				// If the element in arr2 is smaller, add it to mergedArray
				mergedArray[mergedIndex++] = arr2[index2++];
			}
		}
		// Copy any remaining elements from arr1 to mergedArray
		while (index1 < arr1Length) {
			mergedArray[mergedIndex++] = arr1[index1++];
		}
		// Copy any remaining elements from arr2 to mergedArray
		while (index2 < arr2Length) {
			mergedArray[mergedIndex++] = arr2[index2++];
		}
		// Return the final merged and sorted array
		return mergedArray;
	}

	/**********************************************************/
	// q3
	/**
	 * Concatenates two strings in a way to minimize lexicographical order.
	 * 
	 * @param st1 The first string.
	 * @param st2 The second string.
	 * @return The lexicographically minimal concatenated string.
	 */
	public static String minimalSt(String st1, String st2) {
		// Call the helper method to find the minimal concatenated string
		return minimalStHelper(st1.toCharArray(), st2.toCharArray(), 0, 0, "");
	}

	private static String minimalStHelper(char[] st1, char[] st2, int index1, int index2, String current) {
		// Base case: if either of the strings is exhausted, return the current combined
		if (index1 == st1.length || index2 == st2.length) {
			return current + new String(st1, index1, st1.length - index1)
					+ new String(st2, index2, st2.length - index2);
		}
		// Case 1: characters at the current indices match
		if (st1[index1] == st2[index2]) {
			return minimalStHelper(st1, st2, index1 + 1, index2 + 1, current + st1[index1]);
		}
		// Case 2: try moving ahead in the first string
		String result1 = minimalStHelper(st1, st2, index1 + 1, index2, current + st1[index1]);
		// Case 3: try moving ahead in the second string
		String result2 = minimalStHelper(st1, st2, index1, index2 + 1, current + st2[index2]);
		// Return the shorter of the two results
		return (result1.length() <= result2.length()) ? result1 : result2;
	}

	/**********************************************************/
	// q4
	/**
	 * Finds the maximum length of a snake sequence in a matrix.
	 * 
	 * @param matrix The matrix containing integer values.
	 * @return The maximum length of a snake sequence.
	 */
	public static int maxSnake(int[][] matrix) {
		// Get the number of rows and columns in the matrix
		int rows = matrix.length;
		int cols = matrix[0].length;
		// Create a boolean matrix to track visited cells
		boolean[][] visited = new boolean[rows][cols];
		// Find the length of the longest snake starting from the top-left cell
		int length = findLongestSnake(matrix, 0, 0, visited);
		// Return the length of the longest snake or a default value if no snake is
		// found
		return length > 1 ? length : Integer.MIN_VALUE;
	}

	/**
	 * Checks if the given indices represent neighbors in the matrix.
	 * 
	 * @param i    The row index.
	 * @param j    The column index.
	 * @param rows The number of rows in the matrix.
	 * @param cols The number of columns in the matrix.
	 * @return True if the indices represent neighboring cells; otherwise, false.
	 */
	private static boolean isNeighbor(int i, int j, int rows, int cols) {
		return i >= 0 && i < rows && j >= 0 && j < cols;
	}

	/**
	 * Recursively finds the length of the longest snake sequence in the matrix.
	 * 
	 * @param matrix  The matrix containing integer values.
	 * @param i       The current row index.
	 * @param j       The current column index.
	 * @param visited A boolean matrix to track visited cells.
	 * @return The length of the longest snake sequence.
	 */
	private static int findLongestSnake(int[][] matrix, int i, int j, boolean[][] visited) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		// Base case: if the last cell is reached
		if (i == rows - 1 && j == cols - 1) {
			return 1; // Reached the last cell
		}
		// Mark the current cell as visited
		visited[i][j] = true;
		int maxLength = 0;
		// Define possible directions to move: up, down, left, right
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// Explore each direction
		for (int[] dir : directions) {
			int ni = i + dir[0];
			int nj = j + dir[1];
			// Check if the neighbor is valid and has not been visited
			if (isNeighbor(ni, nj, rows, cols) && !visited[ni][nj] && Math.abs(matrix[i][j] - matrix[ni][nj]) <= 1) {
				// Recursively find the length of the snake sequence
				int length = 1 + findLongestSnake(matrix, ni, nj, visited);
				maxLength = Math.max(maxLength, length);
			}
		}
		// Backtrack: Mark the current cell as not visited
		visited[i][j] = false;
		// Return the length of the longest snake sequence from the current cell
		return maxLength;
	}

}
