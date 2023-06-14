package adt.bst;

import adt.bt.BTNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		int count = 0;
		if (!node.isEmpty()){
			count = 1 + Math.max(heightAux((BSTNode) node.getRight()), heightAux((BSTNode) node.getLeft()));
		} else {
			count = -1;
		}
		return count;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode node = new BSTNode();
		if (element != null){
			node = auxSearch(element, this.root);
		}
		return node;
	}


	private BSTNode auxSearch(T element, BSTNode node){
		if (!node.isEmpty()){
			if (element.compareTo((T) node.getData()) > 0){
				node = auxSearch(element,(BSTNode) node.getRight());
			} else if (element.compareTo((T) node.getData()) < 0){
				node = auxSearch(element, (BSTNode) node.getLeft());
			}
		}
		return node;
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			auxInsert(element, this.root);
		}
	}


	private void auxInsert(T element, BSTNode aux){
		if (!aux.isEmpty()){
			if (element.compareTo((T) aux.getData()) > 0){
				auxInsert(element, (BSTNode) aux.getRight());
			} else{
				auxInsert(element, (BSTNode) aux.getLeft());
			}
		} else{
			aux.setData(element);
			aux.setLeft(new BSTNode());
			aux.setRight(new BSTNode());
			aux.getLeft().setParent(aux);
			aux.getRight().setParent(aux);
		}
	}


	@Override
	public BSTNode<T> maximum() {
		BSTNode node = null;
		if (!this.root.isEmpty()){
			node = maximumAux(this.root);
		}
		return node;
	}

	private BSTNode maximumAux(BSTNode aux){
			if (!aux.getRight().isEmpty()){
				aux = maximumAux((BSTNode) aux.getRight());
			}
		return aux;
	}

	public BSTNode<T> minimum(){
		BSTNode aux = null;
		if (!this.root.isEmpty()){
			aux = minimumAux(this.root);
		}
		return aux;
	}

	private BSTNode<T> minimumAux(BSTNode aux) {
		if (!aux.getLeft().isEmpty()){
			aux = minimumAux((BSTNode) aux.getLeft());
		}
		return aux;
	}



	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode aux = search(element);
		if (element != null && !this.root.isEmpty() && !aux.isEmpty()){
			if (!aux.getRight().isEmpty()){
				aux = minimumAux((BSTNode) aux.getRight());
			} else {
				aux = sucessorAux(aux);
			}
		} else{
			aux = null;
		}
		return  aux;
	}

	private BSTNode<T> sucessorAux(BSTNode<T> node) {
		BSTNode<T> sucessor = (BSTNode<T>) node.getParent();
			if (sucessor != null && sucessor.getRight().equals(node)){
				sucessor = sucessorAux((BSTNode<T>) node.getParent());
		}
		return sucessor;

	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (element != null && !this.root.isEmpty() && !node.isEmpty()){
			if (!node.getLeft().isEmpty()){
				node = maximumAux((BSTNode) node.getLeft());
			} else {
				node = predecessorAux(node);
			}
		} else{
			node = null;
		}
		return node;
	}

	private BSTNode<T> predecessorAux(BSTNode<T> node) {
		BSTNode<T> predecessor = (BSTNode<T>) node.getParent();
			if (predecessor != null && predecessor.getLeft().equals(node)){
				predecessor = predecessorAux((BSTNode<T>) node.getParent());
			}
		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);

			} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();

				if (parent != null) {
					if (!parent.getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							parent.setRight(node.getLeft());
							node.getLeft().setParent(parent);
						} else {
							parent.setRight(node.getRight());
							node.getRight().setParent(parent);
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							parent.setLeft(node.getLeft());
							node.getLeft().setParent(parent);
						} else {
							parent.setLeft(node.getRight());
							node.getRight().setParent(parent);
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getRight();
					} else {
						this.root = (BSTNode<T>) node.getLeft();
					}
					this.root.setParent(null);
				}
			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}


	@Override
	public T[] preOrder() {
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();
		if (!this.isEmpty()) {
			preOrderAux(this.root, aux);
			aux.toArray(arrayResult);
		}
		return arrayResult;
	}
	private void preOrderAux(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			array.add(node.getData());
			preOrderAux((BSTNode<T>) node.getLeft(), array);
			preOrderAux((BSTNode<T>) node.getRight(), array);
		}
	}
	@Override
	public T[] order() {
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();
		if (!this.isEmpty()) {
			OrderAux(this.root, aux);
			aux.toArray(arrayResult);
		}
		return arrayResult;
	}

	private void OrderAux(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			OrderAux((BSTNode<T>) node.getLeft(), array);
			array.add(node.getData());
			OrderAux((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();
		if (!this.isEmpty()) {
			postOrderAux(this.root, aux);
			aux.toArray(arrayResult);
		}
		return arrayResult;
	}

	private void postOrderAux(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			postOrderAux((BSTNode<T>) node.getLeft(), array);
			postOrderAux((BSTNode<T>) node.getRight(), array);
			array.add(node.getData());
		  }
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
