package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++){
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null){
			if (isFull()){
				throw new QueueOverflowException();
			}else{
				this.tail++;
				this.array[this.tail] = element;
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = head();
		if (isEmpty()){
			throw new QueueUnderflowException();
		}else{
			shiftLeft();
			tail--;
		}
		return result;
	}

}
