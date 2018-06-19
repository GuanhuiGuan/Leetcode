/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        // read chars from read4(temp) and put read chars into buf
        int i = 0;
        // read4 fills temp with 4 chars and return the index marking the end
        char[] temp = new char[4];
        
        while(i < n) {
            int next = read4(temp);
            int j = 0;
            while(i < n && j < next) {
                buf[i++] = temp[j++];
            }
            if(next < 4)    break;
        }
        return i;
    }
}