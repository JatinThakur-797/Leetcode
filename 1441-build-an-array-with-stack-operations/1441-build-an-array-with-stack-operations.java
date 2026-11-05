class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        Set<Integer> set = new HashSet<>();
        for (int x : target) set.add(x);

        List<String> ops = new ArrayList<>();
        int last = target[target.length - 1];

        for (int x = 1; x <= last; x++) {
            ops.add("Push");
            if (!set.contains(x)) {
                ops.add("Pop");
            }
        }

        return ops;
    

       
    }
}