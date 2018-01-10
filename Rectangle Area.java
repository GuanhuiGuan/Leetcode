class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // find the overlap by following
        int left = Math.max(A, E), right = Math.max(left, Math.min(C, G));
        int down = Math.max(B, F), up = Math.max(down, Math.min(D, H));
        return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(up-down);
    }
}