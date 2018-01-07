import java.util.BitSet;

public class TwentyFive {
    BitSet tapepos;
    BitSet tapeneg;
    Boolean bitzero;
    int start;
    int end;
    int current;
    char state;

    TwentyFive(){
        tapepos = new BitSet(12656374);
        tapeneg = new BitSet(12656374);
        bitzero = false;
        current = 0;
        state = 'a';
        start = 0;
        end = 0;
    }

    void Iterate(){
        if(state == 'a'){
            if(!get(current)) {
                flip(current);
                current++;
                state = 'b';
            }
            else{
                flip(current);
                current--;
                state = 'c';
            }
        }
        else if(state == 'b'){
            if(!get(current)){
                flip(current);
                current--;
                state = 'a';
            }
            else{
                current--;
                state = 'd';
            }
        }
        else if(state == 'c'){
            if(!get(current)){
                flip(current);
                current++;
                state = 'd';
            }
            else{
                flip(current);
                current++;
                state = 'c';
            }
        }
        else if(state == 'd'){
            if(!get(current)){
                current--;
                state = 'b';
            }
            else{
                flip(current);
                current++;
                state = 'e';
            }
        }
        else if(state == 'e'){
            if(!get(current)){
                flip(current);
                current++;
                state = 'c';
            }
            else{
                current--;
                state = 'f';
            }
        }
        else if(state == 'f'){
            if(!get(current)){
                flip(current);
                current--;
                state = 'e';
            }
            else{
                current++;
                state = 'a';
            }
        }
    }

    boolean get(int index){
        if(index == 0){
            return bitzero;
        }
        else if(index < 0){
            return tapeneg.get(Math.abs(index) - 1);
        }
        return tapepos.get(index - 1);
    }

    void flip(int index){
        if(index == 0){
            bitzero = !bitzero;
        }
        else if(index < 0){
            tapeneg.flip(Math.abs(index) - 1);
        }
        else {
            tapepos.flip(index - 1);
        }
    }

    int value(){
        if(bitzero){
            return tapeneg.cardinality() + tapepos.cardinality() + 1;
        }
        return tapeneg.cardinality() + tapepos.cardinality();
    }

    public static void main(String[] a){
        TwentyFive tf = new TwentyFive();
        for(int x = 0; x < 12656374; x++){
            tf.Iterate();
        }
        System.out.println(tf.value());
    }

}
