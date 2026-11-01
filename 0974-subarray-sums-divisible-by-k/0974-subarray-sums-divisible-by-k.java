class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            int target = curr % k;
            if(target < 0) target+= k;
            ans += map.getOrDefault(target, 0);
            map.put(target, map.getOrDefault(target, 0) + 1);

        }
        return ans;
    }
}