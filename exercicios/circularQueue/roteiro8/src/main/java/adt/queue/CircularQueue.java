package adt.queue;

import java.util.Arrays;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
		this.head = -1;
		this.elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()){
			if (isEmpty()){
				this.head++;
				this.tail++;
				this.array[this.head] = element;
				this.elements++;
			} else{
				this.tail ++;
				this.array[this.tail] = element;
				this.elements++;
			}
		} else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element = null;
		if (!isEmpty()){
			element = this.array[this.head];
			this.array[this.head] = null;
			this.elements--;
			this.head++;
		} else{
			throw new QueueUnderflowException();
		}
		return element;
	}

	@Override
	public T head() {
		T element = null;
		if (!isEmpty()){
			element = this.array[this.head];
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}

}
