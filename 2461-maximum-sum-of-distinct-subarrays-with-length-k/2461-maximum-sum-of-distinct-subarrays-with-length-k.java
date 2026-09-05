class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //  nums = [1,5,4,2,9,9,9], k = 3
        // Brute force approch
        // while st , end -> nums.length;
        //     Set set ;
        //     for(i = st -> end) set.contains(num) true break;
        //                         set.add() sum += num 

        
        int left = 0;
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        for(int right = 0 ; right < nums.length ; right++){

                while(set.contains(nums[right])){

                    set.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }
                set.add(nums[right]);
                sum+= nums[right];

                if(right - left + 1 == k){

                    maxSum = Math.max(sum ,maxSum);
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }

            

        }
        return maxSum;


        
    }
}