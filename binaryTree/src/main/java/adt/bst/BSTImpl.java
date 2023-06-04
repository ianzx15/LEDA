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
		if (this.root != null && element != null){
			while ( aux != null){
				if (aux.equals(element)){
					return aux;
				} else if(element.compareTo((T) aux.getData()) < 0){
					aux = (BSTNode) aux.getLeft();
				} else{
					aux = (BSTNode) aux.getRight();
				}
				}
			}
		return aux;
	}

	@Override
	public void insert(T element) {
		boolean inserted = false;
		if (element != null){
			if (this.root.isEmpty()){
				this.root.setData(element);
			} else{
				BSTNode aux = this.root;
				while (!aux.isEmpty() && inserted == false){
					if (element.compareTo((T) aux.getData()) > 0 ){
						if (aux.getRight() == null){
							BSTNode<T> newNode = new BSTNode<T>();
							newNode.setData(element);
							aux.setRight(newNode);
							newNode.setParent(aux);
							inserted = true;
						}
						aux = (BSTNode) aux.getRight();
					} else{
						if (aux.getLeft() == null){
							BSTNode<T> newNode = new BSTNode<T>();
							newNode.setData(element);
							aux.setLeft(newNode);
							newNode.setParent(aux);
							inserted = true;

						}

						aux = (BSTNode) aux.getLeft();
					}
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
