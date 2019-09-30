package cs2.stack;

import cs2.linkedList2.CS2LinkedList2;

import java.util.Iterator;

public class CS2Stack<E> extends CS2LinkedList2<E> {


    public void push(E exe){
         super.add(0, exe);
    }

    public E  pop() {
         return super.remove(0);
    }
    public boolean empty(){
        int a = super.size();
        if(a == 0)
            return true;
            return false;
    }
    public E peek(){
        return super.get(0);
    }
    public int search(E obj){
        Iterator<E> it = super.iterator();
        int count = 1;
        while(it.hasNext()){
            E searchVal = it.next();
            if(searchVal.equals(obj))
                break;
            count++;
        }
        return count;
    }
}
