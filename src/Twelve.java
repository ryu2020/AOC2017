import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Twelve {
    public static ArrayList<ArrayList<Integer>> parse() {
        ArrayList<ArrayList<Integer>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwelve.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                ArrayList<Integer> iarrl = new ArrayList<>();
                String[] b = line.split(" <-> ");
                for(String str : b[1].split(", ")){
                    iarrl.add(Integer.parseInt(str));
                }

                arrl.add(iarrl);
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        System.out.println(arrl);
        return arrl;
    }
    public static void main(String[] aaa){
        ArrayList<ArrayList<Integer>> arrl = parse();
        ArrayList<Integer> vals = new ArrayList<>();
        for(int x = 0; x < 2000; x++){
            vals.add(x);
        }
        remove(arrl, vals, 0, -1);
        System.out.println(vals.size());

    }
    public static void remove(ArrayList<ArrayList<Integer>> vals, ArrayList<Integer> dict, int index, int last){
        System.out.println("AAAAAAAAAAAAAAAAA   " + index + vals.get(index));

        if(vals.get(index).size() == 1){
            System.out.println("debug");
            dict.remove(vals.get(index).get(0));
            System.out.println(vals.get(index));
            System.out.println(dict);
        }
        else {
            ArrayList<Integer> arr= new ArrayList<>();
            ArrayList<Integer> arr2= makeDeepCopyInteger(vals.get(index));
            for(int i: arr2){
                if(i != last){
                    arr.add(new Integer(i));
                }
            }
            System.out.println(last);
            System.out.println(arr);
            vals.set(index, arr);
            for (int i : arr) {
                    remove(vals, dict, i, index);
                    if(i < dict.size()) {
                        dict.remove(new Integer(i));
                    }
            }
                dict.remove(new Integer(index));

        }
    }

    public static ArrayList<Integer> makeDeepCopyInteger(ArrayList<Integer> old){
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(Integer i : old){
            copy.add(new Integer(i));
        }
        return copy;
    }
}
