package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length != 0) {
			Integer[] listaFatia = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
			int max = Collections.max(Arrays.asList(listaFatia));
			int min = Collections.min(Arrays.asList(listaFatia));
			int[] frequencia = new int[max - min + 1];
			Integer[] copiaArray = Arrays.copyOf(array, array.length);
			for (int j = leftIndex; j <= rightIndex; j++) {
				frequencia[array[j] - min] += 1;
			}
			for (int n = 1; n < frequencia.length; n++) {
				frequencia[n] = frequencia[n] + frequencia[n - 1];
			}
			for (int i = rightIndex; i >= leftIndex; i--) {
				array[frequencia[copiaArray[i] - min] - 1 + leftIndex] = copiaArray[i];
				frequencia[copiaArray[i] - min] -= 1;
			}
		}
	}

}
