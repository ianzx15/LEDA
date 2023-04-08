package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class oddEvenBubblesort<T extends Comparable<T>> extends AbstractSorting<T>{
    public void sort(T[] array, int leftIndex, int rightIndex){
        for (int i = leftIndex; i <= rightIndex; i++){
            for (int j = leftIndex; j < rightIndex; j+= 2){
                if (array[j].compareTo(array[j + 1]) > 0){
                    Util.swap(array, j, j +1);
                }
            }

            for (int h = leftIndex + 1; h < rightIndex; h+= 2){
                if (array[h].compareTo(array[h + 1]) > 0){
                    Util.swap(array, h, h +1);
                }
            }
        }
    }
}
