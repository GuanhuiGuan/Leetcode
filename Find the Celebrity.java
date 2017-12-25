/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int c = 0;
        // pick celebrity
        // If celebrity is k, 0->k-1 know someone, k doesn't know k+1->n-1
        for(int i = 1; i < n; i++){
            if(knows(c, i)) c = i;
        }
        
        // check if valid
        for(int i = 0; i < n; i++){
            if(c != i && (knows(c, i) || !knows(i, c))) return -1;
        }
        return c;
    }
}