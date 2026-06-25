class Solution {
   class SegmentTree {
    int[] tree;
    int size;

    public SegmentTree(int n) {
        size = n;
        tree = new int[4 * n];
    }

    // Add 1 at position idx
    public void update(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node]++;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node + 1, start, mid, idx);
        else
            update(2 * node + 2, mid + 1, end, idx);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Count frequency in range [l, r]
    public int query(int node, int start, int end, int l, int r) {

        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r)
                + query(2 * node + 2, mid + 1, end, l, r);
    }
}

    

    public long countMajoritySubarrays(int[] nums, int target) {
        // [0,1,2,2]
    //     -> [-1,1,1,-1]
    //   2=[0,3]->1=[0,1]-> [0]=0
    //                      [1]=1
    //            1=[1,2]-> [1]=1
    //                   -> [2]=0
      int n = nums.length;

        // Convert to +1 / -1
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int id = 0;

        for (int x : sorted) {
            if (!map.containsKey(x))
                map.put(x, id++);
        }

        SegmentTree st = new SegmentTree(id);

        long ans = 0;

        for (int p : prefix) {

            int idx = map.get(p);

            // Count previous prefix sums < current prefix
            if (idx > 0)
                ans += st.query(0, 0, id - 1, 0, idx - 1);

            // Insert current prefix
            st.update(0, 0, id - 1, idx);
        }

        return ans;
    
    }
}