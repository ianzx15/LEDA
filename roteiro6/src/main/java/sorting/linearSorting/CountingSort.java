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
		int max = Collections.max(Arrays.asList(array));
		int[] frequencia = new int[max];
		populaListaAuxiliar(array, frequencia);
	}

	public void populaListaAuxiliar(Integer[] array, int[] frequencia){
		for (int j = 0; j <  array.length; j++){
				frequencia[array[j] - 1] += 1;
		}
		System.out.println(Arrays.toString(frequencia));
	}

}
