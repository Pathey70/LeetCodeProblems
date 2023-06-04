class DataStream {

    int count;
    int value;
    int k;
    public DataStream(int value, int k) {
       this.k=k;
       this.value=value;
        
    }
    
    public boolean consec(int num) {
       if(num==value){
           count++;
       } 
        else{
            count=0;
        }
        return count>=k ? true : false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */