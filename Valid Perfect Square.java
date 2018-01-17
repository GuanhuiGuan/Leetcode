class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0)    return false;
        int lo = 0, hi = num;
        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;
            long mul = mid*mid;
            if(mul == num)  return true;
            if(mul > num)   hi = (int)mid-1;
            else    lo = (int)mid+1;
        }
        return false;
    }
}