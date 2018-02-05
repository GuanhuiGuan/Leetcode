class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        // (out - in) degree diff
        int deg = 1;
        
        // every node takes 1 in degree, null 0 outdeg, node 2 outdeg
        for(int i = 0; i < ss.length; i++) {
            deg--;
            if(deg < 0) return false;
            if(!ss[i].equals("#"))  deg += 2;
        }
        return deg == 0;
    }
}