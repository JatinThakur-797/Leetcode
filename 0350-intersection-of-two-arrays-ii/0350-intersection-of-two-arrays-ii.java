class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                ans.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] a = new int[ans.size()];
        int idx = 0;
        for(int an : ans){
            a[idx] = an;
            idx++;
        }
        return a;
    }
}