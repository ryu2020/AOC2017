import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Twenty {
    public static ArrayList<ArrayList<ArrayList<Integer>>> particles = new ArrayList<>();

    public static ArrayList<ArrayList<ArrayList<Integer>>> parse(){
        ArrayList<ArrayList<ArrayList<Integer>>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwenty.txt"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                ArrayList<ArrayList<Integer>> arrr = new ArrayList<>();
                ArrayList<Integer> arr = new ArrayList<>();
                count++;
                String str = line.split("p=<")[1].split(">")[0];
                for(String s: str.split(",")){
                    arr.add(Integer.parseInt(s));
                }
                arrr.add(arr);
                ArrayList<Integer> arr2 = new ArrayList<>();
                count++;
                String str2 = line.split("v=<")[1].split(">")[0];
                for(String s: str2.split(",")){
                    arr2.add(Integer.parseInt(s));
                }
                arrr.add(arr2);
                ArrayList<Integer> arr3 = new ArrayList<>();
                count++;
                String str3 = line.split("a=<")[1].split(">")[0];
                for(String s: str3.split(",")){
                    arr3.add(Integer.parseInt(s));
                }
                arrr.add(arr3);
                arrl.add(arrr);
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        return arrl;
    }
    public static void main(String[] a){

        particles = parse();
        while(true){
            iterate();
            System.out.println(particles.size());
        }
        /**
        int best = Integer.MAX_VALUE;
        ArrayList<Integer> bestArray = new ArrayList<>();
        int bestindex = 0;
        for(ArrayList<String> strarr: parse()){
            int total = 0;
            String str = strarr.get(1);
            System.out.println(strarr);
            str = str.substring(1, str.length() - 1);
            String[] arr = str.split(",");

            for(String s: arr){
                int i = Integer.parseInt(s);

                //System.out.print(i + ", ");
                total += Math.abs(i);
            }
            System.out.println(total +", " + best);
            if(total < best){
                best = total;
                bestArray = new ArrayList<>();
                bestArray.add(Integer.parseInt(strarr.get(0)));
                System.out.println(best);
            }
            else if(total == best){
                System.out.println(bestArray);
                bestArray.add(Integer.parseInt(strarr.get(0)));
            }

        }
        System.out.println(bestArray);
         **/
    }
    public static void iterate(){
        HashSet<ArrayList<Integer>> posSet = new HashSet<>();
        ArrayList<ArrayList<ArrayList<Integer>>> deepCopy = new ArrayList<>();

        //I'm not proud of this one
        for(ArrayList<ArrayList<Integer>> arrl : particles){
            boolean bool = true;
            for(ArrayList<ArrayList<Integer>> arrl2 : particles){
                if(arrl.get(0).equals(arrl2.get(0)) && arrl != arrl2){
                    bool = false;
                }

            }
            if(bool){
                deepCopy.add(arrl);
            }
        }

        particles = deepCopy;
        for(ArrayList<ArrayList<Integer>> arrl : particles){
            for(int x = 0; x < 3; x++){
                arrl.get(1).set(x, arrl.get(1).get(x) + arrl.get(2).get(x));
            }
            for(int x = 0; x < 3; x++){
                arrl.get(0).set(x, arrl.get(0).get(x) + arrl.get(1).get(x));
            }
        }
    }
}
