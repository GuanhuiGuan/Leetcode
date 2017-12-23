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
        if(n == 0)  return 0;
        if(n <= 2)  return n;
        int f = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        // start from 0 to n-2 points
        for(int i = 0; i < n; i++){
            map.clear();
            int duplicate = 1; // the point itself counts 1
            int maxC = 0;
            
            for(int j = i+1; j < n; j++){
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                
                // duplicate points
                if(dx == 0 && dy == 0){
                    duplicate++;
                    continue;
                }  
                
                int gcd = getGCD(dx, dy);
                if(gcd != 0){
                    dx /= gcd;
                    dy /= gcd;
                }
                if(map.containsKey(dx)){
                    if(map.get(dx).containsKey(dy)){
                        map.get(dx).put(dy, map.get(dx).get(dy)+1);
                    }
                    else{
                        map.get(dx).put(dy, 1);
                    }
                }
                else{
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(dy, 1);
                    map.put(dx, m);
                }
                maxC = Math.max(map.get(dx).get(dy), maxC);
            }
            f = Math.max(f, duplicate+maxC);
        }
        return f;
    }
    
    // greatest common devisor
    public int getGCD(int a, int b){
        if(b == 0)  return a;
        return getGCD(b, a%b);
    }
}