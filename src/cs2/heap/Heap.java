package cs2.heap;

import java.util.ArrayList;

public class Heap <E extends Comparable<E>> {
    private ArrayList<E> vals;

    public void add(E val){
        vals.add(val);
    }
    private int rightChild(int i){
        return 2*(i+1);
    }
    private int leftChild(int i){
        return 2*(i+1)-1;
    }
    private int parent(int i){
        return (i-1)*2;
    }
    private int level(int i){

    }
}
