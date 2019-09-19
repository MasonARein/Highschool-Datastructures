package cs2.linkedList2;

import cs2.linkedList.CS2LinkedList;

import java.util.Iterator;

public class Part2Tester {
    public static void main(String[] args) {



        CS2LinkedList2<Double> list = new CS2LinkedList2<Double>();

        for (int i=0; i<25; i++) {
            list.add(Math.random());
        }
        System.out.println(list.size());


// print using toString
        System.out.println (list);
        System.out.println();

// print using conventional for-loop:
        for (int i=0; i<list.size(); i++) {
            System.out.print (list.get(i) + " ");
        }
        System.out.println ();
        System.out.println ();

// print using enhanced-for:
        for (Double val: list) {
            System.out.println (val + " ");
        }
        System.out.println();
        System.out.println("Removing all values larger than 0.1");
        Iterator<Double> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() > .1) it.remove();
        }
        System.out.println(list);

    }
}
