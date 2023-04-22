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
		Integer[] maxFatia = Arrays.copyOfRange(array, leftIndex, rightIndex);
		int max = Collections.max(Arrays.asList(maxFatia));
		int[] frequencia = new int[max];
		Integer[] copiaArray = Arrays.copyOf(array, array.length);
		System.out.println(Arrays.toString(array));
		for (int j = leftIndex; j < rightIndex; j++) {
			frequencia[array[j] - 1] += 1;
		}
		for (int n = 1; n < frequencia.length; n++){
			frequencia[n] = frequencia[n] + frequencia[n - 1];
		}
		for (int i = rightIndex - 1; i >= leftIndex; i--){
			array[frequencia[copiaArray[i] - 1] - 1] = copiaArray[i];
			frequencia[copiaArray[i] - 1] -= 1;
		}
		System.out.println(Arrays.toString(array));


//		Integer[] maxFatia = Arrays.copyOfRange(array, leftIndex, rightIndex);
//		int max = Collections.max(Arrays.asList(maxFatia));
//		int[] frequencia = new int[max];
//		int[] copiaArray = new int[array.length];
//		System.out.println(Arrays.toString(array));
//		for (int j = leftIndex; j < rightIndex; j++) {
//			frequencia[array[j] - 1] += 1;
//		}
//		for (int n = 1; n < frequencia.length; n++){
//			frequencia[n] = frequencia[n] + frequencia[n - 1];
//		}
//		for (int i = rightIndex -1; i >= leftIndex; i--){
//			copiaArray[frequencia[array[i] - 1] - 1] = array[i];
//			frequencia[array[i] - 1] -= 1;
//		}
//		System.out.println(Arrays.toString(copiaArray));
	}
}
