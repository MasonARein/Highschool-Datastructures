package cs2.hash;

import java.awt.*;
import java.util.Set;

public class CS2HashMapTimingRunner {
    public static void main(String[] args) {
        int n = 10000;
        for(int a = 1; a < n * 2; a++){
            CS2HashMap<Double, Double> vals = new CS2HashMap<>(a);
            long start = System.nanoTime();
            for(int b = 0; b < n; b++){
                vals.put(Math.random(), Math.random());
            }
            long end = System.nanoTime();
            long putter = (end-start)/n;
            Set<Double> keys = vals.keySet();
            start =  System.nanoTime();
            for(Double p: keys){
                vals.get(p);
            }
            end = System.nanoTime();
            long getter = (end-start)/n;
            System.out.println(a + "\t" + putter + "\t" + getter);
        }

    }
}
