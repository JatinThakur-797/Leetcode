class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1 ; i<n ; i++){
            sum[i] = nums[i] + sum[i-1];
        }
      
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0 ; i<n ; i++){
            int rem = sum[i] % k;
            if(map.containsKey(rem)){
                if(i - map.get(rem) > 1) return true;
            }else{
                map.put(rem , i);
            }
        }
        return false;
    }
}