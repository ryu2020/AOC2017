import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class TwentyTwo {

    final static int DIRECTION_UP = 0;
    final static int DIRECTION_RIGHT = 1;
    final static int DIRECTION_DOWN = 2;
    final static int DIRECTION_LEFT = 3;

    int direction = DIRECTION_UP;
    HashSet<Integer[]> pointSet;
    Integer[] current = {0, 0};

    int count = 0;

    public TwentyTwo(){

        pointSet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentytwo.txt"))) {
            String line;
            Integer[] arr = {-12, -12};
            while ((line = br.readLine()) != null) {


                arr[1] = -12;
                for(String str: line.split("")){
                    Short bool;
                    if(str.equals("#"))
                    pointSet.add(arr);

                    arr[1]++;
                }
                arr[0]++;
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        for(Object ar: pointSet.toArray()){
            System.out.println(ar.toString());
        }
    }

    void step(){
        if(pointSet.contains(current)){
            pointSet.remove(current);
            direction = turn(DIRECTION_LEFT);
            move();
        }
        else{
            pointSet.add(current);
            direction = turn(DIRECTION_RIGHT);
            move();
            count++;
        }
    }

    int turn(int i){
        if(i == DIRECTION_LEFT) {
            return direction - 1 % 4;
        }
        if(i == DIRECTION_RIGHT){
            return direction + 1 % 4;
        }
        System.err.println("AAAAAAAAAAAAAAAAAAAAAAAA");
        return -1;
    }

    void move(){
        if(direction == DIRECTION_UP)
            current[1]++;
        else if(direction == DIRECTION_DOWN)
            current[1]--;
        else if(direction == DIRECTION_RIGHT)
            current[0]++;
        else if(direction == DIRECTION_LEFT)
            current[0]--;
    }

    int getCount(){
        return count;
    }

    public static void main(String[] aaa){
        TwentyTwo tt = new TwentyTwo();
        for(int x = 0; x < 10000; x++){
            tt.step();
        }
        System.out.println(tt.getCount());
    }
}
