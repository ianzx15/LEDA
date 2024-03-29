package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

		queue3.enqueue(15);


	}


	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new CircularQueue<>(4);
		queue2 = new CircularQueue<>(2);
		queue3 = new CircularQueue<>(5);
		queue4 = new CircularQueue<>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() throws QueueOverflowException, QueueUnderflowException {
		assertEquals(new Integer(1), queue1.head());

		queue4.enqueue(5);
		assertEquals(new Integer(5), queue4.head());
		queue4.dequeue();
		queue4.head();



	}

	@Test
	public void testIsEmpty() {
		//TESTAR COM APENAS UM ELEMENTO
		assertFalse(queue1.isEmpty());
		assertFalse(queue3.isEmpty());
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertFalse(queue1.isFull());
		assertFalse(queue4.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
			queue4.enqueue(1);
			
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue((5));
		queue1.enqueue((6));
		queue1.enqueue((7));
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
			assertEquals(new Integer(2), queue1.dequeue());
			assertEquals(new Integer(15), queue3.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException, QueueOverflowException {
		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
		queue4.dequeue();


	}
}