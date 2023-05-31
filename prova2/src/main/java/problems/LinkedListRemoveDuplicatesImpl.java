package problems;

import adt.linkedList.SingleLinkedListNode;

import java.util.LinkedList;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        SingleLinkedListNode aux = node;
        while(!aux.isNIL() && !node.isNIL()){
            boolean removed = false;
            while(!node.getNext().isNIL() && !node.getNext().equals(aux)){
                node = node.getNext();
            }
            if (node.getNext().equals(aux)){
                node.setNext(node.getNext().getNext());
                removed = true;
            }
            if (removed){
                node = aux;
            } else{
                aux = aux.getNext();
                node = aux;
            }
        }

    }
}

