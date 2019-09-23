package cs2.arrayList.arrayList2;

import cs2.arrayList.CS2ArrayList;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        // create a new arraylist
        CS2ArrayList<Double> list = new CS2ArrayList<Double>();
        int inc = 100;
        int total = 10000;
        int n = 1000;                    // list size
        long trials = 100000;          // number of trials
        ArrayList<Integer> collect = new ArrayList<Integer>();
        while(n <= total) {
            // fill with n Double values
            for (int i = 0; i < n; i++) {
                list.add(Math.random());
            }

            // create arrays to keep track of timing values
            int[] time = new int[n];

            // time get operation
            Double val = null;
            for (int i = 0; i < trials; i++) {
                // pick a random index (you want to avoid sequential access)
                int index = (int) (Math.random() * n);

                // time get operation
                long start = System.nanoTime();
                val = list.get(index);
                long end = System.nanoTime();

                // add elapsed time to the total time for that index and increment count
                time[index] += (end - start);
            }
            int comp = 0;
            for(int ex: time){
                comp += ex;
            }
            collect.add(comp/n);
            n += inc;
        }
            // print results as averages (data value/count)
        System.out.println("Get times\n");
        System.out.println("list size\ttime");
        for (int i=0; i<collect.size(); i++) {
            System.out.println(i*100 + 1000 + "\t" + collect.get(i));
        }
    }
}
