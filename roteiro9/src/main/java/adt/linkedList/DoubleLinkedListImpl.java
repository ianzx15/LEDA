package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


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
				this.head = this.head.getNext();
		}
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			this.last.setNext(this.last.getPrevious());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
