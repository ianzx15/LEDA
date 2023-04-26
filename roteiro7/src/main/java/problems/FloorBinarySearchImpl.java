package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {
	//BUSCA BINARIA NORMAL MAS SE NÃO ENCONTRAR NA LISTA ELE PROCURA O FLOOR
	@Override
	public Integer floor(Integer[] array, Integer x) {
		int m = array.length / 2;
		if (array.length == 1){
			return false;
		}

		if (x == array[m]){
			return m;
		}

		if(x < array[m]){
			floor(array, x - 1);

		}
		
		return null;

	}

	@Override
	public void sort(Object[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex){
			int index_pivot = partition(array,leftIndex,rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}

	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){
		Integer pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++){
			if (array[j].compareTo(pivot) <= 0){
				i++;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[5];
	}



}
