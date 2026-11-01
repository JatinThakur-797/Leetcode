class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long max = 0;
        for(int n : nums){
            max += n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int rem = (int) (max % p);
        if(rem == 0) return 0;

        map.put(0,-1);
        long curr = 0;
        int minLength = nums.length;
        for(int i = 0 ; i< nums.length; i++){
            curr += nums[i];

            int currMod = (int) (curr % p);
            int targetMod = (currMod - rem + p )%p;
            if(map.containsKey(targetMod)){
                minLength = Math.min(minLength,i - map.get(targetMod));
            }

            map.put(currMod, i);

        }

return minLength == nums.length ? -1 : minLength;


    }
}