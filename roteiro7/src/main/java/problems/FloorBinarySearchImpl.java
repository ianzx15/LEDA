package problems;

import util.Util;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length -1);
		int b = binarySearch(array, x, 0 , array.length - 1);
		return b;
	}

	private int binarySearch(Integer[] array, int num, int left, int right){
		if (left > right) {
			return -1;
		}

		int m = (right + left)/ 2;

		if (left == right){
			if (num >= array[m]){
				return m;
			}else {
				return m - 1;
			}
		} else if(m == 0 && num < array[m]){
			return  - 1;
		} else if(num < array[m]){
			return binarySearch(array, num, left, m);
		} else if (num > array[m]){
			return  binarySearch(array, num, m + 1, right);
		} else {
			return m;
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

}
