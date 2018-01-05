import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Nineteen {
    public static final Integer DIRECTION_UP = 0;
    public static final Integer DIRECTION_LEFT = 1;
    public static final Integer DIRECTION_DOWN = 2;
    public static final Integer DIRECTION_RIGHT = 3;
    public static ArrayList<ArrayList<Character>> parse(){
        ArrayList<ArrayList<Character>> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputnineteen.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<Character> row = new ArrayList<>();
                for(String str : line.split("")){
                    row.add(str.charAt(0));
                }
                arrl.add(row);
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        return arrl;
    }
    public static String run(){

        ArrayList<ArrayList<Character>> arrl = parse();
        String str = "";
        int r = 0;
        int c = arrl.get(0).indexOf('|');
        int dir = DIRECTION_DOWN;
        int count = 0;
        while(arrl.get(r).get(c) != 'K'){
            count++;
            System.out.println(arrl.get(r).get(c));
            /**
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException e){
                System.out.println("aaaa");
            }
             **/
            System.out.println(count);
            System.out.println(dir + ", " + r + ", " + c);
            if(arrl.get(r).get(c) == '+'){
                if(dir == DIRECTION_DOWN || dir == DIRECTION_UP){
                    if(c < arrl.get(r).size() - 1 && (arrl.get(r).get(c + 1)) == '-'){
                        c++;
                        dir = DIRECTION_RIGHT;
                    }
                    if(c > 0 && (arrl.get(r).get(c - 1)) == '-'){
                        c--;
                        dir = DIRECTION_LEFT;
                    }
                }
                else{
                    if(r < arrl.size() - 1 && (arrl.get(r + 1).get(c)) == '|'){
                        r++;
                        dir = DIRECTION_DOWN;
                    }
                    if(r > 0 && (arrl.get(r - 1).get(c)) == '|'){
                        r--;
                        dir = DIRECTION_UP;
                    }
                }
            }
            else if(arrl.get(r).get(c) == '|'){
                if(dir == DIRECTION_DOWN){
                    if(arrl.get(r + 1).get(c) == '-'){
                        r += 2;
                        count++;
                    }
                    else if(arrl.get(r + 1).get(c) == '|' || arrl.get(r + 1).get(c) == '+'){
                        r++;
                    }
                    else{
                        str += arrl.get(r + 1).get(c);
                        r += 1;
                    }
                }
                else{
                    if(r > 0 && arrl.get(r - 1).get(c) == '-'){
                        r -= 2;
                        count++;
                    }
                    else if(arrl.get(r - 1).get(c) == '|' || arrl.get(r - 1).get(c) == '+'){
                        r--;
                    }
                    else{
                        str += arrl.get(r - 1).get(c);
                        r -= 1;
                    }
                }
            }
            else if(arrl.get(r).get(c) == '-'){
                if(dir == DIRECTION_RIGHT){
                    if(arrl.get(r).get(c + 1) == '|'){
                        c += 2;
                        count++;
                    }
                    else if(arrl.get(r).get(c + 1) == '-' || arrl.get(r).get(c + 1) == '+'){
                        c++;
                    }
                    else{
                        str += arrl.get(r).get(c + 1);
                        c += 1;
                    }
                }
                else{
                    //System.out.println("debug");
                    if(arrl.get(r).get(c - 1) == '|'){
                        c -= 2;
                        count++;
                    }
                    else if(arrl.get(r).get(c - 1) == '-' || arrl.get(r).get(c - 1) == '+'){
                        c--;
                    }
                    else{
                        str += arrl.get(r).get(c - 1);
                        c -= 1;
                    }
                }
            }
            else{

                System.out.println("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                if(dir == DIRECTION_DOWN){
                    str += arrl.get(r).get(c);
                    r++;
                    if(arrl.get(r).get(c) == '-'){
                        r++;
                        count++;
                    }
                }
                if(dir == DIRECTION_UP){
                    str += arrl.get(r).get(c);
                    r--;
                    if(arrl.get(r).get(c) == '-'){
                        r--;
                        count++;
                    }
                }
                if(dir == DIRECTION_LEFT){
                    str += arrl.get(r).get(c);
                    c--;
                    if(arrl.get(r).get(c) == '|'){
                        c--;
                        count++;
                    }
                }
                if(dir == DIRECTION_RIGHT){
                    str += arrl.get(r).get(c);
                    c++;
                    if(arrl.get(r).get(c) == '|'){
                        c++;
                        count++;
                    }
                }
            }
        }
        return str;
    }
    public static void main(String[] a){
        System.out.println(run());

    }
}
