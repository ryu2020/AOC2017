import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Thirteen {
    public static ArrayList<Integer> parse() {
        int count = 1;
        ArrayList<Integer> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputthirteen.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                    String[] lines = line.split(": ");
                    while(Integer.parseInt(lines[0]) > count - 1){
                        arrl.add(null);
                        count++;
                    }
                    arrl.add(Integer.parseInt(line.split(": ")[1]));
                    count++;

            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        //System.out.println(arrl);
        return arrl;
    }
    public static void main(String[] arr){
        int count = 0;
        ArrayList<Integer> arrl = parse();
        while(caught(count, makeDeepCopyInteger(arrl))){

            System.out.println(count);
            count+= 2;
        }
        System.out.println(count);
    }
    public static boolean caught(int delay, ArrayList<Integer> lengths){

        int length = lengths.size();
        ArrayList<Integer> scanners = new ArrayList<>();
        for(int x = 0; x < lengths.size(); x++){
            scanners.add(0);
        }
        ArrayList<Integer> directions = new ArrayList<>();
        for(int x = 0; x < lengths.size(); x++){
            directions.add(1);
        }
        System.out.println(lengths.size());
        int severity = 0;
        for(int x = 0; x < delay; x++) {
            for (int y = 0; y < scanners.size(); y++) {
                if (lengths.get(y) != null) {
                    scanners.set(y, scanners.get(y) + directions.get(y));
                    if (scanners.get(y) == lengths.get(y) - 1) {
                        directions.set(y, -1);
                    } else if (scanners.get(y) == 0) {
                        directions.set(y, 1);
                    }
                }
            }
        }

        //System.out.println(delay + ", " + scanners);
        for(int x = 0; x < lengths.size(); x++){
            if(lengths.get(x) != null) {
                if (scanners.get(x) == 0) {
                    System.out.println(x + ", " + lengths.get(x));
                    severity += lengths.get(x) * x;

                        return true;

                }
            }
            for(int y = 0; y < scanners.size(); y++){
                if(lengths.get(y) != null) {
                    scanners.set(y, scanners.get(y) + directions.get(y));
                    if (scanners.get(y) == lengths.get(y) - 1) {
                        directions.set(y, -1);
                    }
                    else if (scanners.get(y) == 0){
                        directions.set(y, 1);
                    }
                }
            }
        }
        System.out.println(severity);
        return false;
    }
    public static ArrayList<Integer> makeDeepCopyInteger(ArrayList<Integer> old){
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(Integer i : old){
            if(i == null){
                copy.add(null);
            }
            else {
                copy.add(new Integer(i));
            }
        }
        return copy;
    }
}
