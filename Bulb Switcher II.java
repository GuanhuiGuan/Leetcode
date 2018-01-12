class Solution {
    public int flipLights(int n, int m) {
        // 1+2 == 3, 1+3 == 2, 2+3 == 1
        if(n==0 || m==0)    return 1;
        if(n==1)    return 2;
        // all, 1on, 2on
        if(n==2 && m==1)    return 3;
        // none, 1on, 2on, all
        if(n==2)    return 4;
        // n>2:
        // 1, 2, 3, 4
        if(m==1)    return 4;
        // none, 1, 2, 3, 1+4, 2+4, 3+4
        if(m==2)    return 7;
        // none, 1, 2, 3, 4, 1+4, 2+4, 3+4
        if(m>=3)    return 8;
        return 8;
    }
}