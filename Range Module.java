class RangeModule {
    // TreeMap O(logn) for query
    TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer low = map.floorKey(left);
        Integer high = map.floorKey(right);
        if(high == null) map.put(left, right);  // if high is null, low must be null
        // consider start point:
        // if start at low, rightside could be 1 out of 3
        else if(low != null && map.get(low) >= left) map.put(low, Math.max(map.get(low), Math.max(right, map.get(high))));
        // else start at left
        else    map.put(left, Math.max(right, map.get(high)));
        
        // clean up duplicates within (left, right] (different from true intervals to avoid deleting the boundaries)
        Map<Integer, Integer> del = map.subMap(left, false, right, true);
        Set<Integer> delSet = new HashSet<>(del.keySet());
        map.keySet().removeAll(delSet);
    }
    
    public boolean queryRange(int left, int right) {
        Integer low = map.floorKey(left);
        if(low != null && map.get(low) >= right)    return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer low = map.floorKey(left);
        Integer high = map.floorKey(right);
        // must check high first since resetting low may mess with map.get(high) when high==low
        if(high != null && map.get(high) > right) {
            map.put(right, map.get(high));
        }
        if(low != null && map.get(low) > left) {
            map.put(low, left);
        }
        
        // clean up duplicates within [left, right)
        Map<Integer, Integer> del = map.subMap(left, true, right, false);
        Set<Integer> delSet = new HashSet<>(del.keySet());
        map.keySet().removeAll(delSet);
    }
}

// // LinkedList, O(n) for each operation
// class RangeModule {
    
//     class Interval {
//         int start, end;
//         public Interval(int s, int e) {
//             start = s;
//             end = e;
//         }
//     }
    
//     List<Interval> list;

//     public RangeModule() {
//         list = new ArrayList<>();
//     }
    
//     public void addRange(int left, int right) {
//         List<Interval> newList = new LinkedList<>();
//         for(Interval i: list) {
//             if(i.end < left)    newList.add(i);
//             else if(i.start > right) {
//                 newList.add(new Interval(left, right));
//                 left = i.start;
//                 right = i.end;
//             }
//             else {
//                 left = Math.min(left, i.start);
//                 right = Math.max(right, i.end);
//             }
//         }
//         newList.add(new Interval(left, right));
//         list = newList;
//     }
    
//     public boolean queryRange(int left, int right) {
//         for(Interval i: list) {
//             if(left >= i.start && right <= i.end)   return true;
//             if(right <= i.start)    break;
//         }
//         return false;
//     }
    
//     public void removeRange(int left, int right) {
//         List<Interval> newList = new LinkedList<>();
//         for(Interval i: list) {
//             if(i.end < left)    newList.add(i);
//             else if(i.start > right) {
//                 newList.add(i);
//             }
//             else {  // intersection
//                 int cutLeft = Math.min(i.end, left);
//                 int cutRight = Math.max(i.start, right);
//                 if(i.start < cutLeft) newList.add(new Interval(i.start, cutLeft));
//                 if(i.end > cutRight) newList.add(new Interval(cutRight, i.end));
//             }
//         }
//         list = newList;
//     }
// }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */