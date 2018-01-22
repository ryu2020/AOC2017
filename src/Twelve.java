import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Twelve {

    public static ArrayList<Integer> dict = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> parse() {
        ArrayList<ArrayList<Integer>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwelve.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                ArrayList<Integer> iarrl = new ArrayList<>();
                String[] b = line.split(" <-> ");
                iarrl.add(0);
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
        int count = 0;
        /**
        while(!isAllNull()){
            count++;
            int x = eval(arrl, firstNotNull());
            System.out.println(dict);
            System.out.println(x);
        }
         **/
        while(!removeGroup(arrl).isEmpty()){
            count++;
        }
        System.out.println(dict);
        System.out.println(count);
    }

    public static int firstNotNull(){
        for(int x = 0; x < 2000; x++){
            if(dict.get(x) != null){
                return x;
            }
        }
        return -1;
    }

    public static boolean isAllNull(){
        for(int x = 0; x < 2000; x++){
            if(dict.get(x) != null){
                return false;
            }
        }
        return true;
    }

    public static int eval(ArrayList<ArrayList<Integer>> vals, int index){
        /**
        System.out.println("AAAAAAAAAAAAAAAAA   " + index + vals.get(index));

        if(vals.get(index).size() == 2){
            System.out.println("debug");
            if(vals.get(index).get(0) == 0) {
                vals.get(index).set(0, 1);
                return 1;
            }
            else{
                return 0;
            }
        }
        else {
            ArrayList<Integer> arr = vals.get(index);
            arr.remove(new Integer(last));
            System.out.println(last);
            System.out.println(arr);
            vals.set(index, arr);
            int total = 0;
            for (int x = 1; x < arr.size(); x++) {
                    if(arr.get(x).get(0) == 0){

                    }
                    total += remove(vals, x, index);
            }
            return total;


        }
         **/
        dict.set(index, null);
        ArrayList<Integer> arr = vals.get(index);
        boolean visited = (arr.get(0) == 1);
        System.out.println(visited);
        if(visited){
            return 0;
        }
        if(arr.size() == 2){
            return 1;
        }
        int total = 0;
        for(int x = 1; x < arr.size(); x++){
            arr.set(0, 1);
            vals.set(index, arr);
            total += eval(vals, arr.get(x));
        }
        return total + 1;
    }

    public static ArrayList<ArrayList<Integer>> removeGroup(ArrayList<ArrayList<Integer>> arrl){
        if(arrl.get(0).isEmpty()){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            for(int i = 1; i < arrl.size(); i++){
                ret.add(arrl.get(i));
            }
            return ret;
        }
        else{
            int remove = arrl.get(0).remove(0);
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            for(int i = 0; i < arrl.size(); i++){
                if(i != remove){
                    ret.add(arrl.get(i));
                }
            }
            return removeGroup(ret);
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
