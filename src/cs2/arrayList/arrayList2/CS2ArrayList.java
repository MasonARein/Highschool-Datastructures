package cs2.arrayList.arrayList2;

import cs2.CS2List;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Creates a list of objects that can have the size be changed
 *
 * @author marein01
 *
 */
    public class CS2ArrayList<E> implements CS2List<E>, Iterable<E> {

    private int mySize;
    private E[] myList;

    /**
     * Sets the current available size of the CS2ArrayList and the current size of the list
     * being used
     */
    public CS2ArrayList() {
        mySize = 0;
        myList = (E[]) new Object[20];
    }

    /**
     * Current effective size
     *
     * @return the current size of the CS2ArrayList
     */
    @Override
    public int size() {
        return mySize;
    }

    /**
     * Max available space
     *
     * @return the maximum size of the CS2ArrayList
     */
    public int maxSize() {
        return myList.length;
    }

    /**
     * Creates a new list of 1.5 size of the current list and assigns all the values
     * of the items in the previous list into the new list. It then sets the address
     * of the new list to the old one
     */
    private void expand() {
        E[] newList = (E[]) new Object[((int) (mySize * 1.5))];
        for (int i = 0; i < size(); i++) {
            newList[i] = this.myList[i];
        }
        myList = newList;
    }

    /**
     * Adds an item to the end of the ArrayList
     * Postcondition: item is added to the end of the list
     *
     * @param Obj the value to be added
     * @return true if the item was added
     */
    @Override
    public boolean add(E Obj) {
        if (mySize >= myList.length) {
            expand();
        } else {
            myList[mySize] = Obj;
            mySize++;
        }
        return true;
    }

    /**
     * Takes in a place and a value and sets that value to the place and moves down
     * all other values one place. Throws exception if the list is max size or
     * requested value is outside list
     *
     * @param index place requested to be switched
     * @param obj   item being put into requested position
     */
    @Override
    public void add(int index, E obj) {
        if (size() == maxSize()) {
            expand();
        } else {
            if (index > size() - 1 || index < 0) {
                throw new IndexOutOfBoundsException("Value outside of list size");
            } else {
                for (int i = mySize - 1; i >= index; i--) {
                    myList[i + 1] = myList[i];

                }
                myList[index] = obj;
                mySize++;
            }
        }
    }

    /**
     * Gets the value of the given index in the CS2ArrayList
     *
     * @param index the value of the place in the CS2ArrayList
     * @return the item in the requested place of the CS2ArrayList
     */
    @Override
    public E get(int index) {
        if (index >= 0 && index < size()) {
            E value = myList[index];
            return value;
        } else {
            throw new IndexOutOfBoundsException("Place not found in List");
        }
    }

    /**
     * Sets the value of the given index in CS2ArrayList as specified value
     *
     * @param index place in the CSArrayList to be set
     * @param obj   value the place is going to be set to
     */
    @Override
    public E set(int index, E obj) {
        if (index >= 0 && index < size()) {
            E item = myList[index];
            myList[index] = obj;
            return item;
        } else {
            throw new IndexOutOfBoundsException("Place not found in List");
        }
    }

    /**
     * Removes a value in the CS2ArrayList and moves down all other values by one spot
     *
     * @param index The place that is to be removed from the CS2ArrayList
     */
    @Override
    public E remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Value outside of list size");
        } else {
            E item = myList[index];
            mySize--;
            for (int i = index; i < size(); i++) {
                myList[i] = myList[i + 1];

            }
            return item;
        }
    }

    /**
     * Returns true or false on if the list is empty or not
     *
     * @return true or false for if the list is empty or not
     */
    public boolean isEmpty() {
        if (mySize == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compares two different CS2ArrayLists on the different values they have and
     * returns true if all values are the same
     *
     * @param exe The  CS2ArrayList that is being compared to the current CS2ArrayList
     * @return true if all of the values in the two CS2ArrayLists are the same
     */
    public boolean equals(CS2ArrayList exe) {
        if (this.mySize != exe.mySize) {
            return false;
        }
        for (int i = 0; i < this.mySize; i++) {
            if (this.myList[i] != exe.myList[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * The size of the CS2ArrayList to zero and clears all previous items to the value of
     * zero
     */
    public void clear() {
        mySize = 0;
        for (int i = 0; i < myList.length; i++) {
            myList[i] = null;
        }
    }

    /**
     * Creates an array that contains the same information as the CS2ArrayList only it
     * cannot be changed and acts as an array
     *
     * @return the array that is a copy of the list
     */
    public E[] toArray() {
        E[] mirror = (E[]) new Object[this.mySize];
        for (int i = 0; i < this.mySize; i++) {
            mirror[i] = this.myList[i];
        }
        return mirror;
    }

    /**
     * Searches through the entire list to find if the specified item is in the list
     *
     * @param search is the double/value being searched for in the list
     * @return true if the item is in the list and false if not
     */
    public boolean contains(E search) {
        for (int i = 0; i < mySize; i++) {
            if (myList[i].equals(search)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a string of all the different values in the CS2ArrayList using the spots that
     * are occupied and returns empty if there are no values
     */
    public String toString() {
        String str = "";
        if (mySize != 0) {
            for (int i = 0; i < mySize; i++) {
                str = str + "[" + i + "]:" + myList[i] + " ";
            }
        } else {
            str = "Empty";
        }
        return str;
    }

    public Iterator<E> iterator() {
        return new CS2Iterator();
    }

    private class CS2Iterator implements Iterator<E> {

        private int next;
        private boolean once;
        public CS2Iterator() {
            next = 0;
            once = false;
        }
        @Override
        public boolean hasNext() {
            if (CS2ArrayList.this.mySize > next) {
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public E next() {
            if(hasNext() == true) {
                once = true;
                E obj = CS2ArrayList.this.get(next);
                next += 1;
                return obj;
            }
            else{
                throw new NoSuchElementException("No Next Value");
            }
        }
        public void remove(){
            if(CS2ArrayList.this.size() == 0){
                throw new IllegalArgumentException("Removal from empty list");
            }
            else if(once == true) {
                once = false;
                CS2ArrayList.this.remove(next - 1);
                next--;
            }
            else{
                throw new IllegalStateException("Remove called twice for single item");
            }
        }
    }
}

