package cs2.postfix;

import cs2.stack.CS2Stack;

import java.util.Scanner;
import java.util.Stack;

public class Runner {
    public static void main(String[] args) {
        Scanner rdr = new Scanner (System.in);
        System.out.println("Input Equation:");
        Stack<Double> deck = new Stack<>();
        String str = rdr.next();
        while(!str.equals("=")){
            try{
                double val = Double.parseDouble(str);
                deck.push(val);
            }
            catch(Exception e){
                if(deck.size() == 1){
                    return;
                }
                double two = deck.pop();
                double one = deck.pop();
                switch(str){
                    case "*":
                        deck.push(one * two);
                        break;
                    case "+":
                        deck.push(one + two);
                        break;
                    case "-":
                        deck.push(one - two);
                        break;
                    case "/":
                        deck.push(one / two);
                        break;
                }
            }
            str = rdr.next();
        }
        if(deck.size() == 1){
            System.out.println(deck.pop());
        }
    }
}
