package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element){
		if (element != null){
			if (this.isEmpty()){
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl) this.getNext()).setPrevious(this);
			} else{
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null){
			if (isEmpty()){
				this.setNext(new RecursiveDoubleLinkedListImpl());
				this.setData(element);
				this.setPrevious(new RecursiveDoubleLinkedListImpl());
			} else{
				RecursiveDoubleLinkedListImpl newItem = new RecursiveDoubleLinkedListImpl();
				newItem.setData(this.getData());
				newItem.setNext(this.getNext());
				this.setNext(newItem);
				this.setData(element);
				newItem.setPrevious(this);
				((RecursiveDoubleLinkedListImpl) newItem.getNext()).setPrevious(newItem);
			}
		}
	}

	@Override
	public void removeFirst() {
			if (!isEmpty()){
				if (this.getNext().isEmpty()){
					this.setPrevious(null);
					this.setData(null);
					this.setNext(null);
				} else{
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
				}

			}

	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
