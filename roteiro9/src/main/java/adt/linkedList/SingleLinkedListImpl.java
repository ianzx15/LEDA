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
		if (!this.head.isNIL()){
			SingleLinkedListNode aux = this.getHead();

			while (!aux.isNIL()) {
				aux = aux.getNext();
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
				aux = aux.getNext();
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
				while (!auxHead.isNIL()){
					auxHead = auxHead.getNext();
				}
				auxHead.data = element;
				auxHead.next = new SingleLinkedListNode<>();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			SingleLinkedListNode aux = getHead();
			if (getHead().equals(element)){
				setHead(getHead().getNext());
			} else{
				while (!aux.next.isNIL() && !aux.getData().equals(element)) {
					aux = aux.getNext();
				}
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}

	}

	@Override
	public T[] toArray() {
		int i = 0;
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode aux = this.head;
		while (i < size()){
			if (!aux.isNIL())
			array[i] = (T) aux.getData();
			aux = aux.getNext();
			i += 1;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
