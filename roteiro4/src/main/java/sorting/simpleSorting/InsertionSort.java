package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = 1; i <= rightIndex; i++){
			for (int j = rightIndex; j > leftIndex; j --){
				if (j > leftIndex && array[j - 1].compareTo(array[j]) > 0) {
					Util.swap(array, j, j - 1);
					j -= 1;
				}
			}
		}


	}
}
