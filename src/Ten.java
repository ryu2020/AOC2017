import java.util.ArrayList;
import java.util.Stack;

public class Ten {
    public static String knotHash(String str){
        ArrayList<Integer> vals = new ArrayList<>();
        for(int x = 0; x < 256; x++){
            vals.add(x);
        }
        String toHash = str;
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
            String hex = Integer.toHexString(x);
            while(hex.length() < 2){
                hex = "0" + hex;
            }
            out += hex;
        }
        return out;
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
