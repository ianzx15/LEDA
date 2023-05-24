package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {


	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(5);
		lista1.insert(10);
		lista1.insert(122);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4,5,10,122 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(30);
		Assert.assertArrayEquals(new Integer[] { 30, 4, 5,10,122 }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] {4}, lista2.toArray());



	}

	@Test
	public void testRemoveFirst() {
		//TESTAR QUANDO EXISTEM DOIS ELEMENTOS APENAS HEAD E LAST     OK
		//QUANDO EXISTE APENAS UM ELEMENTO LAST = HEAD                OK

		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {10,122}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		((DoubleLinkedList<Integer>) lista1).insertFirst(97);
		Assert.assertArrayEquals(new Integer[] {97,122}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {122}, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 5,10 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {5}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
	}
}