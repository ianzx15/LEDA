package adt.linkedList;

import javax.swing.text.html.parser.Element;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element){
		if (this.getData() == null){
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<>());
			((RecursiveDoubleLinkedListImpl) this.getNext()).setPrevious(this);
		} else{
			getNext().insert(element);
		}
		
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();

				newNode.setData(this.getData());
				newNode.setNext(this.getNext());

				this.setData(element);
				this.setNext(newNode);

				newNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) newNode.getNext()).setPrevious(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()){
			if (this.getPrevious() == null && this.getNext() != null){
				setData(getNext().getData());
				setNext(getNext().getNext());
				((RecursiveDoubleLinkedListImpl) this.getNext()).setPrevious(this);
			} else {
				setData(null);
				setNext(null);
				setPrevious(null);
			}
		}
	}

	@Override
	public void removeLast() {
		if (this.getNext().isEmpty()){
			setData(null);
			setNext(null);
		} else{
			((DoubleLinkedList<T>) getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
