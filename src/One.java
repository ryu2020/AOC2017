
public class One {

    public static void main(String[] strs){
        int total = 0;
        String str = strs[0];
        int last = 10;
        int first = Character.getNumericValue(str.charAt(0));
        for(int x = 0; x < str.length(); x++){
            int i = Character.getNumericValue(str.charAt(x));
            int index = (x + str.length() / 2) % str.length();
            int j = Character.getNumericValue(str.charAt(index));
            if(i == j){
                total += i;
            }
            last = i;
        }
        if (last == first){
            //total += first;
        }
        System.out.println(total);
    }
}
