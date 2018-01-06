import java.util.*;
import java.io.*;

public class MainClass {
	// MAIN, static methods since they'll be called -
	//	even there's no object constructed
    public static void main(String[] args) throws IOException
    {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String line;
    	while((line = in.readLine()) != null) {
    		int[] nums = string2Array(line);
    		line = in.readLine();
    		int target = Integer.parseInt(line);
    		int[] outData = new Solution().twoSum(nums, target);
        	String output = array2String(outData);
            System.out.println(output);
    	}
    }
    
    // ___________data transform helpers____________
    public static int[] string2Array(String line) {
    	//    	removing spaces and square brackets
    	line = line.trim();
    	line = line.substring(1, line.length()-1);
    	if(line.length() == 0)	return new int[0];
    	
    	//    	split and trim each part
    	String[] strs = line.split(",");
    	int[] re = new int[strs.length];
    	for(int i = 0; i < strs.length; i++) {
    		re[i] = Integer.parseInt(strs[i].trim());
    	}
    	return re;
    }
    
    public static String array2String(int[] data) {
    	String re = "[";
    	for(int n: data) {
    		re += Integer.toString(n) + ", ";
    	}
    	//    	delete the last ", "
    	re = re.substring(0, re.length()-2) + "]";
    	return re;
    }
    
}
