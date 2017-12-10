import java.util.ArrayList;
import java.util.Stack;

public class Ten {
    public static void main(String[] AAAAAA){
        ArrayList<Integer> vals = new ArrayList<>();
        for(int x = 0; x < 256; x++){
            vals.add(x);
        }
        String toHash = "206,63,255,131,65,80,238,157,254,24,133,2,16,0,1,3";
        ArrayList<Integer> ints = new ArrayList<>();
        for(int x = 0; x < toHash.length(); x++){
            ints.add((int) toHash.charAt(x));
        }
        ints.add(17);
        ints.add(31);
        ints.add(73);
        ints.add(47);
        ints.add(23);

        //int[] ints = {1, 2, 3 , 4, 5};
        int count = 0;
        int skip = 0;
        for(int x = 0; x < 64; x++) {
            for (int i : ints) {
                reverse(vals, count, i);
                count += i;
                count += skip;
                count %= vals.size();
                skip++;
                //System.out.println(vals);
                //System.out.println(count);
            }
        }
        ArrayList<Integer> denseHashArr = new ArrayList<Integer>();
        int denseHash = 0;
        for(int x = 0; x < 16; x++){
            denseHash = vals.get(16 * x);
            for(int y = 1; y < 16; y++){
                denseHash ^= vals.get(16 * x + y);
            }
            denseHashArr.add(denseHash);
        }
        String out = "";
        for(int x : denseHashArr){
            out += Integer.toHexString(x);
        }
        System.out.println(out);
    }
    public static void reverse(ArrayList<Integer> arrl, int start, int length){
        Stack<Integer> stack = new Stack<>();
        for(int x = 0; x < length; x++){
             int y = ((start + x) % arrl.size());
             stack.push(arrl.get(y));
        }
        for(int x = 0; x < length; x++){
            int y = ((x + start)) % arrl.size();
            arrl.set(y, stack.pop());
        }
    }
}
