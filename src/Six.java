import java.util.ArrayList;
public class Six {
    public static ArrayList<Integer> arrl = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> arrlarrl = new ArrayList<>();

    public static ArrayList<Integer> makeDeepCopyInteger(ArrayList<Integer> old){
        ArrayList<Integer> copy = new ArrayList<Integer>(old.size());
        for(Integer i : old){
            copy.add(new Integer(i));
        }
        return copy;
    }

    public static void operate(){
        int greatestindex = 0;
        int greatest = -1;
        for(int x = 0; x < arrl.size(); x++){
            if (arrl.get(x) > greatest){
                greatest = arrl.get(x);
                greatestindex = x;
            }
        }
        arrl.set(greatestindex, 0);
        for(int x = 0; x < greatest; x++){
            greatestindex++;
            greatestindex %= arrl.size();
            arrl.set(greatestindex, arrl.get(greatestindex) + 1);

        }
    }

    public static void main(String[] aaa) {
        arrl.add(11);
        arrl.add(11);
        arrl.add(13);
        arrl.add(7);
        arrl.add(0);
        arrl.add(15);
        arrl.add(5);
        arrl.add(5);
        arrl.add(4);
        arrl.add(4);
        arrl.add(1);
        arrl.add(1);
        arrl.add(7);
        arrl.add(1);
        arrl.add(15);
        arrl.add(11);
        System.out.println(arrlarrl);
        int count = 0;



        while(!eval(arrl, arrlarrl) || count == 0){
            //System.out.println(arrlarrl);
            //System.out.println("count " + count);
            //System.out.println("adding" + arrl);
            arrlarrl.add(makeDeepCopyInteger(arrl));
            operate();
           // System.out.println(arrl);
            count++;
        }
        System.out.println(count);
    }
    public static boolean eval(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> arr){

        //System.out.println(arrlarrl);
        if(arr.isEmpty()){
           // System.out.println("debug");
            return false;
        }
        //System.out.println(a);

        for(int j = 0; j < arr.size(); j++){
            ArrayList<Integer> ar = arr.get(j);
            //System.out.println(arrl);
            boolean bool = true;
            for(int i = 0; i < arrl.size(); i++){
                //System.out.println(i);
                //System.out.print(a.get(i));

                //System.out.println(", " + arrl.get(i));
                if(ar.get(i).equals(arrl.get(i)) ) {
                }
                else{
                    bool = false;
                }
            }
            if(bool){
                System.out.println(arr.size() - j);
                return bool;
            }
        }
        //System.out.println("this worked correctly, true");
        return false;

    }
}
