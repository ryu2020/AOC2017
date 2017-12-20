import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fifteen {

    public static void main(String[] a){
        Fifteen f= new Fifteen();
        System.out.println(f.calc());
    }



    public int calc(){
        long a = 289;
        long b = 629;
        int count = 0;
        for(long x = 0; x < 5000000; x++){
        a = (a * 16807) % 2147483647;
            while(a % 4 != 0) {
                a = (a * 16807) % 2147483647;
            }
        b = (b * 48271) % 2147483647;
            while(b % 8 != 0){
                b = (b * 48271) % 2147483647;
            }
            if(judge(a, b)){
                count++;
            }
        }
        return count;
    }

    public boolean judge(long a, long b){
        String astr = Long.toBinaryString(a);
        String bstr = Long.toBinaryString(b);
        while(astr.length() < 16){
            astr = "0" + astr;
        }
        while(bstr.length() < 16){
            bstr = "0" + bstr;
        }
        //System.out.println(astr.substring(astr.length() - 16));
        if(astr.substring(astr.length() - 16).equals(bstr.substring(bstr.length() - 16))){

            return true;
        }
        else{
            return false;
        }
    }
}

