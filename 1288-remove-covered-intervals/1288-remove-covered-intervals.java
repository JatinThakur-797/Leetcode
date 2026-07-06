class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int maxEnd = 0;
        int remaining = 0;
        for(int[] in : intervals){
            
            if(in[1] > maxEnd){
                remaining++;
                maxEnd = in[1];
            }
        }
        return remaining;
    }
}