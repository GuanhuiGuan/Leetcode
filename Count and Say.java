class Solution {
    public String countAndSay(int n) {
        String prev = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            int count = 0;
            char prevC = ' ';
            for(int j = 0; j < prev.length(); j++) {
                char c = prev.charAt(j);
                if(j == 0 || c == prevC) {
                    prevC = c;
                    count++;
                }
                else {
                    str.append(count).append(prevC);
                    count = 1;
                    prevC = c;
                }
            }
            if(count != 0)  str.append(count).append(prevC);
            prev = str.toString();
        }
        return prev;
    }
}