package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T element = null;
		PriorityQueue<T> heap = new PriorityQueue<T>();
		if (array.length > 0 && k <= array.length){

			for (int i = 0; i <= array.length -1; i++){
				heap.add(array[i]);
			}
			for (int i = 1 ; i <= k -1; i++){
				heap.remove();
			}

			element = heap.peek();
		}
		return heap.peek();
	}

}
