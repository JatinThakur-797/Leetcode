class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2] ;
        for(int i = 0 ; i<n-2 ; i++){
            int left = i+1,right = n-1;
            while(left < right){
                int curr = nums[i] + nums[left] + nums[right];
                    int diff1 = target - ans;
                    int diff2 = target - curr;
                    if(target == curr){
                        return curr;
                    }
                    if(Math.abs(diff1) > Math.abs(diff2)){
                        ans = curr;
                    } 

                    if(curr < target){
                        left++;
                    }else{
                        right--;
                    }
            }
        }
        return ans;

    }
}