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
        List<Interval> re = new ArrayList<>();
        int i = 0;
        // those end smaller than newInterval start
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            re.add(intervals.get(i));
            i++;
        }
        // merge overlapping intervals
        while(i < intervals.size() && (intervals.get(i).start <= newInterval.end)){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        re.add(newInterval);
        // add the rest
        while(i < intervals.size()){
            re.add(intervals.get(i));
            i++;
        }
        return re;
    }
}