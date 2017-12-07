import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                }
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        System.out.println(arrl);
        return arrl;
    }

    public static void main(String[] ar){
        Seven s = new Seven();
        ArrayList<ArrayList<String>> arrlarrl = s.parse();

        ArrayList<ArrayList<String>> arrlarrl2 = s.parse();

        for(ArrayList<String> arrl : arrlarrl){
            boolean allEquals = true;
            for(int x = 2; x < arrl.size(); x++){
                for(int y = 2; y < arrl.size(); y++){
                    if(get(arrl.get(x), arrlarrl) == (get(arrl.get(y), arrlarrl))){

                    }
                    else {
                        System.out.println("debug " + get(arrl.get(x), arrlarrl) + ", " + get(arrl.get(y), arrlarrl));
                        allEquals = false;
                        break;
                    }
                }
            }
        }
        System.out.println(arrlarrl2);
        /**
            arrlarrl = deepCopy(arrlarrl2);
            for (ArrayList<String> strs : arrlarrl) {
                for (int x = 2; x < strs.size(); x++) {
                    System.out.println("looking for " + strs.get(x));
                    remove(strs.get(x), arrlarrl, arrlarrl2);
                }
            }
            System.out.println(arrlarrl2);
        **/
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
        return -1;
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

}
