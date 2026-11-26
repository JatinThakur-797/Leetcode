class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums){
            q.add(n);
        }

        for(int i = 0 ; i<k-1 ; i++){
            q.remove();
        }
        return q.remove();
    }
}