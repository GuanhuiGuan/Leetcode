class Solution {
    public int maximumSwap(int num) {
        char[] cs = Integer.toString(num).toCharArray();
        // mark the rightmost index of each digit(0~9)
        int[] rightMostIndex = new int[10];
        for(int i = 0; i < cs.length; i++)  rightMostIndex[cs[i] - '0'] = i;
        
        // Search from left, see if can swap with digit larger
        for(int i = 0; i < cs.length; i++) {
            for(int v = 9; v > (cs[i] - '0'); v--) {
                // index == 0 --> first digit or none, cannot be swapped
                // also index > i
                if(rightMostIndex[v] > 0 && rightMostIndex[v] > i) {
                    swap(cs, i, rightMostIndex[v]);
                    return Integer.parseInt(new String(cs));
                }
            }
        }
        
        // already max
        return num;
    }
    
    private void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}