class Solution {
    public int reverseBits(int n) {
       int[] bin = new int[32];
       Arrays.fill(bin, 0);
       int newN = n;
       int i = 31;
       while(newN != 0){
        int digit = newN % 2;
        bin[i] = digit;
        newN/=2;
        i--;
       }
       i = 0; int j = 31;
       while(i<=j){
        int temp = bin[i];
        bin[i] = bin[j];
        bin[j] = temp;
        i++;
        j--;
       }

       int ans = 0;
       int a = 1;
       for(int k = 31; k>=0 ; k-- ){
        int digit = bin[k];
        ans += digit*a;
        a = a*2;
       }
       return ans;
    }
    
}