package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

import java.lang.reflect.Array;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedListImpl<T> list;
	protected int size;
	protected int elements;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null){
			DoubleLinkedListNode node = new DoubleLinkedListNode<>();
			if (isFull()){
				throw new QueueOverflowException();
			}

			if (isEmpty()){
				node.setData(element);
				this.list.setHead(node);
				this.list.setLast((DoubleLinkedListNode<T>) this.list.getHead());
			} else if (!isEmpty()){
				node.setData(element);
				this.list.getLast().setNext(node);
				node.setPrevious(this.list.getLast());
				this.list.setLast(node);
				this.list.getLast().setNext(this.list.getHead());
				((DoubleLinkedListNode) this.list.getHead()).setPrevious(this.list.getLast());
				
			}
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element = null;
		 if (isEmpty()){
			 throw new QueueUnderflowException();
		 } else{
			element = this.list.getHead().getData();
			this.list.setHead(this.list.getHead().getNext());
			((DoubleLinkedListNode) this.list.getHead()).setPrevious(this.list.getLast());
			this.list.getLast().setNext(this.list.getHead());
			this.elements--;
		}
		return element;
	}

	@Override
	public T head() {
		return this.list.getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.size;
	}

}
