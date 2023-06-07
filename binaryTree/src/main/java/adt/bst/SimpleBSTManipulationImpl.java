package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (!tree1.isEmpty() && !tree2.isEmpty()){
			result = equals((BST<T>) tree1.getRoot(), (BST<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2){
		boolean result = false;

		if (node1.isEmpty() && node2.isEmpty()){
			result = true;
		} else if (node1.equals(node2)){
			result = this.equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) && this.equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}

		return  result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			return isSimilarAux((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean isSimilarAux(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			result = this.isSimilarAux((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
					&& this.isSimilarAux((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}
		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T orderStatistic = null;
		if (tree != null) {
			int size = tree.size();
			if (k >= 1 && k <= size) {
				if (k == 1) {
					orderStatistic = tree.minimum().getData();
				} else if (k == size) {
					orderStatistic = tree.maximum().getData();
				} else {
					orderStatistic = this.orderStatisticAux(tree, tree.minimum(), k);
				}
			}
		}

		return orderStatistic;
	}

	private T orderStatisticAux(BST<T> tree, BSTNode<T> node, int k) {
		T orderStatistic = null;
		if (k == 1) {
			orderStatistic = node.getData();
		} else {
			orderStatistic = this.orderStatisticAux(tree, tree.sucessor(node.getData()), --k);
		}
		return orderStatistic;
	}


}
