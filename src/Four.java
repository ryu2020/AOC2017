import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Four {

    ArrayList<ArrayList<String>> parse(){
        ArrayList<ArrayList<String>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] b = line.split(" ");
                ArrayList<String> arr = new ArrayList<>();
                for(String s: b){
                    arr.add(s);
                }
                arrl.add(arr);
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        return arrl;
    }

        public static void main(String[] AAAAAAAA){

            int total = 0;
            Four four = new Four();
            ArrayList<ArrayList<String>> arrl = four.parse();
            for(ArrayList<String> arrr: arrl){
                total += analyze(arrr);
            }

            System.out.println(total);
        }

        public static int analyze(ArrayList<String> arrl){
            for(int x = 0; x < arrl.size() - 1; x++){
                for(int y = x + 1; y < arrl.size(); y++){
                    if(isAnagram(arrl.get(x), arrl.get(y)))
                        return 0;
                }
            }
            return 1;
        }

        public static boolean isAnagram(String a, String b){
            if(a.length() != b.length()){
                return false;
            }
            HashMap<Character, String> hm = new HashMap();
            for (int i = 0; i < a.length(); i++){
                hm.put(a.charAt(i), "a");
                System.out.println(hm);
            }
            for (int i = 0; i < b.length(); i++){
                hm.remove(b.charAt(i));
                System.out.println(hm);
            }
            return hm.isEmpty();
        }

}
