class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for(int v = 0; v < V; v++) {
            int ind = K;
            // search left local min
            for(int i = K; i >= 0; i--) {
                // if same height, don't move
                // can use the height of ind to mark current found min
                if(heights[i] < heights[ind]) {
                    ind = i;
                }
                else if(heights[i] > heights[ind]) break;
            }
            // if found on left
            if(ind != K) {
                heights[ind]++;
                continue;
            }
            // search right local min
            for(int i = K; i < heights.length; i++) {
                if(heights[i] < heights[ind]) {
                    ind = i;
                }
                else if(heights[i] > heights[ind]) break;
            }
            // whether moved right or stays
            heights[ind]++;
        }
        return heights;
    }
    
//     public int[] pourWater(int[] heights, int V, int K) {
//         int n = heights.length;
//         for(int v = 0; v < V; v++) {
//             int lh = search(heights, K-1, heights[K], 'l');
//             int rh = search(heights, K+1, heights[K], 'r');
            
//             if(lh != -1)    heights[lh]++;
//             else if(rh != -1)   heights[rh]++;
//             else    heights[K]++;
//         }
//         return heights;
//     }
    
//     // return the first index with local min
//     public int search(int[]heights, int i, int h, char dir) {
//         // deal with out of bound
//         if(i < 0 || i >= heights.length)   return -1;
        
//         int ind = -1;
//         // search right to left(left side)
//         if(dir == 'l') {
//             for(int k = i; k >= 0; k--) {
//                 if(heights[k] < h) {
//                     ind = k;
//                     h = heights[k];
//                 }
//                 else if(heights[k] > h) break;
//             }
//         }
//         // search left to right(right side)
//         else {
//             for(int k = i; k < heights.length; k++) {
//                 if(heights[k] < h) {
//                     ind = k;
//                     h = heights[k];
//                 }
//                 else if(heights[k] > h) break;
//             }
//         }
//         return ind;
//     }
}