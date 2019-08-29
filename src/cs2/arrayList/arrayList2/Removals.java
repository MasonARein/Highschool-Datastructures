package cs2.arrayList.arrayList2;
import java.util.ArrayList;
import java.util.Iterator;

public class Removals {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a = 0; a < 20; a++){
            list.add((int)(Math.random()*21-10));
        }
        System.out.println(list);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            if(it.next() < 0) it.remove();
        }
        System.out.println(list);
    }
}
