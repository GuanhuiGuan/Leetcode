class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        
        int[] re = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            if(!map.containsKey(A[i]))  re[i] = -1;
            re[i] = map.get(A[i]);
        }
        return re;
    }
}