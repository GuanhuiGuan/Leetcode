class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re = new ArrayList<>();
        
        // map every word in words
        Map<String, Integer> dict = new HashMap<>();
        for(String word: words) {
            dict.put(word, dict.getOrDefault(word, 0)+1);
        }
        
        // start from every possible position, check if such scenario works
        Map<String, Integer> used = new HashMap<>();
        int n = words.length, len = words[0].length();
        for(int i = 0; i < s.length() - (n*len) + 1; i++) {
            used.clear();
            int j = 0;
            while(j < n) {
                // get a new word
                String word = s.substring(i+j*len, i+(j+1)*len);
                if(dict.containsKey(word)) {
                    used.put(word, used.getOrDefault(word, 0)+1);
                    // if exceeds
                    if(dict.get(word) < used.get(word)) break;
                }
                // not in dict, not concatenated
                else    break;
                j++;
            }
            // found one, save
            if(j == n)  re.add(i);
        }
        return re;
    }
}