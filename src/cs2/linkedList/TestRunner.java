package cs2.linkedList;

public class TestRunner {
    public static void main(String[] args) {
        CS2LinkedList<Integer> lst = new CS2LinkedList<Integer> ();
        System.out.println (lst);
        lst.add (25);
        lst.add (50);
        lst.add (75);
        lst.add (100);
        System.out.println (lst);
        System.out.println(lst.size());
        System.out.println (lst.set(2, 30));
        System.out.println (lst);
        lst.add(1, 12);
        System.out.println (lst);
        lst.remove(0);
        System.out.println (lst);
    }
}
