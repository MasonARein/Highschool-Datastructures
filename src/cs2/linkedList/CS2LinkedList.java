package cs2.linkedList;

import cs2.CS2List;

public class CS2LinkedList<E> implements CS2List<E> {
    private ListNode head;
    private int mySize;
    private ListNode tail;
    public CS2LinkedList(){
        head = null;
        mySize = 0;
        tail = null;
    }

    @Override
    public int size() {
        return mySize;
    }

    @Override
    public boolean add(E obj) {
        ListNode item = new ListNode(obj);
        if(size() == 0){
            head = item;
        }
        else{
            tail.next = item;
        }
        tail = item;
        mySize++;
        return true;
    }

    @Override
    public void add(int index, E obj) {
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        else if(size() == 0){
            head = new ListNode(obj);
        }
        else if(index == 0){
            ListNode ut = head;
            head = new ListNode(obj);
            head.next = ut;
        }
        else if(index == size()-1){
            tail.next = new ListNode(obj);
            tail = tail.next;
        }
        else {
            int counter = 0;
            ListNode pointer = head;
            while (pointer != null && counter != index-1) {
                counter++;
                pointer = pointer.getNext();
            }
            if (pointer == null) {
                throw new IndexOutOfBoundsException();
            }
            ListNode newIt = new ListNode(obj);
            ListNode it = pointer.next;
            pointer.next = newIt;
            newIt.next = it;
        }
        mySize++;
    }

    @Override
    public E get(int index) {
        int counter = 0;
        ListNode pointer = head;
        while(pointer != null && counter != index){
            counter++;
            pointer = pointer.getNext();
        }
        if(pointer == null){
            throw new IndexOutOfBoundsException();
        }
        return pointer.getValue();
    }

    @Override
    public E set(int index, E obj) {
        int counter = 0;
        ListNode pointer = head;
        while(pointer != null && counter != index){
            counter++;
            pointer = pointer.getNext();
        }
        if(pointer == null){
            throw new IndexOutOfBoundsException();
        }
        E item = pointer.getValue();
        pointer.setValue(obj);
        return item;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException();
        }
        ListNode pointer = head;
        ListNode last = head;
        int counter = 0;
        if(size() == 1){
            mySize = 0;
            ListNode joe = head;
            head = null;
            return joe.getValue();
        }
        else if(index == 0){
            head = pointer.next;
            mySize--;
            return pointer.getValue();
        }
        else {
            while (pointer != null && counter != index - 1) {
                counter++;
                last = pointer;
                pointer = pointer.getNext();
            }
            if (pointer == null) {
                throw new IndexOutOfBoundsException();
            }
            ListNode temp = pointer.next;
            pointer.next = pointer.next.next;
            mySize--;
            if(index == size()-1){
                tail = last;
            }
            return temp.getValue();
        }
    }
    public String toString(){
        String str = "";
        ListNode pointer = head;
        if(pointer == null){
            return "empty list";
        }
        int counter = 0;
        while (pointer != null){
            str = str + " [" + counter + "]:" + pointer.getValue();
            pointer = pointer.getNext();
            counter++;
        }
        return str;
    }
    private class ListNode{
        private E value;
        private ListNode next;

        public ListNode(E item){
            next = null;
            value = item;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
