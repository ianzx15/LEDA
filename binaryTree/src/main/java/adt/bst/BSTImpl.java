package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height(){
		return heightAux(this.root);
	}

	private int heightAux(BSTNode node) {
		if (!node.isEmpty()){
			return 1 + Math.max(heightAux((BSTNode) node.getLeft()), heightAux((BSTNode) node.getRight()));
		} else {
			return -1;
		}

	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode aux = null;
		if (element != null && !this.isEmpty()){
			aux = auxSearch(element, this.root);
		}
		return aux;
	}


	private BSTNode auxSearch(T element, BSTNode node){
		BSTNode var = null;
		if (!element.equals(node.getData())) {
			if (!node.isEmpty() && element.compareTo((T) node.getData()) > 0){
				auxSearch(element, (BSTNode) node.getRight());
			} else if (!node.isEmpty() && element.compareTo((T) node.getData()) < 0){
				auxSearch(element, (BSTNode) node.getLeft());
			}
			var = node;
		}
		return var;
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			auxInsert(element, this.root);
		}
	}


	private void auxInsert(T element, BSTNode aux){
		if (aux.isEmpty()) {
			aux.setData(element);
			aux.setRight(new BSTNode.Builder().parent(aux).build());
			aux.setLeft(new BSTNode.Builder().parent(aux).build());
		} else {
			if ((element.compareTo((T) aux.getData()) > 0)) {
				auxInsert(element, (BSTNode) aux.getRight());
			} else {
				auxInsert(element, (BSTNode) aux.getLeft());
			}
		}
	}


	@Override
	public BSTNode<T> maximum() {
		BSTNode aux = this.root;
		if (!this.root.isEmpty()){
			maximumAux(aux);
		}
		return aux;
	}

	private BSTNode maximumAux(BSTNode aux){
		if (!aux.getRight().isEmpty()){
			maximumAux((BSTNode) aux.getRight());
		}
		return aux;
	}

	public BSTNode<T> minimum(){
		BSTNode aux = this.root;
		if (!this.isEmpty()){
			minimumAux(aux);
		}
		return aux;
	}

	private BSTNode<T> minimumAux(BSTNode aux) {
		if (!aux.getLeft().isEmpty()){
			minimumAux((BSTNode) aux.getLeft());
		}
		return aux;
	}


	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode auxElement = search(element);
		if (auxElement != null && !this.root.isEmpty() && !auxElement.isEmpty()){
			if (auxElement.getRight() != null){
				auxElement = ((BST<T>) auxElement).minimum();
			} else{
				auxElement = (BSTNode) auxElement.getParent();
			}
			while(!auxElement.getParent().isEmpty() && element.compareTo((T) auxElement.getParent().getData()) < 0){
				auxElement = (BSTNode) auxElement.getParent().getData();
			}
		}
		return auxElement;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode aux = search(element);
		if (!this.isEmpty() && element != null && aux != null ){
			if (!aux.getLeft().isEmpty()){
				aux = maximum();
			} else{
				while (!aux.getParent().isEmpty() && element.compareTo((T) aux.getParent().getData()) < 0 ){
					aux = (BSTNode) aux.getParent();
				}
			}
		}
		return  aux;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];

		auxPreOrder(this.root, 0, array);
		return array;
	}

	private T[] auxPreOrder(BSTNode node, int i, T[] array){
		if (!node.isEmpty()){
			array[i] = (T) node.getData();
			auxPreOrder(((BSTNode) node.getLeft()), i + 1, array);
			auxPreOrder(((BSTNode) node.getRight()), i + 1, array);
		}
		return  array;
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];

		auxOrder(this.root, 0, array);
		return array;
	}


	private T[] auxOrder(BSTNode node, int i , T[] array){
		if (!node.isEmpty()){
			auxOrder(((BSTNode) node.getLeft()), i + 1, array);
			array[i] = (T) node.getData();
			auxOrder(((BSTNode) node.getRight()), i+ 1, array);

		}
		return  array;
	}


	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];

		auxPostOrder(this.root, 0, array);
		return array;

	}

	private T[] auxPostOrder(BSTNode node, int i , T[] array){
		if (!node.isEmpty()){
			auxOrder(((BSTNode) node.getLeft()), i + 1, array);
			auxOrder(((BSTNode) node.getRight()), i+ 1, array);
			array[i] = (T) node.getData();

		}
		return array;
	}




	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
