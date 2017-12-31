class MedianFinder {
    Queue<Long> lower, upper;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // lower part: max heap by negating input
        lower = new PriorityQueue<>();
        // upper part: min heap
        upper = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        upper.offer((long)num);
        lower.offer(- upper.poll());
        // size of upper >= lower
        if(upper.size() < lower.size()){
            upper.offer(-lower.poll());
        }
    }
    
    public double findMedian() {
        if(upper.size() > lower.size()) return (double)upper.peek();
        return (upper.peek() - lower.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */