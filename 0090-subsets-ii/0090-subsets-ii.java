class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();
        // Set<List<Integer>> count = new HashSet<>();
        int n = arr.length;
        int m = 1 << n;
        for(int i = 0 ; i<m ; i++){
            List<Integer> a = new ArrayList<>();
            for(int j = 0 ; j<n ;j++){
                if((i>>j) % 2 == 1) a.add(arr[j]);
            }
            Collections.sort(a);
            if(!ans.contains(a))
            ans.add(a);
        }
       
        return ans;

    }
}