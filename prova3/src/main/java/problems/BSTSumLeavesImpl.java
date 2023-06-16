package problems;

import adt.bst.BST;
import adt.bst.BSTNode;

public class BSTSumLeavesImpl implements BSTSumLeaves{

    public int sumLeaves(BST<Integer> bst){
        int i = 0;
        if (!bst.getRoot().isEmpty()){
            i = sumLeavesAux((BSTNode<Integer>) bst.getRoot());
        }
        return i;
    }

    private int sumLeavesAux(BSTNode<Integer> node){
        int i = 0;
        if (!node.isEmpty()){
            if (node.isLeaf()){
                i = node.getData();
            } else{
                i = sumLeavesAux((BSTNode<Integer>) node.getRight()) + sumLeavesAux((BSTNode<Integer>) node.getLeft());
            }
        }
        return i;
    }


}
