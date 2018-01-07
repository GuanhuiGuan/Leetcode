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
//    		int[] nums = string2Array(line);
//    		line = in.readLine();
//    		int target = Integer.parseInt(line);
//    		int[] outData = new Solution().twoSum(nums, target);
//        	String output = array2String(outData);
//            System.out.println(output);
    		
    		TreeNode p = string2Tree(line);
    		line = in.readLine();
    		TreeNode q = string2Tree(line);
    		boolean out = new Solution().isSameTree(p, q);
//    		String output = Integer.toString(out);
    		System.out.println(out);
    		
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
    
    public static String[] string2SArray(String line) {
    	line = line.trim();
    	line = line.substring(1, line.length()-1);
    	String[] parts = line.split(",");
    	
    	for(int i = 0; i < parts.length; i++) {
    		parts[i] = parts[i].trim();
    		parts[i] = parts[i].substring(1, parts[i].length()-1);
    	}
    	return parts;
    }
    
    public static TreeNode string2Tree(String line) {
    	line = line.trim();
    	line = line.substring(1, line.length()-1);
    	String[] parts = line.split(",");
    	TreeNode root = sArray2Tree(parts, 0);
    	return root;
    }
    
    public static TreeNode sArray2Tree(String[] parts, int ind) {
    	if(ind >= parts.length || parts[ind].equals("null"))	return null;
    	TreeNode node = new TreeNode(Integer.parseInt(parts[ind]));
    	node.left = sArray2Tree(parts, 2*ind+1);
    	node.right = sArray2Tree(parts, 2*ind+2);
    	return node;
    }
    
}
