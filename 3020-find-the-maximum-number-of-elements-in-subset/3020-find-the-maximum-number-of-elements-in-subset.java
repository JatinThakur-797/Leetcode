class Solution {
    public int maximumLength(int[] nums) {
        // [5,4,1,2,2] -> 32
        // [1,2,2,4,5] ->  1,1
        //                 2,2
        //                 4,2
        //                 16,1

        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

       
        if(map.containsKey(1)){
            int val = map.get(1);
            if(val % 2 == 0){
                ans = Math.max(ans, val - 1);
            }else{
                ans = Math.max(ans, val);
            }
        }
        
        for(int key : map.keySet()){

            if(key == 1) continue;

            int currentLength = 0;
            long currentNum = key;
            while(map.containsKey((int) currentNum) && (map.get((int ) currentNum) >= 2)){

                currentLength += 2;
                currentNum *= currentNum;

                if(currentNum == 1000000000) break;
            }

            if(map.containsKey((int) currentNum)){
                currentLength += 1;
            }else{
                currentLength -=1;
            }

            ans = Math.max(currentLength, ans);
        }
        return ans;

    }
}