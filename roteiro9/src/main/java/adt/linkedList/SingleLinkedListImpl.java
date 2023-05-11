package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		if (this.head.data != null){
			SingleLinkedListNode aux = this.head;

			while (aux.getData() != null) {
				aux = aux.next;
				size++;
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			SingleLinkedListNode aux = this.head;
			while (!aux.isNIL()) {
				if (aux.getData().equals(element)) {
					result = element;
					break;
				}
				aux = aux.next;
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			SingleLinkedListNode auxHead = this.head;
			if (isEmpty()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, this.head);
				this.head = newHead;
		} 	else{
				while (auxHead.getNext() != null){
					auxHead = auxHead.next;
				}
				auxHead.data = element;
				auxHead.next = new SingleLinkedListNode<>();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			SingleLinkedListNode aux = this.head;
			if(search(element) != null){
				while (!aux.isNIL() && !aux.data.equals(element)) {
						aux.data = aux.next.data;
						aux.next = aux.next.next;
					}
			}
		}

	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
