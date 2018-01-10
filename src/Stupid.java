class Stupid{
    Integer[][] arr;
    public Stupid(Integer[][] a){
        arr = a;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object s){
        Stupid st =  (Stupid) s;
        for(int x = 0; x < this.arr.length; x++){
            for(int y = 0; y < this.arr[0].length; y++){
                if(!this.arr[x][y].equals(st.arr[x][y])){
                    //System.out.println("AAAAAAAAAAAAAAAAAAAA");
                    return false;

                }
            }
        }
        //System.out.println("BBBBBBBBBBBBBBBBBBBBBBBB");
        return true;
    }

    @Override
    public int hashCode(){
        int ret = 0;
        for(Integer[] arr2: arr){
            for(Integer i : arr2){
                ret = ret ^ i.hashCode();
            }
        }
        return ret;
    }

    public Integer[][] getArr(){
        return arr;
    }
}