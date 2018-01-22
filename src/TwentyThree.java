import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TwentyThree {
    HashMap<String, Long> reg;
    Long lastsnd;
    int index;
    int count;
    LinkedList<Long> ll;
    ArrayList<String[]> strs;
    LinkedList<Long> inBuffer;
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    int status;
    static final int WAIT = 1;
    static final int RUN = 0;

    public TwentyThree(){
        reg = new HashMap<>();
        reg.put("a", new Long(1));
        reg.put("b", new Long(0));
        reg.put("c", new Long(0));
        reg.put("d", new Long(0));
        reg.put("e", new Long(0));
        reg.put("f", new Long(0));
        reg.put("g", new Long(0));
        reg.put("h", new Long(0));

        //lastsnd = new Long(-1);
        //ll = new LinkedList<>();
        index = 0;
        strs = parse();
        inBuffer = new LinkedList<>();
        count = 0;
    }

    void set(String r, String str){
        try{
            Long i = Long.parseLong(str);
            reg.put(r, i);
        }
        catch(NumberFormatException e){
            reg.put(r, reg.get(str));
        }
    }

    void add(String r, String str){
        try{
            Long i = Long.parseLong(str);
            //System.out.println(i);
            reg.put(r, reg.get(r) - i);
        }
        catch(NumberFormatException e){
            reg.put(r, reg.get(r) - reg.get(str));
        }
    }

    void mod(String r, String str){
        try{
            Long i = Long.parseLong(str);
            reg.put(r, reg.get(r) % i);
        }
        catch(NumberFormatException e){
            reg.put(r, reg.get(r) % reg.get(str));
        }
    }

    void mul(String r, String str){
        try{
            Long i = Long.parseLong(str);
            reg.put(r, reg.get(r) * i);
        }
        catch(NumberFormatException e){
            reg.put(r, reg.get(r) * reg.get(str));
        }
    }

    String snd(String str) {
        //count++;
        System.out.println(str);
        try{
            Long i = Long.parseLong(str);
            lastsnd = i;
        }
        catch(NumberFormatException e){
            //System.out.println("debug " + str);
            lastsnd = reg.get(str);
        }
        return String.valueOf(lastsnd);
    }

    boolean rcv(String str){
        if(inBuffer.isEmpty()){
            return false;
        }
        else{
            reg.put(str, inBuffer.pollLast());
            return true;
        }
    }

    void jnz(String r, String str){
        try{
            Long i = Long.parseLong(str);
            System.out.println("angery debug");
            if(i != 0){
                try{
                    index += Long.parseLong(r);
                }
                catch(NumberFormatException e){
                    index += reg.get(r);
                }
            }
            else{

                index++;
            }
        }
        catch(NumberFormatException e){
            System.out.println(reg.get(str));
            if(reg.get(str) != 0){
                try{
                    index += Long.parseLong(r);
                }
                catch(NumberFormatException f){
                    index += reg.get(r);
                }
            }
            else{
                System.out.println("debug");
                index++;
            }
        }
    }



    ArrayList<String[]> parse(){
        ArrayList<String[]> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputtwentythree.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrl.add(line.split(" "));
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        return arrl;
    }

    void put(Long l){
        inBuffer.addFirst(l);
        System.out.println("received " + l);
        System.out.println(inBuffer);
    }

    String step(){
        System.out.println(index);
        System.out.println(Arrays.toString(strs.get(index)));
        if(index >= strs.size()){
            return "check";
        }

        //System.out.println(reg);
        if(strs.get(index)[0].equals("sub")){
            add(strs.get(index)[1], strs.get(index)[2]);
            index++;
        }
        else if(strs.get(index)[0].equals("mod")){
            mod(strs.get(index)[1], strs.get(index)[2]);
            index++;
        }
        else if(strs.get(index)[0].equals("mul")){
            mul(strs.get(index)[1], strs.get(index)[2]);
            index++;
            count++;
        }
        else if(strs.get(index)[0].equals("set")){
            set(strs.get(index)[1], strs.get(index)[2]);
            index++;
        }
        else if(strs.get(index)[0].equals("snd")){

            //System.out.println(Arrays.toString(strs.get(index)));

            System.out.println("sending " + snd(snd(strs.get(index)[1])));
            String ret = (snd(strs.get(index)[1]));
            index++;
            return ret;

        }
        else if(strs.get(index)[0].equals("rcv")){
            //return rcv(strs.get(index)[1]);
            System.out.println(inBuffer);
            System.out.println(Arrays.toString(strs.get(index)));
            if(rcv(strs.get(index)[1])){
                index++;
            }
            else{
                return "check";
            }
        }
        else if(strs.get(index)[0].equals("jnz")){
            jnz(strs.get(index)[2], strs.get(index)[1]);
        }

        System.out.println(reg);

        return "none";
    }

    public static void main(String[] a){
        /**
        Eighteen et1 = new Eighteen(new Long(0));
        Eighteen et2 = new Eighteen(new Long(1));

        int count = 0;
        boolean finishedOrDeadlock = false;
        while(!finishedOrDeadlock){

             try {
             Thread.sleep(60);
             }
             catch(InterruptedException e){
             System.exit(1);
             }

            System.out.println("0:");
            String str = et1.step();
            System.out.println("1:");
            String str2 = et2.step();
            if(str.equals("check") && str2.equals("check")){
                finishedOrDeadlock = true;
            }
            else {
                if (!(str.equals("none") || str.equals("check"))) {
                    et2.put(Long.parseLong(str));
                }
                if (!(str2.equals("none") || str2.equals("check"))) {
                    et1.put(Long.parseLong(str2));
                    count++;
                }
            }
        }
        **/
        TwentyThree tt = new TwentyThree();
        while(tt.index < 32){
            tt.step();
        }
        System.out.println(tt.count);


    }

    void iterate(Eighteen et0, Eighteen et1){
        String str0 = et1.step();

    }

}
