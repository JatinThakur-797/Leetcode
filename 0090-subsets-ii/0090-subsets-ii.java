class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {

           Arrays.sort(arr);
        
       Set<List<Integer>> uniqueSubsets = new LinkedHashSet<>();
        
        int n = arr.length;
        int m = 1 << n; 
        
        for (int i = 0; i < m; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
               if (((i >> j) & 1) == 1) {
                    a.add(arr[j]);
                }
            }
            uniqueSubsets.add(a);
        }
        
        return new ArrayList<>(uniqueSubsets);
    
    }
}