class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 0)  return 0;
        // Arrays.sort(chars);
        
        int head = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            count++;
            // last char or diff char
            if(i == n-1 || chars[i] != chars[i+1]) {
                chars[head++] = chars[i];
                
                if(count > 1) {
                    char[] cs = String.valueOf(count).toCharArray();
                    for(char c: cs) chars[head++] = c;
                }
                count = 0;
            }
        }
        return head;
    }
}