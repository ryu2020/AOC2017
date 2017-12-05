import java.util.ArrayList;

public class Three {
    static int distance = 2;
    static int count2 = 7;
    static int count = 3;
    static int count3 = 0;
    static int distancecountdown = 1;
    static boolean timetochange = false;
    static ArrayList<Integer> toAdd;

    public static void main(String[] args){
        while(count2 < 325489){
            if(distancecountdown <= (count / 2)){
                distance--;
            }
            else{
                distance++;
            }
            distancecountdown++;
            if(distancecountdown > count){
                if(timetochange) {
                    count++;
                }
                distancecountdown = 1;
                timetochange = !timetochange;
            }
            count2++;
        }
        System.out.println(distance);
    }
}
