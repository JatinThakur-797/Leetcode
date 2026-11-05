class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Boolean[] f = new Boolean[nums.length + 1];
       for(int num : nums){
            if(f[num] != null && f[num]){
                f[num] = false;
            }
            else f[num] = true;
       }
        int d = 0;
        int m = 0;
       for(int i = 1 ; i<f.length ; i++){
            if(f[i] == null){
                m = i;
                continue;
            }
            if(!f[i]){
                d = i;
            }
       }
       return new int[]{d,m};
    }
}