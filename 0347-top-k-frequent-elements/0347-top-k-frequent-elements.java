class Solution {
    
    class A {
        int val ;
        int freq;

        A(int val , int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
      PriorityQueue<A> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.freq, b.freq));
    
    Map<Integer, Integer> map = new HashMap<>();
    for(int n : nums){
        map.put(n , map.getOrDefault(n, 0) + 1);
    }

    for(int key : map.keySet()){
        pq.add(new A(key , map.get(key)));
        if(pq.size() > k){
            pq.poll();
        }
    }


    int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().val;
        }
      return result;
    }   
}