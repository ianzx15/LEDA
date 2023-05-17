package adt.linkedList;

import java.util.Arrays;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


	public DoubleLinkedListImpl(){
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insert (T element){
		if(element != null){
			if (isEmpty()){
				getHead().setNext(new DoubleLinkedListNode<>());
				getHead().setData(element);

			} else{
				DoubleLinkedListNode newLast = new DoubleLinkedListNode(element, new DoubleLinkedListNode(), getLast() );
				getLast().setNext(newLast);
				setLast(newLast);
			}
		}
	}

	@Override
	public void remove(T element){
		if (element != null) {
			if (getHead().getData().equals(element)) {
				this.removeFirst();
			} else if (getLast().getData().equals(element)) {
				this.removeLast();
			} else{
				DoubleLinkedListNode aux = (DoubleLinkedListNode) head;
				while (!aux.isNIL() && !aux.getData().equals(element)){
					aux = (DoubleLinkedListNode) aux.getNext();
				}
				if (!aux.isNIL()){
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}


	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode newHead = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
		if (isEmpty()){
			this.head = newHead;
			this.last = newHead;
		} else{
			newHead.setNext(this.head);
			this.head = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()){
			setHead(getHead().getNext());
			if (isEmpty()){
				setLast((DoubleLinkedListNode<T>) getHead());
			}
			((DoubleLinkedListNode<T>) getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			getLast().getPrevious().setNext(new DoubleLinkedListNode<>());
			setLast(getLast().getPrevious());
			if (getLast().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
