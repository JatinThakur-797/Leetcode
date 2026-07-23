class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // [3,2,1] -> [3,3,3], [2,2,2],[1,1,1],[3,3,1],[3,2,3],[3,2,2],[2,2,1],[]
        
        int n = nums.length;
        if(n==1) return 1;
        if(n == 2)return 2;

        int bit = 32 - Integer.numberOfLeadingZeros(n);
        return 1<<bit;


    }
}