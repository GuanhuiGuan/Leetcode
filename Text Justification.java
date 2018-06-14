class Solution {
    List<String> res = new ArrayList<>();
    List<String> curWords = new ArrayList<>();
    int curWordLen = 0;
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            // prevWords + spaces + newWord
            if(curWordLen + curWords.size() + word.length() <= maxWidth) {
                curWords.add(word);
                curWordLen += word.length();
            }
            else {
                addToList(words, maxWidth, i);
                
                // Reset and stay at current word
                curWords = new ArrayList<>();
                curWordLen = 0;
                i--;
            }
        }
        // don't forget the last line
        addToList(words, maxWidth, words.length);
        return res;
    }
    
    public void addToList(String[] words, int maxWidth, int i) {
        // set up interval spaces and tail spaces
        StringBuilder str = new StringBuilder();
        int spaces = maxWidth - curWordLen;
        int cnt = curWords.size(), interval = 1, extra = 0, tail = maxWidth - (cnt-1) - curWordLen;
        if(cnt != 1 && i != words.length) {
            interval = spaces / (cnt-1);
            extra = spaces - interval * (cnt-1);
            tail = 0;
        }
        // append to str
        for(int j = 0; j < cnt; j++) {
            // add extra one space if extra > 0
            str.append(curWords.get(j))
                .append(spaceStr(j, cnt, interval, extra--, tail));
        }
        res.add(str.toString());
    }
    
    public String spaceStr(int j, int cnt, int interval, int extra, int tail) {
        if(j == cnt-1)   return _spaces(tail);
        else    return _spaces(interval + (extra > 0? 1: 0));
    }
    
    public String _spaces(int n) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < n; i++) {
            s.append(' ');
        }
        return s.toString();
    }
}