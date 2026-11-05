class Solution {
    public int majorityElement(int[] nums) {
        //Mores Voting Allgorithm
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        int count  = 0;
        for(int key : map.keySet()){
            if(map.get(key) > count){
                count = map.get(key);
                max = key;
            }
        }
        if(count > nums.length / 2) return max;
        return -1;
    }
}