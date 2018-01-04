class Solution {
    public int[] countBits(int num) {
        int[] re = new int[num+1];
        for(int i = 1; i <= num; i++){
            re[i] = re[i/2] + i%2;
            // re[i] = re[i>>1] + i&1;
        }
        return re;
    }
}