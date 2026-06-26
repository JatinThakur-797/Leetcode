class Solution {
   

    public long countMajoritySubarrays(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        int prefixSum = 0;
        map.put(prefixSum,1);
        long valid = 0;
        for(int i = 0; i<nums.length ; i++){

            if(nums[i] == target){
                valid += map.getOrDefault(prefixSum, 0);
                prefixSum += 1;
            }else{
                prefixSum -= 1;
                valid -= map.getOrDefault(prefixSum, 0);
            }
            result += valid;
            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }
            return result;
         
    }
}