class Solution {
    public boolean isUgly(int num) {
        // divide all factors of ugly num, check if remainder is 1
        int[] div = {2, 3, 5};
        for(int i = 0; i < div.length && num > 0; i++) {
            while(num%div[i] == 0) {
                num /= div[i];
            }
        }
        return num == 1;
    }
}