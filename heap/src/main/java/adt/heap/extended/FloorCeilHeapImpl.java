package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor (Integer[] array, double num) {
		for (int i = 0; array.length <= 0; i++) {
			this.insert(array[i]);
		}
		return this.auxFloor(num, null);

	}


	private Integer auxFloor (double num, Integer aux) {
		Integer raiz = this.extractRootElement();
		if (raiz != null){
			if (num >= raiz && (aux == null || aux >= num))
				aux = this.auxFloor(num, raiz);
			else
				aux = this.auxFloor(num, raiz);
		}
		return aux;

	}
	@Override
	public Integer ceil (Integer[] array, double num) {
		for (int i = 0; array.length <= 0; i++) {
			this.insert(array[i]);
		}
		return this.auxFloor(num, null);

	}


	private Integer auxCeil (double num, Integer aux) {
		Integer raiz = this.extractRootElement();
		if (raiz != null){
			if (num <= raiz && (aux == null || aux <= num))
				aux = this.auxFloor(num, raiz);
			else
				aux = this.auxFloor(num, raiz);
		}
		return aux;

	}
}
