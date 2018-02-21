class Solution {
    public int monotoneIncreasingDigits(int N) {
        // search right to left, find the top non-increasing, decrese by 1 and all the rest change to 9
        // if none, return original
        String s = String.valueOf(N);
        char[] cs = s.toCharArray();
        
        int topChange = cs.length;
        for(int i = cs.length-2; i >= 0; i--) {
            // found and change
            if(cs[i] > cs[i+1]) {
                cs[i]--;
                topChange = i;
            }
        }
        
        // swap those behind topChange as 9
        for(int j = topChange+1; j < cs.length; j++)    cs[j] = '9';
        
        return cArr2Int(cs);
    }
    
    public int cArr2Int(char[] cs) {
        String s = new String(cs);
        return Integer.parseInt(s);
    }
}