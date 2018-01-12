class Solution {
    public int findMinArrowShots(int[][] points) {
        // Greedy; sort by the end, shoot at the end
        int n = points.length;
        if(n == 0)  return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] x1, int[] x2) {return x1[1]-x2[1];}
        });
        
        int arr = 1, pos = points[0][1];
        for(int[] bl: points) {
            if(bl[0] <= pos)    continue;
            arr++;
            pos = bl[1];
        }
        return arr;
    }
}