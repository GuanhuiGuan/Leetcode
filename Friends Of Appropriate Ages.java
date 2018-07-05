class Solution {
    public int numFriendRequests(int[] ages) {
        // return bruteForce(ages);
        return preSum(ages);
    }
    
    private int preSum(int[] ages) {
        // counts --> num of people == age i
        // sums --> num of people <= age i
        int[] counts = new int[121], sums = new int[121];
        
        for(int age: ages)  counts[age]++;
        
        for(int i = 1; i <= 120; i++)   sums[i] = sums[i-1] + counts[i];
        
        // Only 2 valid conditions: B > 0.5A + 7, A >= B --> (0.5A + 7, A]
        // 0.5A + 7 < A --> A > 14
        int res = 0;
        for(int i = 15; i <= 120; i++) {
            // Only add if people at such age exist
            if(counts[i] == 0)  continue;
            // Delete those <= lowerbound
            int v = sums[i] - sums[i/2 + 7];
            // Delete themselves by minus 1(not sending to themselves)
            res += (v-1) * counts[i];
        }
        return res;
    }
    
    private int bruteForce(int[] ages) {
        int res = 0, n = ages.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(request(ages[i], ages[j]))   res++;
                if(request(ages[j], ages[i]))   res++;
            }
        }
        return res;
    }
    
    private boolean request(int ai, int aj) {
        if(0.5*ai + 7 >= aj ||
           ai < aj ||
           ai < 100 && aj > 100)    return false;
        return true;
    }
}