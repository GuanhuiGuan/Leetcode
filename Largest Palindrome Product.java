class Solution {
    public int largestPalindrome(int n) {
        // corner cases: n==1
        if(n == 1)  return 9;
        
        long ub = (long)Math.pow(10, n)-1;
        long lb = ub/10;
        
        long maxProd = ub*ub;
        // first half to construct palindrome
        long fH = maxProd/(long)(Math.pow(10, n));
        long pld = getPld(fH);
        
        boolean pldFound = false;
        while(!pldFound) {
            // update pld
            pld = getPld(fH);
            for(long i = ub; i > lb; i--) {
                // counterpart > upperbound || square smaller(those after would be even smaller)
                if(pld/i > ub || i*i < pld) break;
                
                if(pld%i == 0) {
                    pldFound = true;
                    break;
                }
            }
            // adjust fisrt half 1 by 1 to find new palindrome
            fH--;
        }
        return (int) (pld%1337);
    }
    
    public long getPld(long fH) {
        String out = String.valueOf(fH) + new StringBuilder().append(fH).reverse().toString();
        return Long.parseLong(out);
    }
}