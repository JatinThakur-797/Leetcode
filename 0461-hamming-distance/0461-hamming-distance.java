class Solution {
    public int hammingDistance(int x, int y) {
        // -> 3 = 011 , 1 = 001
        int[] xbit = new int[32];
        int[] ybit = new int[32];

        getBit(x, xbit);
        getBit(y, ybit);
        int ans = 0;
        for(int i = 0 ; i<32 ; i++){
            if(xbit[i] != ybit[i]){
                ans++;
            }
        }
        return ans;
    }

    public void getBit(int x, int[] xbit){
        int i = xbit.length-1;
        while(x != 0){
            xbit[i] = x % 2;
            x /= 2;
            i--;
        }
    }
}