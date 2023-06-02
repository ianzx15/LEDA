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
		BSTNode aux = this.root;
		if (!aux.isEmpty()){
			if (element != null){
				while (!this.root.isEmpty()){
					if (element.compareTo((T) aux.getData()) > 0) {aux = (BSTNode) aux.getRight();}
					else{
						aux = (BSTNode) aux.getLeft();
					}
				}
			}
		}
		return aux;
	}

	@Override
	public void insert(T element) {

		if (element != null){
			if (this.root.isEmpty()){
				this.root.setData(element);
			} 
			BSTNode aux = this.root;
			while (!aux.isEmpty()){
				if (element.compareTo((T) aux.getData()) > 0 ){
					if (aux.getRight().isEmpty()){
						BSTNode<T> newNode = new BSTNode<T>();
						newNode.setData(element);
						aux.setRight(newNode);
						newNode.setParent(aux);
					}
					aux = (BSTNode) aux.getRight();
				} else{
					if (aux.getLeft().isEmpty()){
						BSTNode<T> newNode = new BSTNode<T>();
						newNode.setData(element);
						aux.setLeft(newNode);
						newNode.setParent(aux);

					}

					aux = (BSTNode) aux.getLeft();
				}
				}
				
			}
		}


	@Override
	public BSTNode<T> maximum() {
		if (this.root.isEmpty()){
			return null;
		}
		return this.root;

	}

	public BSTNode<T> minimum(){
		return minimumAux();
	}

	private BSTNode<T> minimumAux() {
		BSTNode aux = new BSTNode<>();
		if (!this.root.isEmpty()){
			while (!aux.getLeft().isEmpty()){
				aux = (BSTNode) aux.getLeft();
			}
		} else{
			return aux;
		}

	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode auxElement = new BSTNode<>();
		if (element != null){
			if (!auxElement.getRight().isEmpty()){
				auxElement = ((BST<T>) auxElement).minimum();
			} else{
				auxElement = (BSTNode) auxElement.getParent();
			}
			while(!auxElement.getParent().isEmpty() && ( ((Comparable<T>) ((BTNode) element).getData()).compareTo( (T) auxElement.getParent().getData())) < 0){
				auxElement = (BSTNode) auxElement.getParent().getData();
			}
		}
		return auxElement;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
