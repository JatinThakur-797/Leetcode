class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        int ans = 0;
        for(int i = 0 ; i<nums.length ; i++){
            pre += nums[i];
            if(map.containsKey(pre - k)){
                ans += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}