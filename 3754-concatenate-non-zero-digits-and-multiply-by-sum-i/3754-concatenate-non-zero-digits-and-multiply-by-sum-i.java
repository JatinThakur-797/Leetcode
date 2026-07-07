class Solution {
    public long sumAndMultiply(int n) {
        int newN = n ;
        long ans= 0;
        long sum = 0;
        int m = 1;
        while(newN != 0){
            int digit = newN % 10;
            if(digit != 0){
            ans = ans+ digit*m;
                m *= 10;
                sum += digit;
            }
            newN/=10;
        }
        long f = ans * sum ;
    return f  ;
    }
}