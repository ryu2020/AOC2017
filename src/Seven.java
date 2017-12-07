import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class TreeNode{
    String name;
    int value;
    ArrayList<TreeNode> pointers;
    TreeNode(String s, int v){
        name = s;
        value = v;
        pointers = new ArrayList<TreeNode>();
    }
    TreeNode(String s, int v, ArrayList<TreeNode> arrl){
        name = s;
        value = v;
        pointers = arrl;
    }
    public int getValue(){
        return value;
    }

    public boolean isEnd(){
        return pointers.isEmpty();
    }

    public String getName(){
        return name;
    }
    TreeNode getNode(String st){
        for (TreeNode tn: pointers){
            if(tn.getName().equals(st)){
                return tn;
            }
        }
        return null;
    }
}

public class Seven {


    ArrayList<ArrayList<String>> parse(){
        ArrayList<ArrayList<String>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputseven.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] b = line.split("-> ");
                String d = b[0].split(" ")[0];

                String num = b[0].split("\\(")[1].split("\\)")[0];
                if(b.length > 1) {
                    String[] c = b[1].split(", ");
                    ArrayList<String> arr = new ArrayList<>();

                    arr.add(num);
                    arr.add(d);
                    for (String s : c) {
                        arr.add(s);
                    }

                    arrl.add(arr);
                }
                else{
                    ArrayList<String> arr = new ArrayList<String>();
                    arr.add(num);
                    arr.add(d);
                    arrl.add(arr);
                }

            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        System.out.println(arrl);
        return arrl;
    }

    ArrayList<ArrayList<String>> parse2(){
        ArrayList<ArrayList<String>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputseven.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] b = line.split("-> ");
                String d = b[0].split(" ")[0];

                String num = b[0].split("\\(")[1].split("\\)")[0];
                if(b.length > 1) {
}
                else{
                    ArrayList<String> arr = new ArrayList<String>();
                    arr.add(num);
                    arr.add(d);
                }
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        System.out.println(arrl);
        return arrl;
    }

    public static void parseTree(){
        ArrayList<ArrayList<String>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputseven.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] b = line.split("-> ");
                String d = b[0].split(" ")[0];

                String num = b[0].split("\\(")[1].split("\\)")[0];
                if(b.length > 1) {

                }
                else{
                    ArrayList<String> arr = new ArrayList<String>();
                    arr.add(num);
                    arr.add(d);
                }
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        System.out.println(arrl);
    }

    public static void main(String[] ar){
        Seven s = new Seven();
        ArrayList<ArrayList<String>> arrlarrl = s.parse();

        ArrayList<ArrayList<String>> arrlarrl2 = s.parse();

        for(ArrayList<String> arrl : arrlarrl){
            boolean allEquals = true;
            for(int x = 2; x < arrl.size(); x++){
                for(int y = 2; y < arrl.size(); y++){
                    if(weight(getarrl(arrl.get(x), arrlarrl), arrlarrl) == weight(getarrl(arrl.get(y), arrlarrl), arrlarrl)){

                    }
                    else {
                        //System.out.println("debug " + get(arrl.get(x), arrlarrl) + ", " + get(arrl.get(y), arrlarrl));
                        allEquals = false;
                        System.out.println(false);
                        break;
                    }
                }

            }
            System.out.println(allEquals);
            if(allEquals){
                System.out.println("debug");
                arrlarrl2.remove(arrl);
            }
        }
/**
        arrlarrl = deepCopy(arrlarrl2);
        System.out.println(arrlarrl2);
        for(ArrayList<String> arrl: arrlarrl){
            for(int x = 2; x < arrl.size(); x++){
                if (contains(arrl.get(x), arrlarrl)){
                    System.out.println("AAAAAAAAA");
                    arrlarrl2.remove(arrl);
                    break;
                }
            }
        }
 **/
         arrlarrl = s.parse();
        for(ArrayList<String> arrl3 : arrlarrl2) {

            System.out.println(arrl3);
            System.out.println(weight(arrl3, arrlarrl));
            int total = 0;
            for (int x = 2; x < arrl3.size(); x++) {
                System.out.println(weight(getarrl(arrl3.get(x), arrlarrl), arrlarrl));
                total += (weight(getarrl(arrl3.get(x), arrlarrl), arrlarrl));
            }

            System.out.println(total);
        }
        System.out.println((getarrl("aobgmc", arrlarrl)));
    }
    public static void remove(String s, ArrayList<ArrayList<String>> arrlarrl, ArrayList<ArrayList<String>> arrlarrl2){
        for(ArrayList<String> strs : arrlarrl){
            if(strs.get(1).equals(s)) {
                System.out.println("found " + strs.get(0));
                arrlarrl2.remove(strs);
            }
        }
    }

    public static int get(String s, ArrayList<ArrayList<String>> arrlarrl){
        for(ArrayList<String> strs : arrlarrl) {
            if (strs.get(1).equals(s)) {
                return Integer.parseInt(strs.get(0));
            }
        }
        System.out.println(s);
        return -1;
    }

    public static ArrayList<String> getarrl(String s, ArrayList<ArrayList<String>> arrlarrl){
        for(ArrayList<String> strs : arrlarrl) {
            if (strs.get(1).equals(s)) {
                return strs;
            }
        }
        System.out.println(s);
        return null;
    }

    public static ArrayList<ArrayList<String>> deepCopy(ArrayList<ArrayList<String>> old){
        ArrayList<ArrayList<String>> deepCopy = new ArrayList<>();
        for(ArrayList<String> arrl: old){
            ArrayList<String> arrrl = new ArrayList<>();
            for(String str: arrl){
                String s = str;
                arrrl.add(s);
            }
            deepCopy.add(arrrl);
        }
        return deepCopy;
    }
    public static boolean contains(String s, ArrayList<ArrayList<String>> arrlarrl){
        for(ArrayList<String> strs : arrlarrl) {
            if (strs.get(1).equals(s)) {
                return true;
            }
        }
        System.out.println(s);
        return false;
    }
    public static int weight(ArrayList<String> strarrl, ArrayList<ArrayList<String>> arrlarrl){

        int total = Integer.parseInt(strarrl.get(0));
        for(int x = 2; x < strarrl.size(); x++){
            total += weight(getarrl(strarrl.get(x), arrlarrl), arrlarrl);
        }
        return total;
    }
}
