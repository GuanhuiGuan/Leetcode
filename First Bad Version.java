/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 1, end = n;
        // no equal cause we need them to be equal in the end
        while(st < end){
            // avoid (st + end) too large to overflow
            int mid = st + (end-st)/2;
            if(isBadVersion(mid)){
                end = mid;
                // because if mid is the first bad case, we don't wanna pass it
            }
            else{
                st = mid+1;
            }
        }
        return st;
    }
}