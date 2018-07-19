/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    // Use lower limit as key
    private TreeMap<Integer, Interval> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        // Find lowerkey and higherkey
        if(map.containsKey(val))    return;
        Integer low = map.lowerKey(val), high = map.higherKey(val);
        // Merge both sides, merge lower, merge higher, or insert new
        if(low != null && high != null && map.get(low).end == val-1 && high == val+1) {
            map.get(low).end = map.get(high).end;
            map.remove(high);
        }
        else if(low != null && map.get(low).end >= val-1) {
            map.get(low).end = Math.max(val, map.get(low).end);
        }
        else if(high != null && high <= val+1) {
            map.put(val, map.get(high));
            map.get(val).start = val;
            map.remove(high);
        }
        else    map.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */