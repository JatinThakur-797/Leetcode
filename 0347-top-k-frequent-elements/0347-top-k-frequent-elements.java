class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n , map.getOrDefault(n, 1) + 1);
        }

        for(int key : map.keySet()){
            q.add(new int[]{key, map.get(key)});
        }
        int[] arr = new int[k];
        for(int i = 0 ; i< k; i++){
            int[] val = q.remove();
            arr[i] = val[0];
        }
        return arr;
    }
}