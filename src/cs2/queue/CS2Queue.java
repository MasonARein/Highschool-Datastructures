package cs2.queue;

import cs2.linkedList.CS2LinkedList;

public class CS2Queue<E> extends CS2LinkedList<E> {
    public E remove(){
        return remove(0);
    }
    public E peek(){
        try{
            return this.get(0);
        }
        catch (Exception e){
            return null;
        }
    }
}
