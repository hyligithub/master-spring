package com.masterspring.common.demo.org.test.org.easense.sortmethods;

import com.masterspring.common.demo.org.easense.sortmethods.SortType;

import java.util.Arrays;
import java.util.Random;


public class SortingTest {

	// define the array's size
	private final int PROBLEM_SCALE = 10000;

	private boolean checkSorted = true;

	private boolean showDebugInfo = false;

	// @Ignore
	public void selectionSort() {
		sort(SortType.SELECTION);
	}

	// @Ignore
	public void insertionSort() {
		sort(SortType.INSERTION);
	}

	// @Ignore
	public void bubbleSort() {
		sort(SortType.BUBBLE);
	}

	// @Ignore
	public void shellSort() {
		sort(SortType.SHELL);
	}

	// @Ignore
	public void mergeSort() {
		sort(SortType.MERGE);
	}

	// @Ignore
	public void quickSort() {
		sort(SortType.QUICK);
	}

	// @Ignore
	public void heapSort() {
		sort(SortType.HEAP);
	}

	private void sort(SortType sortType) {
		Integer[] array = generateArray(PROBLEM_SCALE);
		if (showDebugInfo) {
			System.out.println("Before: " + Arrays.toString(array));
		}
		sortType.sort(array);
		if (showDebugInfo) {
			System.out.println("After " + sortType.name() + " sort: " + Arrays.toString(array));
		}
		if (checkSorted) {
//			Assert.assertTrue(isSorted(array));
		}
	}

	private Integer[] generateArray(int length) {
		Random rand = new Random();
		Integer[] array = new Integer[length];

		for (int i = 0; i < length; i++) {
			array[i] = rand.nextInt(length * 4);
		}
		return array;
	}

	private <T extends Comparable<T>> boolean isSorted(T[] array) {
		if (array == null || array.length <= 2) {
			return true;
		}

		// record the result of last comparison
		Boolean lastCompare = null;

		for (int i = 1; i < array.length; i++) {
			int compareResult = array[i - 1].compareTo(array[i]);
			if (lastCompare == null || compareResult == 0) {
				if (compareResult != 0) {
					lastCompare = compareResult > 0;
				}
				continue;
			}

			if (compareResult > 0 != lastCompare) {
				return false;
			}
		}

		return true;
	}
}
