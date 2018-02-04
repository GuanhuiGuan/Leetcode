class Solution {
    List<String> re = new ArrayList<>();
    
    public List<String> readBinaryWatch(int num) {
        if(num > 10 || num < 0)    return re;
        dfs(new int[10], num, 0);
        return re;
    }
    
    public void dfs(int[] watch, int n, int start) {
        if(n == 0) {
            int h = 0, m = 0;
            for(int i = 5; i >= 0; i--) {
                m = 2*m + watch[i];
            }
            // minute limit
            if(m > 59)  return;
            
            for(int i = 9; i >= 6; i--) {
                h = 2*h + watch[i];
            }
            // hour limit
            if(h > 11)  return;
            
            // m should be double digits
            String ms = String.valueOf(m);
            if(ms.length() == 1)    ms = "0" + ms;
            re.add(h + ":" + ms);
        }
        else {
            for(int i = start; i < watch.length; i++) {
                if(watch[i] == 0) {
                    watch[i] = 1;
                    dfs(watch, n-1, i+1);
                    watch[i] = 0;
                }
            }
        }
    }
}