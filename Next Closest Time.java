class Solution {
    public String nextClosestTime(String time) {
        // unit of each digit
        int[] units = {600, 60, 10, 1};
        char[] re = new char[4];
        
        int curTime = Integer.valueOf(time.substring(0, 2))*60 + Integer.valueOf(time.substring(3));
        
        // check d every iteration to find if a valid next time has been found
        for(int i = 1, d = 0; i <= 1440 && d < 4; i++){
            // calculate next time
            int nextTime = (curTime + i)%1440;
            for(d = 0; d < 4; d++){
                re[d] = (char) ('0' + nextTime/units[d]);
                nextTime %= units[d];
                // check if it's in original string
                if(time.indexOf(re[d]) == -1)   break;
            }
        }
        // String(char[], offset, count)
        return new String(re, 0, 2) + ":" + new String(re, 2, 2);
    }
}