package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex){
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
		}

	private void merge(T[] array2, int left, int mid, int right){
		int i = left;
		int j = mid + 1;
		int k = left;
		T[] aux = Arrays.copyOf(array2,array2.length);

		while (i <= mid && j <= right){
			if (aux[i].compareTo(aux[j]) <= 0){
				array2[k] = aux[i];
				i++;
			}
			else{
				array2[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= mid){
			array2[k] = aux[i];
			i++;
			k++;
		}
		while (j <= right){
			array2[k] = aux[j];
			j++;
			k++;
		}
	}


	}
