class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // binary search
        int n = letters.length;
        int start = 0, end = n;
        // start < end, end=n when we choose n-1
        
        while(start < end){
            int mid = start + (end-start)/2;
            if(letters[mid] > target)   end = mid;
            else    start = mid+1;
        }
        return letters[start%n];
    }
}