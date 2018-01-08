class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3="zxcvbnm";
        String[] keyboard = {row1, row2, row3};
        Map<String, Integer> map = new HashMap<>();
        String[] out = new String[words.length];
        int k = 0;
        
        for(String word: words) {
            map.clear();
            for(int i = 0; i < word.length(); i++) {
                for(String row: keyboard) {
                    if(row.contains(word.toLowerCase().substring(i, i+1))){
                        map.put(row, map.containsKey(row)? map.get(row)+1: 1);
                        break;
                    }    
                }
            }
            if(map.size() == 1){
                out[k] = word;
                k++;
            }
        }
        return Arrays.copyOfRange(out, 0, k);
    }
}