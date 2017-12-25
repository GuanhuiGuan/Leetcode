class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0)    return false;
        int start = 0, end = (int)Math.sqrt(c);
        while(start <= end){
            int sum = start*start + end*end;
            if(sum == c)  return true;
            if(sum < c)   start++;
            else    end--;
        }
        return false;
    }
}