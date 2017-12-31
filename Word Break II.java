class Solution {
    Map<String, List<String>> map;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<String, List<String>>();
        return DFS(s, wordDict);
    }
    
    public List<String> DFS(String s, List<String> wordDict) {
        List<String> re = new ArrayList<>();
        
        if(s.length() == 0){
            re.add(""); //important, for ending
            return re;
        }
        
        // avoid repetitive calculations
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(String word: wordDict){
            if(s.startsWith(word)){
                
                List<String> list = DFS(s.substring(word.length()), wordDict);
                for(String str: list){
                    if(str.isEmpty())   str = word;
                    else    str = word + " " + str;
                    re.add(str);
                }
            }
        }
        map.put(s, re);
        return re;
    }
}