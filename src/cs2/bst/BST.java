package cs2.bst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BST <E extends Comparable<E>> implements Iterable<E>{
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
            return value.compareTo(vale.getValue());
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

    public TreeNode getRoot() {
        return root;
    }
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    private TreeNode root;

    public int size() {
        return size;
    }
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public boolean add(E value){
        if (root == null) {
            root = new TreeNode (value);
            size++;
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
            if(node.compareTo(subRoot) > 0){
                if(subRoot.getRight() == null){
                    subRoot.setRight(node);
                    node.setParent(subRoot);
                }
                else{
                    return add(subRoot.getRight(), node);
                }
            }
            else{
                if(subRoot.getLeft() == null){
                    subRoot.setLeft(node);
                    node.setParent(subRoot);
                }
                else{
                    return add(subRoot.getLeft(), node);
                }
            }
            size++;
            return true;
        }
    }
    public boolean contains (E value) {
        if (root == null) {
            return false;
        }
        else {
            return contains (root, new TreeNode(value));
        }

    }
    private boolean contains(TreeNode subRoot, TreeNode node){
        if(subRoot == null){
            return false;
        }
        else if(subRoot.equals(node)){
            return true;
        }
        else if(subRoot.compareTo(node) > 0){
            return contains(subRoot.getLeft(), node);
        }
        else{
            return contains(subRoot.getRight(), node);
        }
    }
    public int level (E value) {
        if (root == null) {
            return -1;
        }
        else {
            return level (root, new TreeNode(value), 0);
        }
    }
    private int level(TreeNode subRoot, TreeNode node, int level){
        if(subRoot == null){
            return -1;
        }
        else if(node.equals(subRoot)){
            return level;
        }
        else{
            if(subRoot.compareTo(node) > 0){
                return level(subRoot.getLeft(), node, level+1);
            }
            else{
                return level(subRoot.getRight(), node, level+1);
            }
        }
    }

    public List<E> inOrderTraversal() {
        List<E> list = new LinkedList<E>();
        inOrderTraversal (root, list);
        return list;
    }
    private void inOrderTraversal(TreeNode subRoot, List<E> list) {
        if(subRoot.getLeft() != null){
            inOrderTraversal(subRoot.getLeft(), list);
        }
        list.add(subRoot.getValue());
        if(subRoot.getRight() != null){
            inOrderTraversal(subRoot.getRight(), list);
        }
    }
    public List<E> reverseOrderTraversal() {
        List<E> list = new LinkedList<E>();
        reverseOrderTraversal (root, list);
        return list;
    }
    private void reverseOrderTraversal(TreeNode subRoot, List<E> list) {
        if(subRoot.getRight() != null){
            reverseOrderTraversal(subRoot.getRight(), list);
        }
        list.add(subRoot.getValue());
        if(subRoot.getLeft() != null){
            reverseOrderTraversal(subRoot.getLeft(), list);
        }
    }
    public List<E> postOrderTraversal() {
        List<E> list = new LinkedList<E>();
        postOrderTraversal (root, list);
        return list;
    }
    private void postOrderTraversal(TreeNode subRoot, List<E> list) {
        if(subRoot.getLeft() != null){
            postOrderTraversal(subRoot.getLeft(), list);
        }
        if(subRoot.getRight() != null){
            postOrderTraversal(subRoot.getRight(), list);
        }
        list.add(subRoot.getValue());
    }
    public List<E> preOrderTraversal() {
        List<E> list = new LinkedList<E>();
        preOrderTraversal (root, list);
        return list;
    }
    private void preOrderTraversal(TreeNode subRoot, List<E> list) {
        list.add(subRoot.getValue());
        if(subRoot.getLeft() != null){
            preOrderTraversal(subRoot.getLeft(), list);
        }
        if(subRoot.getRight() != null){
            preOrderTraversal(subRoot.getRight(), list);
        }
    }
    public String toString(){
        if(root == null){
            return "Empty Tree";
        }
        else{
            return toString(root, 0);
        }

    }
    private String toString(TreeNode subRoot, int level){
        String str = "";
        if(subRoot != null){
            if(subRoot.getRight() != null){
                str = str + toString(subRoot.getRight(), level+1);
            }
            str += "\n";
            for(int a = 0; a < level; a++){
                str += "- ";
            }
            str += subRoot.getValue();
            if(subRoot.getLeft() != null){
                str = str + toString(subRoot.getLeft(), level+1);
            }
            return str;
        }
        else{
            return str;
        }
    }
    public int recurSize() {
        if (root == null) {
            return -1;
        }
        else {
            return recurSize(root, 0);
        }
    }
    private int recurSize(TreeNode node, int size){
        if(node.getLeft() != null){
            size += recurSize(node.getLeft(), size);
        }
        if(node.getRight() != null){
            size += recurSize(node.getRight(), size);
        }
        if(node.getRight() == null && node.getLeft() == null){
            return 1;
        }
        return size;
    }
    public void clear(){
        root = null;
        size = 0;
    }
    public boolean remove(E val){
        if(root == null){
            return false;
        }
        else{
            return remove(root, new TreeNode(val));
        }
    }
    private boolean remove(TreeNode subRoot, TreeNode node){

        if(subRoot==null){
            return false;
        }
        if(node.equals(subRoot)){
            if(subRoot.getRight()==null && subRoot.getLeft()==null){
                if(subRoot.equals(root) && size == 1){
                    root = null;
                }
                else if(subRoot.getParent().getRight() == subRoot){
                    subRoot.getParent().setRight(null);
                }
                else if(subRoot.getParent().getLeft() == subRoot){
                    subRoot.getParent().setLeft(null);
                }
            }
            else if(subRoot.getRight()==null){
                if(subRoot.equals(root)){
                    root = root.getLeft();
                    size--;
                    return true;
                }
                if(subRoot.getParent().getRight() == subRoot){
                    subRoot.getParent().setRight(subRoot.getLeft());
                    subRoot.getLeft().setParent(subRoot.getParent());
                }
                else{
                    subRoot.getParent().setLeft(subRoot.getLeft());
                    subRoot.getLeft().setParent(subRoot.getParent());
                }
            }
            else if(subRoot.getLeft()==null){

                if(subRoot.equals(root)) {
                    root = root.getRight();
                    size--;
                    return true;
                }

                if(subRoot.getParent().getRight() == subRoot){
                    subRoot.getParent().setRight(subRoot.getRight());
                    subRoot.getRight().setParent(subRoot.getParent());
                }
                else{
                    subRoot.getParent().setLeft(subRoot.getRight());
                    subRoot.getRight().setParent(subRoot.getParent());
                }
            }
            else{
                TreeNode left = subRoot.getLeft();
                while(left.getRight() != null){
                    left=left.getRight();
                }
                subRoot.setValue(left.getValue());
                //System.out.println("TREE: "+this);
                remove(subRoot.getLeft(),subRoot);
                size++;
            }
        }
        else if(node.compareTo(subRoot)<0){
            return remove(subRoot.getLeft(),node);
        }
        else if(node.compareTo(subRoot)>0){
            return remove(subRoot.getRight(),node);
        }
        else{
            return false;
        }
        size--;
        return true;
    }
    public Iterator<E> iterator () {
        return new CS2TreeIterator();
    }

    private class CS2TreeIterator implements Iterator<E>{
        private E next;
        private E prev;
        private List content;
        private int count;

        public CS2TreeIterator(){
                content = inOrderTraversal();
                count = 0;
                next = (E)content.get(count);
                prev = null;

        }
        public boolean hasNext(){
            if(next != null){
                return true;
            }
            else{
                return false;
            }
        }
        public E next(){
            if(hasNext() && size()-1 == count){
                E temp = next;
                prev = next;
                next = null;
                return temp;
            }
            if(hasNext()) {
                prev = next;
                E temp = next;
                count++;
                next = (E) content.get(count);
                return temp;
            }
            return null;
        }

    }
}