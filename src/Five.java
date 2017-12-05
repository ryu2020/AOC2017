import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Five {
    ArrayList<Integer> parse(){
        ArrayList<Integer> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputdayfive.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrl.add(Integer.parseInt(line));
            }
        }
        catch(IOException e){
            System.out.println("debug");
        }
        return arrl;
    }
    public static void main(String[] aaaa){
        Five five = new Five();
        ArrayList<Integer> arrl = five.parse();
        int index = 0;
        int count = 0;
        while (index < arrl.size()){
            count++;
            int get = arrl.get(index);
            if(get >= 3){
                arrl.set(index, get - 1);
            }
            else
                arrl.set(index, get + 1);
            index += get;
        }
        System.out.println(count);
    }
}
