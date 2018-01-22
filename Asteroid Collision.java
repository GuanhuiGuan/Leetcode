class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        int index = 0; // marks the division between going left and right
        Stack<Integer> goRight = new Stack<>();
        
        for(int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            // going left
            if(cur < 0) {
                while(!goRight.isEmpty()) {
                    int prev = goRight.pop();
                    if(cur + prev == 0) {
                        cur = 0;
                        break;
                    }
                    else if(cur + prev > 0) {
                        cur = prev;
                        break;
                    }
                }
                if(cur < 0){
                    list.add(cur);
                    index++;
                } 
                else if(cur > 0)    goRight.push(cur);
            }
            // going right
            else {
                goRight.push(cur);
            }
        }
        
        while(!goRight.isEmpty()) {
            list.add(index, goRight.pop());
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}