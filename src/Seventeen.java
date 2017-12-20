import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Seventeen {

    private ArrayList<Integer> buffer;
    int index;
    HashMap<Integer, Integer> hs;

    Seventeen(){
        //buffer = new ArrayList<>(50000000);
        hs = new HashMap<Integer, Integer>();
        //buffer.add(0);
        index = 0;
        hs.put(0, 0);
    }

    void step( int j){
        index += 301;
        //System.out.println(index);

        index %= j;
        //System.out.println(buffer.size());
        //System.out.println(buffer);

            hs.put(index + 1, j);

        index++;
    }

    ArrayList<Integer> getBuffer(){
        return buffer;
    }

    HashMap<Integer, Integer> getHs(){
        return hs;
    }

    public static void main(String[] aa){
        Seventeen st = new Seventeen();
        for(int x = 1; x <= 50000000; x++){
            //System.out.println(x);
            st.step( x);
        }
        ArrayList<Integer> arrl = st.getBuffer();
       // int y = arrl.indexOf(2017) + 1;
        //System.out.println(arrl);
        //System.out.println(arrl.indexOf(2017));
        System.out.println(st.getHs().get(1));
    }

}
