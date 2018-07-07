/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        return dfs(s);
    }
    
    // Global start and i to let indices walk throught the whole string in one pass
    private int start = 1, i = 1;
    
    public NestedInteger dfs(String s) {
        if(s.length() == 0) return null;
        // If it's just an integer
        if(s.charAt(0) != '[')  return new NestedInteger(Integer.parseInt(s));
        
        NestedInteger res = new NestedInteger();
        
        while(i < s.length()) {
            char c = s.charAt(i);
            
            // Left bracket, pass with the left bracket
            if(c == '[') {
                // Set index and start to corresponding position
                start = ++i;
                NestedInteger ni = dfs(s);
                if(ni != null)  res.add(ni);
            }
            
            // Comma or right bracket
            else if(c == ',' || c == ']') {
                String sub = s.substring(start, i);
                // Avoid "],"
                if(sub.length() != 0) {
                    res.add(new NestedInteger(Integer.parseInt(sub)));
                }
                start = ++i;
                
                // Break if it's right bracket to get to upper recursion
                if(c == ']') {
                    break;
                }    
            }
            // Sign or digit: increment index
            else {
                i++;
            }
        }
        
        return res;
    }
}