package cs2.arrayList;

import cs2.CS2List;

    public class CS2ArrayList<E> implements CS2List<E> {

    private int mySize;
    private E[] myList;

    public CS2ArrayList(){
        mySize = 0;
        E[] myList = (E[])new Object[20];
    }
        @Override
        public int size() {
            return mySize;
        }
        private void expand() {
            E[] newList = (E[]) new Object[((int) (mySize * 1.5))];
            for (int i = 0; i < size(); i++) {
                newList[i] = this.myList[i];
            }
            myList = newList;

        }

        @Override
        public boolean add(E obj) {
            if (mySize == myList.length) {
                expand();
            } else {
                myList[mySize] = obj;
                mySize++;
            }
            return true;
        }

        @Override
        public void add(int index, E obj) {

        }

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public E set(int index, E obj) {
            return null;
        }

        @Override
        public E remove(int index) {
            return null;
        }
    }
