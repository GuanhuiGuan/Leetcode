class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minL = words.length+1;
        int ind = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(ind != -1 && (word1.equals(word2) || !words[ind].equals(words[i]))){
                    minL = Math.min(minL, i-ind);
                }
                ind = i;
            }
        }
        return minL;
    }
}