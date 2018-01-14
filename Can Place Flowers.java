class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // greedy, find all valid positions, check prev and next of pos i
        // if out of bound, they're 0
        int count = 0, len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            int prev = 0, next = 0;
            if(flowerbed[i] == 1)   continue;
            if(i != 0)  prev = flowerbed[i-1];
            if(i != len-1)  next = flowerbed[i+1];
            if(prev==0 && next==0) {
                flowerbed[i] = 1;
                count++;
            }
            if(count >= n)  break;
        }
        return count >= n;
    }
}