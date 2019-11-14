package cs2.heap;

import java.util.*;

public class Heap <E extends Comparable<E>> implements Iterable {
    private ArrayList<E> vals = new ArrayList<>();

    public void add(E val){
        vals.add(val);
        int index = size()-1;
        while(val.compareTo(vals.get(parent(index)))<0) {
            vals.set(index, vals.get(parent(index)));
            vals.set(parent(index), val);
            val = vals.get(parent(index));
            index = parent(index);
        }
    }
    public E remove() {
        E ite = vals.get(0);
        vals.set(0, vals.get(size()-1));
        vals.remove(size()-1);
        for(int a = 0; a < size(); a++){
            swap(a);
        }
        return ite;
    }
    public void swap(int a){
        try {
            if (vals.get(leftChild(a)).compareTo(vals.get(rightChild(a))) > 0) {
                if (vals.get(a).compareTo(vals.get(rightChild(a))) > 0) {
                    E temp = vals.get(a);
                    vals.set(a, vals.get(rightChild(a)));
                    vals.set(rightChild(a), temp);
                }
            } else {
                if (vals.get(a).compareTo(vals.get(leftChild(a))) > 0) {
                    E temp = vals.get(a);
                    vals.set(a, vals.get(leftChild(a)));
                    vals.set(leftChild(a), temp);
                }
            }
        }
        catch (Exception e){

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

    @Override
    public Iterator iterator() {
        return new CS2HeapIterator();
    }
    private class CS2HeapIterator implements Iterator<E>{
        private Iterator<E> iter;
        private List content;


        public CS2HeapIterator(){
            content = new ArrayList();
            Queue<E> ite = new LinkedList<>();
            while(!vals.isEmpty()){
                ite.add(Heap.this.remove());
            }
            while(!ite.isEmpty()){
                E item = ite.remove();
                content.add(item);
                vals.add(item);
            }
            iter = content.iterator();


        }
        public boolean hasNext(){
            return iter.hasNext();
        }
        public E next(){
            return iter.next();
        }
        public void remove(){
            throw new UnsupportedOperationException("Remove not Known");
        }

    }
}
