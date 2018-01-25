class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // at most 10
        if(n == 0)  return 1;
        if(n > 10)  n = 10;
        
        // lvl 1: 10, lvl>1: 9*9*8*7... cause first layer cannot be 0
        int sum = 10, i = 1;
        int uni = 9, notChosen = 9;
        while(i < n) {
            uni *= notChosen;
            sum += uni;
            notChosen--;
            i++;
        }
        return sum;
    }
}