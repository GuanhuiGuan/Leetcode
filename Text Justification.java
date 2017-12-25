class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> re = new ArrayList<>();
        
        int move = 0;
        while(move < words.length){
            // start of a line
            int lStart = move;
            int count = words[move].length();
            move++;
            
            while(move < words.length && words[move].length() + 1 + count <= maxWidth){
                count += words[move].length() + 1;    // space in front of a word
                move++;
            }
            
            // found words in one line. Specify gaps
            int gap = 1, extra = 0;
            // beware of division by 0
            if(move < words.length && move != lStart + 1){
                // #gap: 1 less than #words in a line
                int gapC = move - lStart - 1;
                gap += (maxWidth - count)/gapC;
                extra = (maxWidth - count)%gapC;
            }
            // spaces for one gap
            String sGap = getSpaces(gap);
            
            String line = words[lStart];
            lStart++;
            // special gaps(add space first)
            while(extra > 0){
                line += sGap + " ";
                line += words[lStart];
                extra--;
                lStart++;
            }
            // normal gaps
            while(lStart < move){
                line += sGap;
                line += words[lStart];
                lStart++;
            }
            // last line fill up
            line += getSpaces(maxWidth - line.length());
            re.add(line);
        }
        return re;
    }
    
    public String getSpaces(int x){
        String s = "";
        while(x > 0){
            s += " ";
            x--;
        }
        return s;
    }
}