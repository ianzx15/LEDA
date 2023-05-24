package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return getData() == null;
	}

	@Override
	public int size() {
		int i = 0;
		if (!this.isEmpty()){
			i = 1 + this.getNext().size();
		}
		return i;
	}

	@Override
	public T search(T element) {
		if (element != null){
			if (isEmpty()){
				element = null;
			} else{
				if (getData() == null){
					element = null;
				} else if(getData() != null && !getData().equals(element)) {
					element = getNext().search(element);
				}
			}
		}
		return element;
	}

	@Override
	public void insert(T element) {
		if (element != null){
			if (this.isEmpty()){
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<>());
			} else{
				this.getNext().insert(element);
			}
		}
	}


	@Override
	public void remove(T element) {
			if (!getNext().isEmpty()){
				getNext().remove(element);
			} else{
				setData(getNext().getData());
				setNext(getNext().getNext());
			}
	}

	@Override
	public T[] toArray() {
		int len = size();
		T[] arrayAux = (T[]) new Object[len];
		return 	auxToArray(arrayAux, 0, len);

	}

	private T[] auxToArray(T[] array, int i, int size) {
		if (i < size){
			array[i] = getData();
			getNext().auxToArray(array, i + 1, size);
		}
		return array;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
