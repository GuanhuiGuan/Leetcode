class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || s.length() < t.length())   return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i))+1 : 1);
            // if(map.containsKey(t.charAt(i)))    map.put(t.charAt(i), map.get(t.charAt(i))+1);
            // else    map.put(t.charAt(i), 1);
        }
        
        int start = 0, end = 0;
        int subS = 0;
        int len = s.length()+1;
        int counter = t.length();
        
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.get(s.charAt(end))-1);
                // only adjust counter if it's not redundant
                if(map.get(s.charAt(end)) >= 0) counter--;
            }
            
            while(counter == 0){
                // update outcome
                if(end - start + 1 < len){
                    subS = start;
                    len = end - start + 1;
                }
                
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start)) > 0)    counter++;
                }
                start++;
            }
            end++;
        }
        // avoid all invalid cases
        if(len > s.length())    return "";
        return s.substring(subS, subS+len);
    }
}