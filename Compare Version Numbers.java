class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int mlen = Math.max(ss1.length, ss2.length);
        
        for(int i = 0; i < mlen; i++) {
            Integer x1 = (i<ss1.length)? Integer.parseInt(ss1[i]): 0;
            Integer x2 = (i<ss2.length)? Integer.parseInt(ss2[i]): 0;
            int cmp = intCmp(x1, x2);
            if(cmp != 0)    return cmp;
        }
        return 0;
    }
    
    public int intCmp(int x1, int x2) {
        if(x1 < x2) return -1;
        if(x1 > x2) return 1;
        else    return 0;
    }
}