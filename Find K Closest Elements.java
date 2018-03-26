class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k > arr.length) return null;
        int n = arr.length;
        int lo = 0, hi = n - k;
        
        // binary search find the left starting point
        while(lo < hi) {
            int m = lo + (hi - lo) / 2;
            if(x - arr[m] > arr[m+k] - x) lo = m + 1;
            else hi = m;
        }
        int[] res = Arrays.copyOfRange(arr, lo, lo + k);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}