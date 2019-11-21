package cs2.morsecode;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MorseRunner {
    public static void main(String[] args) {
        Map<String, String> morse = new TreeMap<String, String>();
        try {
            Scanner sc = new Scanner(new File("MorseCode.txt"));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                morse.put(str.substring(0,1), str.substring(1));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("file not found");
            return;
        }
        for(String s: morse.keySet()){
            System.out.println(s + " " + morse.get(s));
        }
        boolean loop = true;
        while(loop) {
            System.out.println("Enter phrase for translation");
            Scanner ac = new Scanner(System.in);
            String a = ac.nextLine();
            for (int i = 0; i < a.length(); i++) {
                String g = String.valueOf(a.charAt(i));
                g = g.toUpperCase();
                if (morse.get(g) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(morse.get(g) + " ");
                }
            }
            System.out.println("Another phrase Y/N");
            Scanner dc = new Scanner(System.in);
            String rep = dc.nextLine();
            if(!rep.equals("y")){
                loop = false;
            }
        }
    }
}
