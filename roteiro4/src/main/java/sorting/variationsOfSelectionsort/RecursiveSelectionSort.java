package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int min = leftIndex;
		for (int i = leftIndex; i < rightIndex; i++) {
			if (array[min].compareTo(array[i + 1]) > 0) {
				min = i + 1;
			}
		}
		if (leftIndex < rightIndex){
			Util.swap(array, min , leftIndex);
			sort(array, leftIndex + 1, rightIndex);
		}
	}


}
