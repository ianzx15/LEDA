package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex){
			int midPivot = (leftIndex + rightIndex) / 2;
			ordenaPivot(array, leftIndex, midPivot, rightIndex);
			int newPivot = partition(array,leftIndex + 1,rightIndex - 1);
			sort(array, leftIndex, newPivot - 1);
			sort(array, newPivot + 1, rightIndex);
		}
	}

	private void ordenaPivot(T[] array, int left, int mid, int right){
		if (array[right].compareTo(array[left]) < 0){
			Util.swap(array, left, right);
		}
		if (array[mid].compareTo(array[left]) < 0){
			Util.swap(array, left, mid);
		}
		if (array[right].compareTo(array[mid]) < 0){
			Util.swap(array, mid, right);
		}
		Util.swap(array, mid, right - 1);
	}
	private int partition(T[] array, int leftIndex, int rightIndex){
		T pivot = array[rightIndex];
		int i = rightIndex;
		for (int j = rightIndex - 1; j >= leftIndex; j--){
			if (array[j].compareTo(pivot) >= 0){
				i--;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array,i, rightIndex);
		return i;
	}
}
