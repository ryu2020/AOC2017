import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Eleven {
    public static void main(String[] a) {
        ArrayList<String> strarr = new ArrayList<String>();
        /**
        String point = "";

        final ArrayList<String> dirs = new ArrayList<>();
        dirs.add("n");
        dirs.add("ne");
        dirs.add("se");
        dirs.add("s");
        dirs.add("sw");
        dirs.add("nw");
         **/
        int best = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("inputeleven.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String str : line.split(",")) {
                    strarr.add(str);
                }
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        //point = strarr.get(0);
        //strarr.remove(0);
        //int distance = 1;
        System.out.println(strarr);
        for(String s: strarr){

                if(s.equals("n")) {
                    x--;
                    y++;
                }
                else if(s.equals("ne")) {
                    y++;
                    z--;
                }
                else if(s.equals("se")) {
                    x++;
                    z--;
                }
                else if(s.equals("s")) {
                    x++;
                    y--;
                }
                else if(s.equals("sw")) {
                    y--;
                    z++;
                }
                else {
                    x--;
                    z++;
                }
            /**
            if (!(Math.abs(dirs.indexOf(s) - (dirs.indexOf(point)) - 3) == 1)){
                if(dirs.get(dirs.indexOf(s) + 3 % 6) == point){
                    distance--;
                }
                else{
                    distance++;
                }
            }
            point = s;
             **/
            best = Integer.max(Integer.max(best, Math.abs(x)), Integer.max(Math.abs(x), Math.abs(y)));
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(best);
    }
}
