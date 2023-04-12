package sorting.divideAndConquer;

import sorting.AbstractSorting;

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
			sort(array, rightIndex, mid + 1);
			merge(array, leftIndex, mid, rightIndex);
		}
		}

	public void merge(T[] array2, int left, int mid, int right){
		int i = left;
		int j = mid + 1;
		int k = right;
		T[] aux = (T[]) new Object[array2.length];

		while (i <= j && j <= right){
			if (aux[k].compareTo(aux[j]) < 0){
				array2[k] = aux[i];
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
			j++;
		}
		while (j <= right){
			array2[k] = aux[j];
			i++;
			j++;
		}
	}


	}
