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
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        if(points.length < 2)   return points.length;
        
        for(int i = 0; i < points.length; i++) {
            // CLEAR MAP EVERY TIME!
            map.clear();
            int dpc = 0, maxLine = 0;
            for(int j = i+1; j < points.length; j++) {
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                // duplicate
                if(dx == 0 && dy == 0) {
                    dpc++;
                    continue;
                }
                // online
                int gcd = getGcd(dx, dy);
                if(gcd != 0) {
                    dx /= gcd;
                    dy /= gcd;
                }
                if(map.containsKey(dx)) {
                    Map<Integer, Integer> tm = map.get(dx);
                    if(tm.containsKey(dy)) {
                        tm.put(dy, tm.get(dy)+1);
                    }
                    else {
                        tm.put(dy, 1);
                    }
                }
                else {
                    Map<Integer, Integer> tm = new HashMap<>();
                    tm.put(dy, 1);
                    map.put(dx, tm);
                }
                maxLine = Math.max(maxLine, map.get(dx).get(dy));
            }
            res = Math.max(res, dpc+maxLine+1);
        }
        return res;
    }
    
    public int getGcd(int x, int y) {
        while(y != 0) {
            int t = x;
            x = y;
            y = t%y;
        }
        return x;
    }
}