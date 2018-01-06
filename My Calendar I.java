class MyCalendar {
    // key(start), value(end)
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // get the max start <= start
        Integer floor = map.floorKey(start);
        // check if exists or if its end intersects
        if(floor != null && map.get(floor) > start) return false;
        // get min start >= start
        Integer ceil = map.ceilingKey(start);
        // check if exists or if its start intersects
        if(ceil != null && ceil < end) return false;
        // can insert
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */