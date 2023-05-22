package adt.linkedList;

import java.util.Arrays;

import javax.annotation.Generated;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


	public DoubleLinkedListImpl(){
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insert (T element){
			if (element != null){
				DoubleLinkedListNode newLast = new DoubleLinkedListNode<>();

				newLast.setData(element);
				newLast.setPrevious(getLast());
				newLast.setNext(new DoubleLinkedListNode<>());

				this.getLast().setNext(newLast);

				if (getLast().isNIL()){
					this.setHead(newLast);
				}
				this.setLast(newLast);
		}
	}

	@Override
	public void remove(T element){
		if (element != null){
			if (search(element) != null){
				if (getHead().getData().equals(element)){
					this.removeFirst();
				} else if (getLast().getData().equals(element)){
					this.removeLast();
				} else{
					DoubleLinkedListNode node = (DoubleLinkedListNode) getHead();
					while (!node.equals(element) && !node.isNIL()){
						node = (DoubleLinkedListNode) node.getNext();
					}
					if (node.equals(element)){
						node.getPrevious().setNext(node.getNext());
						((DoubleLinkedListNode) node.getNext()).setPrevious(node.getPrevious());
					}
					if (this.isEmpty()){
						this.setHead(this.getLast());
						this.setLast((DoubleLinkedListNode<T>) this.getHead());
					}
				}
			}
			} 
	}


	@Override
	public void insertFirst(T element) {
		if (element != null){
			DoubleLinkedListNode newHead = new DoubleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(getHead());
			newHead.setPrevious(new DoubleLinkedListNode<>());

			((DoubleLinkedListNode) this.head).setPrevious(newHead); 
			if (getHead().isNIL()){
				setLast(newHead);
			}
			setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if (!getHead().isNIL()){
		}

		if (!this.isEmpty()){
			getHead().setData(null);
			setHead(getHead().getNext());
			getHead().setNext(null);
			((DoubleLinkedListNode<T>) getHead().getNext()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()){
			getLast().setData(null);
			getLast().setNext(null);
			getLast().getPrevious().setNext(new DoubleLinkedListNode<>());
			if (this.isEmpty()){
				setHead(getLast());
			}
			setLast(getLast().getPrevious());
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
