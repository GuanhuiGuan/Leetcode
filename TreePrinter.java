package printTreePreorder;
import java.util.*;

public class TreePrinter {
	// preorder print
	public String printTreePo(TreeNode root) {
		String res = printPo(root);
		return res;
	}
	
	public String printPo(TreeNode node) {
		if(node == null)	return "*";
		String s = "" + node.val;
		// is leaf
		if(node.left == null && node.right == null) {
			return s;
		}
		else {
			s += " " + printPo(node.left);
			s += " " + printPo(node.right);
			return "(" + s + ")";
		}
	}
	
	
	
	List<List<String>> lvls = new ArrayList<>();
	// inorder print
	public String printTreeIo(TreeNode root) {
		search(root, 1);
		String res = "(";
		for(List<String> lvl: lvls) {
			res += "(";
			for(String s: lvl) {
				res += s + " ";
			}
			res = res.substring(0, res.length()-1);
			res += "), ";
		}
		res = res.substring(0, res.length()-2);
		res += ")";
		return res;
	}
	
	public void search(TreeNode node, int lvl) {
		// lvl starts from 1
		if(node == null) {
			if(lvls.size() < lvl)	lvls.add(new ArrayList<>());
			lvls.get(lvl-1).add("*");
			return;
		}
		if(lvls.size() < lvl)	lvls.add(new ArrayList<>());
		lvls.get(lvl-1).add(String.valueOf(node.val));
		if(node.left == null && node.right == null)	return;
		// if one side is null or none is null
		search(node.left, lvl+1);
		search(node.right, lvl+1);
	}
	
	/*
	 * Build Tree Helpers
	 */
	public TreeNode buildTree(String[] list) {
		// build a tree from preorder walk
		Queue<String> q = new LinkedList<>();
		for(String i: list)	q.offer(i);
		return build(q);
	}
	
	public TreeNode build(Queue<String> queue) {
		if(queue.isEmpty())	return null;
		String cur = queue.poll();
		if(cur.equals("#"))	return null;
		TreeNode node = new TreeNode(Integer.parseInt(cur));
		node.left = build(queue);
		node.right = build(queue);
		return node;
	}
}
