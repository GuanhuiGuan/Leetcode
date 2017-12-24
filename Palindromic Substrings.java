class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        if(n == 0)  return count;
        
        for(int i = 0; i < n; i++){
            count = extend(s, i, i, count);
            count = extend(s, i, i+1, count);
        }
        
        return count;
    }
    
    public int extend(String s, int i, int j, int count){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
        return count;
    }
}