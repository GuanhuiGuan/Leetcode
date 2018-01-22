class Solution {
    public String getPermutation(int n, int k) {
        // iterative, k decrements by m*(n-i)!
        // factorial
        int[] ftr = new int[n];
        ftr[0] = 1;
        for(int i = 1; i < n; i++) {
            ftr[i] = i*ftr[i-1];
        }
        // nums list, need to remove one by one
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++)  nums.add(i);
        
        StringBuilder s = new StringBuilder();
        k--; // start from 0 to k-1
        for(int i = 1; i <= n; i++) {
            int n_index = k/(ftr[n-i]);
            s.append(nums.get(n_index));
            nums.remove(n_index);
            k %= (ftr[n-i]);
        }
        return s.toString();
    }
}