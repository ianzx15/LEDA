package sorting.linearSorting;

import sorting.AbstractSorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length != 0) {
			Integer[] listaFatia = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
			int max = Collections.max(Arrays.asList(listaFatia));
			int[] frequencia = new int[max + 1];
			Integer[] copiaArray = Arrays.copyOf(array, array.length);
			for (int j = leftIndex; j <= rightIndex; j++) {
				frequencia[array[j]] += 1;
			}
			for (int n = 1; n < frequencia.length; n++) {
				frequencia[n] = frequencia[n] + frequencia[n - 1];
			}
			for (int i = rightIndex; i >= leftIndex; i--) {
				array[frequencia[copiaArray[i]] - 1 + leftIndex] = copiaArray[i];
				frequencia[copiaArray[i]] -= 1;
			}
		}
	}
}
