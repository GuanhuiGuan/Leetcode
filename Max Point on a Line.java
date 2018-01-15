/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int re = 0;
        
        // search every point as starting point, clear map before searching(previous points excluded)
        for(int i = 0; i < n; i++) {
            map.clear();
            int dpc = 0, maxline = 0;   // duplicate points, max point count on 1 line
            
            for(int j = i+1; j < n; j++) {
                int dx = (points[i].x - points[j].x);
                int dy = (points[i].y - points[j].y);
                
                // duplicates
                if(dx==0 && dy==0) {
                    dpc++;
                    continue;
                }
                
                // find line
                int div = GCD(dx, dy);
                if(div != 0) { // avoid divide by 0
                    dx /= div;
                    dy /= div;
                }
                if(map.containsKey(dx)) {
                    if(map.get(dx).containsKey(dy)) {
                        map.get(dx).put(dy, map.get(dx).get(dy)+1);
                    }
                    else    map.get(dx).put(dy, 1);
                }
                else {
                    Map<Integer, Integer> tm = new HashMap<>();
                    tm.put(dy, 1);
                    map.put(dx, tm);
                }
                // update maxline
                maxline = Math.max(maxline, map.get(dx).get(dy));
            }
            // after each start point, update result
            re = Math.max(re, maxline+dpc+1);
        }
        
        return re;
    }
    
    public int GCD(int x, int y) {
        while(y != 0) {
            int t = y;
            y = x%y;
            x = t;
        }
        return x;
    }
}