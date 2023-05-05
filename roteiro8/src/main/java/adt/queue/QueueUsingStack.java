package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		}
		try{
			stack1.push(element);
		} catch (StackOverflowException e){
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T removido = null;
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			removido = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackUnderflowException | StackOverflowException e){
			e.printStackTrace();
		}
		return removido;
	}

	@Override
	public T head() {
		T removido = null;
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			removido = stack2.top();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackUnderflowException | StackOverflowException e){
			e.printStackTrace();
		}
		return removido;
	}

	@Override
	public boolean isEmpty() {
		if (stack1.isEmpty()){
			return true;
		} else{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (stack1.isFull()){
			return true;
		}else {
			return false;
		}
	}

}
