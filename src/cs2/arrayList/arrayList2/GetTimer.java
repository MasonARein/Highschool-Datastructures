package cs2.arrayList.arrayList2;

public class GetTimer {
    public static void main(String[] args) {
        // create a new arraylist
        CS2ArrayList2<Double> list = new CS2ArrayList2<Double>();
        int n = 1000;                    // list size
        long trials = 10000000;          // number of trials

        // fill with n Double values
        for (int i=0; i<n; i++) {
            list.add(Math.random());
        }
        // create arrays to keep track of timing values
        int [] time = new int[n];
        int [] count = new int[n];


        // time get operation
        Double val = null;
        for (int i=0; i<trials; i++) {
            // pick a random index (you want to avoid sequential access)
            int index = (int)(Math.random()*n);

            // time get operation
            long start = System.nanoTime();
            val = list.get(index);
            long end = System.nanoTime();

            // add elapsed time to the total time for that index and increment count
            time[index]+=(end-start);
            count[index]++;
        }

        // print results as averages (data value/count)
        System.out.println("Get times\n");
        System.out.println("index\ttime");
        for (int i=0; i<n; i++) {
            System.out.println(i + "\t" + (double)time[i]/count[i]);
        }
    }
}
