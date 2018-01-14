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
        // maybe a new list is better, remove() is not efficient
        // 3 loops for 3 phases
        List<Interval> re = new ArrayList<>();
        int i = 0, n = intervals.size();
        while(i < n && intervals.get(i).end < newInterval.start) {
            re.add(intervals.get(i++));
        }
        while(i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        re.add(newInterval);
        while(i < n)    re.add(intervals.get(i++));
        return re;
    }
}