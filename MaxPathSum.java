package maxPathSum;
import java.util.*;

public class Solution {
	/*
	 * Get max path sum of a binary tree
	 * 
	 */
	
	List<Integer> res = new ArrayList<>();
	int max = Integer.MIN_VALUE;
	// max path sum, return path
	public List<Integer> maxPathSum(TreeNode root) {
		findSum(root);
		return res;
	}
	
	public List<Integer> findSum(TreeNode node) {
		if(node == null)	return null;
		// get max sum crossing this node
		List<Integer> left = findSum(node.left);
		List<Integer> right = findSum(node.right);
		int ls = sumList(left);
		int rs = sumList(right);
		int val = ls + rs + node.val;
		// compare with max
		if(max < val) {
			List<Integer> newList = new ArrayList<>();
			if(left != null)	newList.addAll(left);
			if(right != null)	newList.add(node.val);
			addReverse(newList, right);
			max = val;
			res = newList;
		}
		// return max of one path
		if(ls > rs) {
			if(left == null)	left = new ArrayList<>();
			left.add(0, node.val);
			return new ArrayList<>(left);
		}
		else {
			if(right == null)	right = new ArrayList<>();
			right.add(0, node.val);
			return new ArrayList<>(right);
		}
	}
	
	public int sumList(List<Integer> list) {
		// return the max positive sum
		if(list == null)	return 0;
		int sum = 0;
		for(int item: list) {
			sum += item;
		}
		return Math.max(0, sum);
	}
	
	public void addReverse(List<Integer> all, List<Integer> sub) {
		int size = all.size();
		if(sub == null)	return;
		for(int item: sub) {
			all.add(size, item);
		}
	}
	
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
