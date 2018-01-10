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
    HashSet<Stupid22> pointSet;
    Integer[] current = {0, 0};

    int count = 0;

    public TwentyTwo(){

        pointSet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentytwo.txt"))) {
            String line;
            Integer[] arr = {-12, 12};
            while ((line = br.readLine()) != null) {


                arr[0] = -12;
                for(String str: line.split("")){

                    Short bool;
                    if(str.equals("#")) {
                        //System.out.println(arr[0] + ", " + arr[1]);
                        Integer[] arrr = {arr[0], arr[1]};
                        pointSet.add(new Stupid22(arrr));
                    }
                    arr[0]++;
                }
                arr[1]--;
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        for(Object ar: pointSet.toArray()){
            //System.out.println(ar.toString());
        }
    }

    void step(){
        //System.out.println("current: " + Arrays.toString(current) + ", " + direction);

        Stupid22 s22 = new Stupid22(current);
        if(pointSet.contains(s22)){
            //System.out.println("found match " + Arrays.toString(current));
            pointSet.remove(s22);
            if(pointSet.contains(s22)){
                pointSet.remove(s22);
                System.err.println("BAD JOB REMOVING");
                System.out.println(s22);
            }
            direction = turn(DIRECTION_RIGHT);

        }
        else{
            pointSet.add(new Stupid22(current));
            if(!pointSet.contains(new Stupid22(current))){
                System.err.println("BAD JOB ADDING");
            }
            direction = turn(DIRECTION_LEFT);

            count++;
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
        for(int x = 0; x < 10000; x++){
            tt.step();
        }
        System.out.println(tt.getCount());
    }
}
