class Solution {
    public int countCommas(int n) 
     {
    //     100,101,456
    //     1 -> 100,101,456
        if(n < 1000) return 0;
        return n-1000+1;
    }
   
}