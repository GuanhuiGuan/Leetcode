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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(Interval it: intervals) {
            if(newInterval.end < it.start) {
                res.add(new Interval(newInterval.start, newInterval.end));
                newInterval = it;
            }
            else if(newInterval.start > it.end) {
                res.add(it);
            }
            else {
                newInterval.start = Math.min(newInterval.start, it.start);
                newInterval.end = Math.max(newInterval.end, it.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}