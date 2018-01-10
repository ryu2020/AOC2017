import java.util.Arrays;

class Stupid22{
    Integer[] arr;
    public Stupid22(Integer[] a){
        arr = a;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object s){
        Stupid22 st =  (Stupid22) s;
        for(int x = 0; x < this.arr.length; x++){
                if(!this.arr[x].equals(st.arr[x])){
                    //System.out.println("AAAAAAAAAAAAAAAAAAAA");
                    return false;

                }

        }
        //System.out.println("BBBBBBBBBBBBBBBBBBBBBBBB");
        return true;
    }

    @Override
    public int hashCode(){
        /**
        int ret = 1;
            for(Integer i : arr){
                ret = (int) Math.pow(ret, i);
            }
        ret = Integer.hashCode(ret);
        return ret;
         **/
        return Arrays.hashCode(arr);
    }

    public Integer[] getArr(){
        return arr;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}