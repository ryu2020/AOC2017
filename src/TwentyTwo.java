import java.awt.*;
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
    HashSet<Point> infectedSet;
    HashSet<Point> cleanSet;
    HashSet<Point> weakenedSet;
    HashSet<Point> flaggedSet;
    Integer[] current = {0, 0};

    int count = 0;

    public TwentyTwo(){

        cleanSet = new HashSet<>();
        infectedSet = new HashSet<>();
        weakenedSet = new HashSet<>();
        flaggedSet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentytwo.txt"))) {
            String line;
            Integer[] arr = {-12, 12};
            while ((line = br.readLine()) != null) {


                arr[0] = -12;
                for(String str: line.split("")){

                    Short bool;
                    if(str.equals("#")) {

                        infectedSet.add(new Point(arr[0], arr[1]));
                    }
                    else{
                        cleanSet.add(new Point(arr[0], arr[1]));
                    }
                    arr[0]++;
                }
                arr[1]--;
            }
        } catch (IOException e) {
            System.out.println("debug");
        }

    }

    void step(){
        //System.out.println("current: " + Arrays.toString(current) + ", " + direction);

        Point point = new Point(current[0], current[1]);
        if(infectedSet.contains(point)){
            //System.out.println("found match " + Arrays.toString(current));
            infectedSet.remove(point);
            flaggedSet.add(point);
            direction = turn(DIRECTION_RIGHT);
        }
        else if(weakenedSet.contains(point)){
            weakenedSet.remove(point);
            infectedSet.add(point);
            count++;
        }
        else if(flaggedSet.contains(point)){
            flaggedSet.remove(point);
            cleanSet.add(point);
            direction = turn(DIRECTION_LEFT);
            direction = turn(DIRECTION_LEFT);
        }
        else{
            cleanSet.remove(point);
            weakenedSet.add(point);
            direction = turn(DIRECTION_LEFT);
        }

        move();
    }

    int turn(int i){
        if(i == DIRECTION_LEFT) {
            return (direction + 3) % 4;
        }
        if(i == DIRECTION_RIGHT){
            return (direction + 1) % 4;
        }
        System.err.println("AAAAAAAAAAAAAAAAAAAAAAAA");
        return -1;
    }

    void move(){
        //System.out.println("moving " + direction);
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
        for(int x = 0; x < 10000000; x++){
            tt.step();
        }
        System.out.println(tt.getCount());
    }

    private enum state{
        CLEAN, WEAKENED, INFECTED, FLAGGED
    }
}
