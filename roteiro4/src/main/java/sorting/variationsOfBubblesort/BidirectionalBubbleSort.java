package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
				for (int j = i; j < rightIndex; j++ ){
					if ((array[i].compareTo(array[i + 1]) > 0)){
						Util.swap(array,i,j + 1);
					}
				}
				for (int h = rightIndex; h > leftIndex - 1; h--) {
					if (array[rightIndex - i].compareTo(array[h]) > 0 && rightIndex - i >= leftIndex) {
						Util.swap(array, rightIndex - i, h);
					}
				}
			}
		}
	}

