class Solution {
    public int findGCD(int[] nums) {
       Arrays.sort(nums);
       return gcd(nums[0] , nums[nums.length - 1]);
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}