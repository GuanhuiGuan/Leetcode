class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // array to keep n ugly nums
        int[] ugly = new int[n];
        // array for index of ugly to multiply for each prime
        int[] idx = new int[primes.length];
        // array for ugly ending with this prime(pre saving)
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        
        // the next ugly value
        int next = 1;
        for(int i = 0; i < n; i++) {
            ugly[i] = next;
            // find min across all primes
            next = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                // avoid dpc(when equals previous ugly)
                if(val[j] == ugly[i]) {
                    val[j] = primes[j] * ugly[idx[j]];
                    idx[j]++;
                }
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n-1];
    }
}