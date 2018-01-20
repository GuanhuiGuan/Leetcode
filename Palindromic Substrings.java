class Solution {
    // Manacher's algorithm O(n)
    public int countSubstrings(String s) {
        // build @#a#b#...c#$
        char[] cs = new char[2*s.length()+3];
        cs[0] = '@';
        cs[1] = '#';
        cs[cs.length-1] = '$';
        for(int i = 0; i < s.length(); i++) {
            cs[2*i+2] = s.charAt(i);
            cs[2*i+3] = '#';
        }
        // count[i] is the len of 1-side in cs, and also the whole pld len in s
        int[] count = new int[cs.length];
        int center = 0, right = 0;
        
        // always checking radius(one side)
        for(int i = 1; i < cs.length-1; i++) {
            // check if it can be reflected, get min
            if(i < right) {
                count[i] = Math.min(right-i, count[2*center-i]);
            }
            // check if can continue expand
            while(cs[i-count[i]-1] == cs[i+count[i]+1]) count[i]++;
            // check if mirror needs update
            if(i+count[i] > right) {
                center = i;
                right = i+count[i];
            }
        }
        
        int re = 0;
        for(int c: count) {
            // counting how many pld in such max pld length
            re += (c+1)/2;
        }
        return re;
    }
    
//     // usual solution O(n^2)
//     public int countSubstrings(String s) {
//         char[] cs = s.toCharArray();
//         int count = 0;
//         for(int i = 0; i < cs.length; i++) {
//             count += pldExpand(cs, i, i) + pldExpand(cs, i-1, i);
//         }
//         return count;
//     }
    
//     public int pldExpand(char[] cs, int i, int j) {
//         int sum = 0;
//         while(i>=0 && j<cs.length) {
//             if(cs[i--] == cs[j++])  sum++;
//             else    break;
//         }
//         return sum;
//     }
}