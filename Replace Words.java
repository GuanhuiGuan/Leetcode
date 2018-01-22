class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] ss = sentence.split(" ");
        StringBuilder s = new StringBuilder();
        
        for(String word: ss) {
            String newWord = search(dict, word);
            s.append(newWord).append(" ");
        }
        // del last space
        s.delete(s.length()-1, s.length());
        return s.toString();
    }
    
    public String search(List<String> dict, String word) {
        for(int i = 1; i < word.length(); i++) {
            String root = word.substring(0, i);
            if(dict.contains(root)) return root;
        }
        return word;
    }
}