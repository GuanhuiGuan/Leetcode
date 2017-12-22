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

//______________________Improved________________
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return expand(nestedList, 1);
    }
    
    
    public int expand(List<NestedInteger> list, int d){
        int sum = 0;
        for(NestedInteger item: list){
            if(item.isInteger()){
                sum += d*item.getInteger();
            }
            else{
                sum += expand(item.getList(), d+1);
            }
        }
        return sum;
    }
}


class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        List<Integer> depthSum = new ArrayList<>();
        depthSum.add(0);
        if(nestedList.size() == 0)  return 0;
        
        
        for(NestedInteger item: nestedList){
            expand(item, 1, depthSum);
        }
        
        int sum = 0;
        for(int i = 0; i < depthSum.size(); i++){
            sum += (i+1)*depthSum.get(i);
        }
        return sum;
    }
    
    
    public void expand(NestedInteger item, int d, List<Integer> depthSum){
        if(item.isInteger()){
            // if(depthSum.size() < d){
            //     depthSum.add(item.getInteger());
            // }
            // else{
            depthSum.set(d-1, depthSum.get(d-1)+item.getInteger());
            // }
        }
        else{
            if(depthSum.size() <= d){
                depthSum.add(0);
            }
            for(NestedInteger nextItem: item.getList()){
                expand(nextItem, d+1, depthSum);
            }
            
        }
    }
}