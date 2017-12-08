import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Eight {
    public static HashMap<String, Integer> hashmap = new HashMap<>();

    public static void main(String[] aaaa){
        int big_largest = Integer.MIN_VALUE;
        try (BufferedReader br = new BufferedReader(new FileReader("inputeight.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strarr = line.split(" ");
                String name = strarr[0];

                int val = 0;
                if(hashmap.containsKey(name)){
                    val = hashmap.get(name);
                }
                int toAdd = Integer.parseInt(strarr[2]);
                if(strarr[1].equals("dec"))
                    toAdd *= -1;
                System.out.println(name + ", " + val + ", " + toAdd);
                if(strarr[5].equals("<")) {
                    if (hashmap.containsKey(strarr[4])) {
                        System.out.println(hashmap.get(strarr[4]));
                        if (Integer.parseInt(strarr[6]) > hashmap.get(strarr[4])) {
                            val += toAdd;
                        }
                    } else if (Integer.parseInt(strarr[6]) > 0) {
                        val += toAdd;
                    }
                }
                else if(strarr[5].equals(">")) {
                    if (hashmap.containsKey(strarr[4])) {

                        System.out.println(hashmap.get(strarr[4]));
                        if (Integer.parseInt(strarr[6]) < hashmap.get(strarr[4])) {
                            val += toAdd;
                        }
                    } else if (Integer.parseInt(strarr[6]) < 0) {
                        val += toAdd;
                    }
                }
                else if(strarr[5].equals("<=")) {
                    if (hashmap.containsKey(strarr[4])) {

                        System.out.println(hashmap.get(strarr[4]));
                        if (Integer.parseInt(strarr[6]) >= hashmap.get(strarr[4])) {
                            val += toAdd;
                        }
                    } else if (Integer.parseInt(strarr[6]) >= 0) {
                        val += toAdd;
                    }
                }
                else if(strarr[5].equals(">=")) {
                    if (hashmap.containsKey(strarr[4])) {

                        System.out.println(hashmap.get(strarr[4]));
                        if (Integer.parseInt(strarr[6]) <= hashmap.get(strarr[4])) {
                            val += toAdd;
                        }
                    } else if (Integer.parseInt(strarr[6]) <= 0) {
                        val += toAdd;
                    }
                }
                    else if(strarr[5].equals("==")) {
                    if (hashmap.containsKey(strarr[4])) {

                        System.out.println(hashmap.get(strarr[4]));
                        if (Integer.parseInt(strarr[6]) == hashmap.get(strarr[4])) {
                            val += toAdd;
                        }
                    } else if (Integer.parseInt(strarr[6]) == 0) {
                        val += toAdd;
                    }
                }
                    else if(strarr[5].equals("!=")) {
                        if(hashmap.containsKey(strarr[4])){

                            System.out.println(hashmap.get(strarr[4]));
                            if(Integer.parseInt(strarr[6]) != hashmap.get(strarr[4])){
                                val += toAdd;
                            }
                        }
                        else if(Integer.parseInt(strarr[6]) != 0){
                            val += toAdd;
                        }
                }
                hashmap.put(name, val);
                int largest = Integer.MIN_VALUE;
                for(String key : hashmap.keySet()){
                    largest = Integer.max(largest, hashmap.get(key));
                }
                big_largest = Integer.max(largest, big_largest);
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }

        System.out.println(big_largest);
    }

}
