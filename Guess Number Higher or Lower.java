/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(guess(mid) == 0)  return mid;
            // ori num is greater
            else if(guess(mid) > 0)    lo = mid+1;
            // ori num is smaller
            else if(guess(mid) < 0)   hi = mid-1;
        }
        return lo;
    }
}