package cs2.morsecode;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeRunner2 {
    public static void main(String[] args) {
        String[] listed = new String[126];
        try {
            Scanner sc = new Scanner(new File("MorseCode.txt"));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                listed[(int)str.charAt(0)] = str.substring(2);
                try{
                    listed[(int)str.substring(0, 1).toLowerCase().charAt(0)] = str.substring(2);
                }
                catch(Exception e){

                }
            }
            sc.close();
        } catch (Exception e) {
          System.out.println("file not found");
          return;
        }
        for(int x = 0; x < listed.length; x++){
            System.out.println((char)x + " " + x + " " + listed[x]);
        }
        boolean loop = true;
        while(loop) {
            System.out.println("Enter phrase for translation");
            Scanner ac = new Scanner(System.in);
            String a = ac.nextLine();
            for (int i = 0; i < a.length(); i++) {
                int g = (int) a.charAt(i);
                if(g == 32){
                    System.out.print("  ");
                }
                else if(listed[g] != null) {
                    System.out.print(listed[g] + " ");
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
