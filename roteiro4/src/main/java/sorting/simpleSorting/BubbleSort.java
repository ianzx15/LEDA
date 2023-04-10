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
			for (int j = leftIndex; j < rightIndex  - i; j++ ){
				System.out.println("i ==" + i);
				System.out.println(Arrays.toString(array) + " j = " + j + "/// j + 1 = " + (j + 1));
				if ((array[j].compareTo(array[j + 1]) > 0)){
					Util.swap(array,j,j + 1);
				}
			}
		}
	}
}
