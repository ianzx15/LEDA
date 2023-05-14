package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(5);
		lista1.insert(10);
		lista1.insert(122);

	}

	private void getImplementations() {
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(null == lista1.search(null));
		Assert.assertTrue(5 == lista1.search(5));
		lista2.insert(33);
		lista2.insert(54);
		Assert.assertTrue(54 == lista2.search(54));
		Assert.assertTrue(33 == lista2.search(33));

		Assert.assertNull(lista1.search(4));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(98);
		Assert.assertEquals(4, lista1.size());
		lista1.remove(122);
		Assert.assertEquals(3, lista1.size());
		lista1.remove(5);
		Assert.assertEquals(2, lista1.size());
		lista1.remove(10);
		Assert.assertEquals(1, lista1.size());
		lista1.remove(98);
		Assert.assertEquals(0, lista1.size());
		lista2.insert(8);
		Assert.assertEquals(1, lista2.size());
		lista2.remove(8);
		Assert.assertEquals(0, lista2.size());


	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 5, 10, 122}, lista1.toArray());
		lista1.remove(122);
		Assert.assertArrayEquals(new Integer[] { 5, 10}, lista1.toArray());
		lista1.remove(122);
		lista1.remove(122);
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());


	}
}