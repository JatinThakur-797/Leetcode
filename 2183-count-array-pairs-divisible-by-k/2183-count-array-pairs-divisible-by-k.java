class Solution {
    public long countPairs(int[] nums, int k) {
        
        // k == 2
        // nums[i] * nums[j] / k = 1
        // nums[i] * nums[j] = k
        // nums[i] = k/nums[j];
                
                

        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        long ans = 0;
        for(int i = 0 ; i<nums.length ; i++){
           int g1= getGCD(k, nums[i]);

           for(int p : map.keySet()){
                if((long) g1 * p % k == 0){
                    ans += map.get(p);
                }
           }
            if(map.containsKey(g1)){
            map.put(g1, map.get(g1)+1);
            }else map.put(g1, 1);
        }
        return ans;
    }

    public  int getGCD(int a, int b) {
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return Math.abs(a); // Returns the positive GCD
    }
}