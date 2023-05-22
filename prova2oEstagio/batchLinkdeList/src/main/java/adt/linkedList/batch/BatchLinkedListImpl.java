package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!! 
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/* 
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>)head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		// TODO IMPLEMENTAR seguindo a documentação da interface e remover a linha abaixo
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		// TODO IMPLEMENTAR seguindo a documentação da interface e remover a linha abaixo
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>)getHead();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result += " ";
			}
				
			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();
			
		}
		
		return result;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead() 
	 * 
	 */
	public String toStringFromLast() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result = " " + result;
			}
				
			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return toStringFromHead();
	}


}
