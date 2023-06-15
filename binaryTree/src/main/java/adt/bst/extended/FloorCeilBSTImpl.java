package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer i = null;

		for (Integer a : array){
			insert(a);
		}
		i = flooarAux(numero, this.root, i);
		return i;
	}

	private Integer flooarAux(double numero, BSTNode<Integer> node, Integer floor){
		if (!node.isEmpty()){
			if(numero > node.getData()){
				floor = flooarAux(numero, (BSTNode<Integer>) node.getRight(), node.getData());
			} else if (numero < node.getData()){
				floor = flooarAux(numero, (BSTNode<Integer>) node.getLeft(), floor);
			} else {
				floor = node.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer i = null;
		if (array.length > 2){
			for (Integer a : array){
				insert(a);
			}
			i = ceilAux(this.root, numero, i);
		}
		return i;
	}

	private Integer ceilAux(BSTNode<Integer> node , double numero, Integer ceil){
		if (!node.isEmpty()){
			if (numero > node.getData()){
				ceil = ceilAux((BSTNode<Integer>) node.getRight(), numero, ceil);
			} else if (numero < node.getData()){
				ceil = ceilAux((BSTNode<Integer>) node.getLeft(), numero, node.getData());
			}
		}
	}
}
