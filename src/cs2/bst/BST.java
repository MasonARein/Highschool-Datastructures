package cs2.bst;

import javax.swing.tree.TreeNode;

public class BST <E extends Comparable<E>> {
    private class TreeNode implements Comparable<TreeNode>{
        private E value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
        public TreeNode(E val){
            value = val;
            left = null;
            right = null;
            parent = null;
        }
        public boolean equals(TreeNode vale){
            return vale.getValue().equals(value);
        }
        public int compareTo(TreeNode vale){
            return vale.getValue().compareTo(value);
        }
        public E getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
        public String toString(){
            return "" + value;
        }
    }
    private TreeNode root;
    public BST(){
        root = null;
    }
    public boolean add(E value){
        if (root == null) {
            root = new TreeNode (value);
            return true;
        }
        else {
            return add (root, new TreeNode(value));
        }
    }
    private boolean add (TreeNode subRoot, TreeNode node) {
        if(subRoot.equals(node)){
            return false;
        }
        else{

        }
    }



}
