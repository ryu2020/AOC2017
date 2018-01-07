import java.util.Arrays;

public class Fourteen {
    public static void main(String[] a){
        int[][] arr = new int[128][128];
        String toHash = "amgozmfv-";
        int total = 0;
        for(int x = 0; x < 128; x++){
            String str = toHash + x;
            System.out.println(str);
            String hash = Ten.knotHash(str);
            System.out.println(hash);
            //System.out.println(hash.length());
            String bin = "";
            for(char c: hash.toCharArray()) {
                String st = Long.toBinaryString(Long.parseLong(Character.toString(c), 16));
                while(st.length() != 4){
                    st = "0" + st;
                }
                bin += st;
            }


            for(char c: bin.toCharArray()){

                //System.out.println(bin.length());
                //System.out.println(c);
                //System.out.println(bin);
                int count = 0;
                for(char d: bin.toCharArray()) {
                    //System.out.println(d);
                    total += Integer.parseInt(Character.toString(d));
                    arr[x][count] =  Integer.parseInt(Character.toString(d));
                    count++;
                }
            }
        }
        System.out.println(total);
        for (int[] row : arr)
        {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\n");
        int count = 0;
        for(int x = 0;  x < 128; x++){
            for(int y = 0; y < 128; y++){

                    if(eval(arr, x, y)) {
                        count++;
                    }
                    /**
                    for (int[] row : arr)
                    {
                        System.out.println(Arrays.toString(row));
                    }

                    System.out.println("\n");
**/
                }


        }

        System.out.println(count);
    }

    public static boolean eval(int[][] arr, int r, int c){
        if(r < 0 || r > 127){
            return false;
        }
        if(c < 0 || c > 127){
            return false;
        }
        if(arr[r][c] == 0){
            return false;
        }
        if(arr[r][c] == 1) {
            arr[r][c] = 0;
            eval(arr, r - 1, c);
            eval(arr, r + 1, c);
            eval(arr, r, c - 1);
            eval(arr, r, c + 1);

        }

        return true;
    }
}
