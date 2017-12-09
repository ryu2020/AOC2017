import sun.util.resources.cldr.ca.CurrencyNames_ca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Nine {
    public static void main(String[] aaaa) {
        ArrayList<String> strarr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputnine.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for(String str : line.split("")){
                    strarr.add(str);
                }
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        int total = 0;
        Stack<Integer> CurlyBraceStack = new Stack<Integer>();
        for(int x = 0; x < strarr.size(); x++){
            if(strarr.get(x).equals("{")){
                if(CurlyBraceStack.isEmpty())
                    CurlyBraceStack.push(1);
                else
                CurlyBraceStack.push(CurlyBraceStack.peek() + 1);
            }
            else if(strarr.get(x).equals("}")){
                //total += CurlyBraceStack.pop();
            }
            else if(strarr.get(x).equals("<")){
                total--;
                while(!strarr.get(x).equals(">")){
                    if(strarr.get(x).equals("!")){
                        x++;
                    }
                    else{
                        total++;
                    }
                    System.out.println(strarr.get(x));
                    x++;
                }
            }
            else if(strarr.get(x).equals("!")){
                x++;
            }
            System.out.println(strarr.get(x));
            System.out.println(CurlyBraceStack);
        }
        System.out.println(total);
    }
}
