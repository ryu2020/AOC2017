import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Bert on 1/7/2018.
 */
public class TwentyOne {
    HashMap<Stupid, Stupid> dict2;
    HashMap<Stupid, Stupid> dict3;
    Integer[][] arr;

    ArrayList<Integer[][]> split2(Integer[][] arr){
        ArrayList<Integer[][]> ret = new ArrayList<>();
        for(int r = 0; r < arr.length; r += 2){
            for(int c = 0; c < arr.length; c += 2){
                Integer[][] arr2 = new Integer[2][2];
                for(int x = 0; x < 2; x++){
                    for(int y = 0; y < 2; y++){
                        arr2[x][y] = arr[r + x][c + y];
                    }
                }
                ret.add(arr2);
            }
        }
        return ret;
    }

    /**
    Integer[][] patch2(ArrayList<Integer[][]> arrl){
        int length = (int) Math.sqrt(arrl.size());
        int count = 0;
        Integer[][] ret = new Integer[length][length];
        for(int r = 0; r < length; r += 2){
            for(int c = 0; c < length; c += 2){
                Integer[][] arr2 = new Integer[2][2];
                for(int x = 0; x < 2; x++){
                    for(int y = 0; y < 2; y++){
                        ret[r + x][c + y] = arrl.get(count)[x][y];
                    }
                }
                count++;
            }
        }
        return ret;
    }
     **/

    ArrayList<Integer[][]> split3(Integer[][] arr){
        ArrayList<Integer[][]> ret = new ArrayList<>();
        for(int r = 0; r < arr.length; r += 3){
            for(int c = 0; c < arr.length; c += 3){
                Integer[][] arr2 = new Integer[3][3];
                for(int x = 0; x < 3; x++){
                    for(int y = 0; y < 3; y++){
                        arr2[x][y] = arr[r + x][c + y];
                    }
                }
                ret.add(arr2);
            }
        }
        return ret;
    }

    Integer[][] patch3(ArrayList<Integer[][]> arrl){
        System.out.println();
        System.out.println();

        int length = (int) Math.sqrt(arrl.size());

        System.out.println("length = " + length);
        int count = 0;
        Integer[][] ret = new Integer[length * 3][length * 3];
        for(int r = 0; r < length * 3; r += 3){
            for(int c = 0; c < length * 3; c += 3){
                Integer[][] arr2 = new Integer[3][3];
                for(int x = 0; x < 3; x++){
                    for(int y = 0; y < 3; y++){
                        ret[r + x][c + y] = arrl.get(count)[x][y];
                    }
                }
                count++;
            }
        }

        return ret;
    }

    Integer[][] patch4(ArrayList<Integer[][]> arrl){

        int length = (int) Math.sqrt(arrl.size());
        System.out.println("length = " + length);
        int count = 0;
        Integer[][] ret = new Integer[length * 4][length * 4];
        for(int r = 0; r < length * 4; r += 4){
            for(int c = 0; c < length * 4; c += 4){
                Integer[][] arr2 = new Integer[4][4];
                for(int x = 0; x < 4; x++){
                    for(int y = 0; y < 4; y++){
                        ret[r + x][c + y] = arrl.get(count)[x][y];
                    }
                }
                count++;
            }
        }
        return ret;
    }

