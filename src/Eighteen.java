import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Eighteen {
    HashMap<String, Long> reg;
    Long lastsnd;
    int index;
    LinkedList<Long> ll;
    ArrayList<String[]> strs;

    public Eighteen(){
        reg = new HashMap<>();
        reg.put("a", new Long(0));
        reg.put("b", new Long(0));
        reg.put("c", new Long(0));
        reg.put("d", new Long(0));
        reg.put("e", new Long(0));
        reg.put("f", new Long(0));
        reg.put("g", new Long(0));
        reg.put("h", new Long(0));
        reg.put("i", new Long(0));
        reg.put("j", new Long(0));
        reg.put("k", new Long(0));
        reg.put("l", new Long(0));
        reg.put("m", new Long(0));
        reg.put("n", new Long(0));
        reg.put("o", new Long(0));
        reg.put("p", new Long(0));
        reg.put("q", new Long(0));
        reg.put("r", new Long(0));
        reg.put("s", new Long(0));
        reg.put("t", new Long(0));
        reg.put("u", new Long(0));
        reg.put("v", new Long(0));
        reg.put("w", new Long(0));
        reg.put("x", new Long(0));
        reg.put("y", new Long(0));
        reg.put("z", new Long(0));
        lastsnd = new Long(-1);
        ll = new LinkedList<>();
        index = 0;
        strs = parse();
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
            reg.put(r, reg.get(r) + i);
        }
        catch(NumberFormatException e){
            reg.put(r, reg.get(r) + reg.get(str));
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

    void snd(String str) {
        try{
            Long i = Long.parseLong(str);
            lastsnd = i;
        }
        catch(NumberFormatException e){
            lastsnd = reg.get(str);
        }
    }

    boolean rcv(String str){
        if(ll.isEmpty()){
            return false;
        }
        else{
            reg.put(str, ll.pollLast());
            return true;
        }
    }

    void jgz(String r, String str){
        try{
            Long i = Long.parseLong(str);
            if(i > 0){
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
            if(reg.get(str) > 0){
                try{
                    index += Long.parseLong(r);
                }
                catch(NumberFormatException f){
                    index += reg.get(r);
                }
            }
            else{
                index++;
            }
        }
    }

    ArrayList<String[]> parse(){
        ArrayList<String[]> arrl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inputeighteen.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrl.add(line.split(" "));
            }
        } catch (IOException e) {
            System.out.println("debug");
        }
        return arrl;
    }

    String step(){

            //System.out.println(reg);
            if(strs.get(index)[0].equals("add")){
                add(strs.get(index)[1], strs.get(index)[2]);
            }
            else if(strs.get(index)[0].equals("mod")){
                mod(strs.get(index)[1], strs.get(index)[2]);
            }
            else if(strs.get(index)[0].equals("mul")){
                mul(strs.get(index)[1], strs.get(index)[2]);
            }
            else if(strs.get(index)[0].equals("set")){
                set(strs.get(index)[1], strs.get(index)[2]);
            }
            else if(strs.get(index)[0].equals("snd")){
                return (strs.get(index)[1]);
            }
            else if(strs.get(index)[0].equals("rcv")){
                //return rcv(strs.get(index)[1]);
                if(rcv(strs.get(index)[1])){

                }
            }
            else if(strs.get(index)[0].equals("jgz")){
                jgz(strs.get(index)[2], strs.get(index)[1]);
            }

            System.out.println(reg);

        return "none";
    }

    public static void main(String[] a){
        Eighteen et = new Eighteen();
        //System.out.println(et.run());
    }

}
