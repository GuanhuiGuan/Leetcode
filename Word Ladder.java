class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // two end BFS
        Set<String> wordSet = new HashSet<>(wordList), sS = new HashSet<>(), eS = new HashSet<>(), visited = new HashSet<>();
        sS.add(beginWord);
        if(wordSet.contains(endWord))   eS.add(endWord);
        // endWord maybe not in wordList
        
        
        //start word counts as one
        int len = 1;
        
        // sS would be updated per iteration, if one set is empty, can't find
        while(!sS.isEmpty() && !eS.isEmpty()){
            // let start set be the smaller one
            if(sS.size() > eS.size()){
                Set<String> t = sS;
                sS = eS;
                eS = t;
            }
            
            // new set for next update of sS
            Set<String> temp = new HashSet<>();
            for(String word: sS){
                char[] cArr = word.toCharArray();
                for(int i = 0; i < cArr.length; i++){
                    // save current letter to change it back
                    char save = cArr[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        // not the same word
                        if(save == c)   continue;
                        
                        cArr[i] = c;
                        String newWord = String.valueOf(cArr);
                        
                        // two sets connect
                        if(eS.contains(newWord))    return len+1;
                        // not visited but in wordlist
                        if(!visited.contains(newWord) && wordSet.contains(newWord)){
                            visited.add(newWord);
                            temp.add(newWord);
                        }
                        
                        cArr[i] = save;
                    }
                }
            }
            // update sS and len of found words
            sS = temp;
            len++;
        }
        // one set is empty; BFS failed
        return 0;
    }
}