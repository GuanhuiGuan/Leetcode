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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> re = new ArrayList<>();
        int n = intervals.size();
        if(n == 0)  return re;
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start==i2.start? i1.end-i2.end: i1.start-i2.start;
            }
        });
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(int i = 0; i < n; i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= end) {
                start = Math.min(cur.start, start);
                end = Math.max(cur.end, end);
            }
            // only add when a disjoint emerges, avoid duplicates
            else {
                re.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        // last interval
        re.add(new Interval(start, end));
        
        return re;
    }
}