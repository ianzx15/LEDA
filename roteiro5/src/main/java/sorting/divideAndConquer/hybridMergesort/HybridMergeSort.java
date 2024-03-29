package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4 ;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if ((rightIndex - leftIndex) >= SIZE_LIMIT){
			int mid = (rightIndex + leftIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
			MERGESORT_APPLICATIONS ++;
		} else{
			insertion(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		}

		}
	public void insertion(T[] array, int leftIndex, int rightIndex) {
		for (int i = 0; i <= rightIndex; i++) {
			for (int j = rightIndex; j > leftIndex; j--) {
				if (j > leftIndex && array[j - 1].compareTo(array[j]) > 0) {
					Util.swap(array, j, j - 1);
					j -= 1;
				}
			}
		}
	}

	private void merge (T[]array2,int left, int mid, int right){
		int i = left;
		int j = mid + 1;
		int k = left;
		T[] aux = Arrays.copyOf(array2, array2.length);

		while (i <= mid && j <= right) {
			if (aux[i].compareTo(aux[j]) <= 0) {
				array2[k] = aux[i];
				i++;
			} else {
				array2[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			array2[k] = aux[i];
			i++;
			k++;
		}
		while (j <= right) {
			array2[k] = aux[j];
			j++;
			k++;
		}
	}
	}
