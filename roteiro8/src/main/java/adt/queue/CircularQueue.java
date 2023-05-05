package adt.queue;

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
		}if (isEmpty()){
			head++;
		} else{
			tail = (tail + 1) % array.length ;
			array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (head == -1){
			throw new QueueUnderflowException();
		} else{
			result = array[head];
			head++;
		}
		return result;
	}

	@Override
	public T head() {
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.tail > this.head + 1;
	}

	@Override
	public boolean isFull() {
		return (this.tail + 1) % array.length == this.head;
	}

}
