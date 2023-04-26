package problems;

import util.Util;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length -1);
		int b = binarySearch(array, x, 0 , array.length);

		System.out.println(Arrays.toString(array));
		System.out.println(b);
		return null;
	}

	private int binarySearch(Integer[] array, int num, int left, int right){
		if (left > right) {
			return -1;
		}
		int m = (right + left) / 2;
		//maior que o maior da lista
		if (num > array[m] && left == 1){
			return m;
		}
		// maior que o segundo maior da lista e menor que o primeiro
		if (left == 1 && num < array[m]){
			return m - 1;
		}
		//menor que o menor numero da lista
		if (m == 0 && num < array[m]){
			return -1;
		}

		if (num == array[m]){
			return m;
		}

		if(num < array[m]) {
			return binarySearch(array, num, left, m - 1);
		}
		else{
			return  binarySearch(array, num, m + 1, right);
			}
	}

	private void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex >= leftIndex){
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
		Floor a = new FloorBinarySearchImpl();
		Integer[] array = new Integer[5];
		array[0] = 1;
		array[1] = 10;
		array[2] = 3;
		array[3] = 4;
		array[4] = 2;
		a.floor(array,9 );

	}



}
