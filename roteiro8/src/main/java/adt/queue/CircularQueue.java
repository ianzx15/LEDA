package adt.queue;

import java.util.Arrays;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} if (isEmpty()){
			head++;
		}
		tail = (tail + 1) % array.length ;
		array[tail] = element;

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		if (head == tail){
			result = array[head];
			head = -1;
			tail = -1;
		} else{
			result = array[head];
			head = (head + 1) % array.length;
		}
		return result;
	}

	@Override
	public T head() {
		if (head == -1){
			return null;
		}
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return head == -1;
	}

	@Override
	public boolean isFull() {
		if (head == 0 && tail == array.length - 1){
			return true;
		}if( head == tail && array.length == 1 && head != -1 && tail != -1){
			return  true;
		}
		return false;
	}

}
