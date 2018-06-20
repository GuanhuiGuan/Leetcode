/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    // tmpPtr: points to a position of the tmp
    // tmpLen: the valid length of the tmp
    private int tmpPtr = 0, tmpLen = 0;
    private char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        // i is the to be returned index
        int i = 0;
        while(i < n) {
            // when tmpPtr == 0, renew tmpLen
            if(tmpPtr == 0) {
                tmpLen = read4(tmp);
            }
            // when tmpLen == 0, the end of array is met
            if(tmpLen == 0)    break;
            // transfer tmp to buf
            while(i < n && tmpPtr < tmpLen)   buf[i++] = tmp[tmpPtr++];
            // reset tmpPtr when at the end of tmp by setting it to 0
            if(tmpPtr == tmpLen)   tmpPtr = 0;
        }
        return i;
    }
}