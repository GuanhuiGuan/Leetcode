class MovingAverage {
    
    long sum = 0;
    int size = 0;
    Queue<Integer> q = new LinkedList<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        sum += val;
        q.offer(val);
        // Pop if exceeds size
        if(q.size() > size) {
            sum -= q.poll();
        }
        return (double) (sum) / (double) (q.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */