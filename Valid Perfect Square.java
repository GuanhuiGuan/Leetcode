class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            // bit manupulation to divide by 2
            // long to avoid overflow
            long mid = (left + right)>>>1;
            long sq = mid*mid;
            if(sq == num)  return true;
            if(sq > num)    right = (int) mid-1;
            else    left = (int) mid+1;
        }
        return false;
    }
}