class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // explained as triangle inequality
        // if ghost can reach target as fast as pacman, 
        // then it must can intercept pacman in the middle or at the end
        // Just calculate if one path of ghost is <= path of pacman; Lost if so
        int path = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] ghost: ghosts) {
            int pg = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if(pg <= path) return false;
        }
        return true;
    }
}