    Integer[][] rotate(Integer[][] arr){
        Integer[][] ret = new Integer[arr.length][arr.length];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length; c++) {
                ret[c][arr.length-1-r] = arr[r][c];
            }
        }
        return ret;
    }

    Integer[][] flip(Integer[][] arr){

        Integer[][] ret = new Integer[arr.length][arr.length];
        ArrayList<Integer[]> temp = new ArrayList<>();
        for(Integer[] arr2 : arr){
            temp.add(arr2);
        }
        Collections.reverse(temp);
        for(int x = 0; x < temp.size(); x++){
            ret[x] = temp.get(x);
        }
        return ret;
    }

    void parse(){
        ArrayList<ArrayList<Character>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentyone2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linearr = line.split(" => ");
                if(linearr[0].length() == 5){
                    dict2.put(new Stupid(stringToArray(linearr[0])), new Stupid(stringToArray(linearr[1])));
                }
                else{

                    dict3.put(new Stupid(stringToArray(linearr[0])), new Stupid(stringToArray(linearr[1])));
                }
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
    }

    Integer[][] stringToArray(String str){
        String[] strarr = str.split("/");
        ArrayList<String> arrl = new ArrayList<>();
        for(String str2: str.split("/")){
            arrl.add(str2);
        }
        Integer[][] ret = new Integer[strarr[0].length()][strarr[0].length()];
        for(int r = 0; r < strarr[0].length(); r++){
            for(int c = 0; c < strarr[0].length(); c++){
                if(arrl.get(r).charAt(c) == '#'){
                    ret[r][c] = new Integer(1);
                }
                else{
                    ret[r][c] = new Integer(0);
                }
            }
        }
        return ret;
    }

    void iterate2(){

        boolean matched;
        ArrayList<Integer[][]> arrl = split2(arr);

        for(int x = 0; x < arrl.size(); x++) {
            Integer[][] arr2 = arrl.get(x);
            matched = false;
            for (int y = 0; y < 4; y++) {
                if (dict2.containsKey(new Stupid(arr2))) {
                    //System.out.println("match found");
                    //print(arr2);
                    //print(dict2.get(new Stupid(arr2)).getArr());
                    arrl.set(x, dict2.get(new Stupid(arr2)).getArr());
                    matched = true;
                    break;
                }
                arr2 = rotate(arr2);
            }
            if(matched){
                continue;
            }
            arr2 = flip(arr2);
            for (int y = 0; y < 4; y++) {
                if (dict2.containsKey(new Stupid(arr2))) {
                    //System.out.println("match found");
                   // print(arr2);
                    //print(dict2.get(new Stupid(arr2)).getArr());
                    arrl.set(x, dict2.get(new Stupid(arr2)).getArr());
                    break;
                }
                arr2 = rotate(arr2);
            }
        }
        arr = patch3(arrl);
    }

    void iterate3(){
        boolean matched;
        ArrayList<Integer[][]> arrl = split3(arr);

        for(int x = 0; x < arrl.size(); x++) {
            Integer[][] arr2 = arrl.get(x);
            matched = false;
            for (int y = 0; y < 4; y++) {

                if (dict3.containsKey(new Stupid(arr2))) {
                    //System.out.println("match found");
                    //print(arr2);
                    //print(dict3.get(new Stupid(arr2)).getArr());
                    arrl.set(x, dict3.get(new Stupid(arr2)).getArr());
                    matched = true;
                    break;
                }
                arr2 = rotate(arr2);
            }
            if(matched){
                continue;
            }
            //System.out.println("flipping");
            arr2 = flip(arr2);
            for (int y = 0; y < 4; y++) {

                if (dict3.containsKey(new Stupid(arr2))) {
                    //System.out.println("match found");
                    //print(arr2);
                    //print(dict3.get(new Stupid(arr2)).getArr());
                    arrl.set(x, (dict3.get(new Stupid(arr2)).getArr()));
                    break;
                }
                arr2 = rotate(arr2);
            }
        }
        arr = patch4(arrl);
    }

    public TwentyOne(){
        dict2 = new HashMap<>();
        dict3 = new HashMap<>();
        parse();
        Integer[] arr1 = {0, 1, 0};
        Integer[] arr2 = {0, 0, 1};
        Integer[] arr3 = {1, 1, 1};
        Integer[][] arr4 = {arr1, arr2, arr3};
        arr = arr4;

    }

    int sum(){
        int total = 0;
        for(Integer[] arr2: arr){
            for(Integer i: arr2){
                total += i;
            }
        }
        return total;
    }

    void print(){
        for(Integer[] i: arr){
            for(Integer i2: i){
                System.out.print(i2 + " ");
            }
            System.out.print("\n");
        }
    }

    void print(Integer[][] arr){
        for(Integer[] i : arr){
            for(Integer i2: i){
                System.out.print(i2 + " ");
            }
            System.out.print("\n");
        }
    }

    int side(){
        return arr.length;
    }

    public static void main(String[] a){
        TwentyOne to = new TwentyOne();
        for(int x = 0; x < 18; x++){
            System.out.println("side = " + to.side());
            if(to.side() % 2 == 0){
                to.iterate2();
            }
            else{
                to.iterate3();
            }

            //to.print();
        }
        //to.iterate2();
      System.out.println(to.sum());
    }
}
