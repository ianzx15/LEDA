package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++){
			for (int j = i; j < rightIndex; j++ ){
				if ((array[i].compareTo(array[j + 1]) > 0)){
					Util.swap(array,i,j + 1);
					System.out.println(Arrays.toString(array) + " i = " + i + " j = " + j);
				}
			}
		}
	}
}
