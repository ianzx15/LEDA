package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


	public DoubleLinkedListImpl(){
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) head;
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
		if (!isEmpty()){
			setLast(null);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
