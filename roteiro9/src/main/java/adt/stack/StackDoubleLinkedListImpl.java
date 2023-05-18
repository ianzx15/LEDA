package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedListImpl<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()){
			this.top.insert(element);
		} else {
			throw new StackOverflowException();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		T element = null;
		if (!isEmpty()){
			element = (T) this.top.getLast().getData();
			this.top.removeLast();
		} else {
			throw new StackUnderflowException();
		}
		return element;
	}

	@Override
	public T top() {
		return (T) this.top.getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
