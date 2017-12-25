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
// Better solution

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // add the upper lvl multiple times instead of product
        int unweighted = 0, weighted = 0;
        
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextList = new ArrayList<>();
            
            for(NestedInteger item : nestedList){
                if(item.isInteger()){
                    unweighted += item.getInteger();
                }
                else{
                    nextList.addAll(item.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextList;
        }
        return weighted;
    }
}


// Original


class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        expand(nestedList, list, 1);
        
        int sum = 0;
        int rel = 1;
        for(int i = list.size() - 1; i >= 0; i--){
            sum += rel*list.get(i);
            rel++;
        }
        return sum;
    }
    
    public void expand(List<NestedInteger> nestedList, List<Integer> list, int lvl){
        for(NestedInteger item: nestedList){
            if(item.isInteger()){
                while(list.size() < lvl){
                    list.add(0);
                }
                
                int old = list.get(lvl-1);
                // this is how list is set
                list.set(lvl-1, old + item.getInteger());
            }
            else{
                expand(item.getList(), list, lvl+1);
            }
        }
    }
}