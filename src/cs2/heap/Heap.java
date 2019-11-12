package cs2.heap;

import java.util.ArrayList;

public class Heap <E extends Comparable<E>> {
    private ArrayList<E> vals = new ArrayList<>();

    public void add(E val){
        vals.add(val);
        while(val.compareTo(vals.get(parent(size()-1))) < 0){
            int stor = size()-1;
            E item = val;
            vals.set(stor, vals.get(parent(stor)));
            vals.set(parent(stor), item);

        }
    }
    public E get(int i){
        return vals.get(i);
    }
    private int rightChild(int i){
        return 2*(i+1);
    }
    private int leftChild(int i){
        return 2*(i+1)-1;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int level(int i){
        return (int) (Math.log(i+1) / Math.log(2));
    }
    public String toString(){
        if(vals.isEmpty()){
            return "Empty Heap";
        }
        else{
            return toString(0, 0);
        }
    }
    public String toString(int ind, int lev){
        String str = "";
            if(rightChild(ind) < this.size()){
                str = str + toString(rightChild(ind), lev+1);
            }
            str += "\n";
            for(int a = 0; a < lev; a++){
                str += "- ";
            }
            str += this.get(ind);
            if(leftChild(ind) < this.size()){
                str = str + toString(leftChild(ind), lev+1);
            }
            return str;
    }
    public void clear(){
        vals.clear();
    }
    public int size(){
        return vals.size();
    }
    public boolean isEmpty(){
        return vals.isEmpty();
    }
}
