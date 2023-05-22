package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

import java.lang.reflect.Array;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedListImpl<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null){
			if (!isFull()){
				list.insert(element);
			} else {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element = null;
		if (!isEmpty()){
			element = (T) this.list.getHead().getData();
			this.list.removeFirst();
		} else {
			throw new QueueUnderflowException();
		}
		return element;
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()){
			result = (T) this.list.getHead().getData();
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.list.size() == this.size;
	}

}
