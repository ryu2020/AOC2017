import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwentyFour {

    public static void main(String[] st){
        TwentyFour tf = new TwentyFour();
        System.out.println(Arrays.toString(tf.eval(tf.parse(), new ArrayList<Point>(), 0)));
    }

    ArrayList<Point> parse(){
        ArrayList<Point> pieces = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentyfour.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                Point p = new Point(Integer.parseInt(line.split("/")[0]),Integer.parseInt(line.split("/")[1]));
                    pieces.add(p);
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        return pieces;
    }

    int[] eval(ArrayList<Point> p, ArrayList<Point> b, double look){

        boolean contains = false;
        for(Point point: p){
            if(point.getX() == look || point.getY() == look){
                contains = true;
            }
        }
        if(p.isEmpty() || !contains){
            //System.out.println("debug " + look);
            int total = 0;
            for(Point point: b){
                total += point.getX();
                total += point.getY();
            }
            int[] i = {total, b.size()};
            return i;
        }
        else{
            int beststrength = Integer.MIN_VALUE;
            int bestsize = Integer.MIN_VALUE;
            for(Point point: p){
                if((int) point.getX() == look){
                    ArrayList<Point> pcopy = makeDeepCopy(p);
                    ArrayList<Point> bcopy = makeDeepCopy(b);
                    pcopy.remove(point);
                    bcopy.add(point);
                    int[] i = eval(pcopy, bcopy, point.getY());
                    if(i[1] > bestsize){
                        bestsize = i[1];
                        beststrength = i[0];
                    }
                    if(i[1] == bestsize && i[0] > beststrength){
                        beststrength = i[0];
                    }
                }
                if((int) point.getY() == look){
                    ArrayList<Point> pcopy = makeDeepCopy(p);
                    ArrayList<Point> bcopy = makeDeepCopy(b);
                    pcopy.remove(point);
                    bcopy.add(point);
                    int[] i = eval(pcopy, bcopy, point.getX());
                    if(i[1] > bestsize){
                        bestsize = i[1];
                        beststrength = i[0];
                    }
                    if(i[1] == bestsize && i[0] > beststrength){
                        beststrength = i[0];
                    }
                }
            }

            int[] best = {beststrength, bestsize};
            return best;
        }
    }

    ArrayList<Point> makeDeepCopy(ArrayList<Point> ps){
        ArrayList<Point> ret = new ArrayList<>();
        for(Point p: ps){
            ret.add(p.getLocation());
        }
        return ret;
    }
}
