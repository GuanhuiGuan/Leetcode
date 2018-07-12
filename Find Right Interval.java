/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        // save the start point and the index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int k = 0; k < intervals.length; k++) {
            map.put(intervals[k].start, k);
        }
        
        int[] res = new int[intervals.length];
        for(int k = 0; k < intervals.length; k++) {
            // ceilingKey: >=; floorKey: <=; higherKey: >; lowerKey: <
            Integer right = map.ceilingKey(intervals[k].end);
            res[k] = right==null? -1: map.get(right);
        }
        
        return res;
    }
}