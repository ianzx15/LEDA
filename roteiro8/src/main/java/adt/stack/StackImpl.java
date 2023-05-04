package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return this.array[this.top];
	}

	@Override
	public boolean isEmpty() {
		if (this.top == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.top == array.length - 1){
			return true;
		}
		return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		} else{
			this.top++;
			this.array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result = this.array[top];
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			this.array[top] = null;
			this.top--;
		}
		return result;
	}

}
