class Solution {
    public int scheduleCourse(int[][] courses) {
        // Greedy
        // Sort by end day ascendingly
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        // Heap sort by duration descendingly
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        
        int total = 0;
        for(int[] course: courses) {
            total += course[0];
            heap.offer(course);
            // Delete previous one with longest duration
            if(total > course[1])   total -= heap.poll()[0];
        }
        return heap.size();
    }
}