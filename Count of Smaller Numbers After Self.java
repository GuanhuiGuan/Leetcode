class Solution {
    
    class TreeNode {
        // left-children count(smaller), dpc(same as val)
        // sum up the node turning right when insert(those smaller than)
        int val, lc, dpc;
        TreeNode left = null, right = null;
        
        public TreeNode(int v){
            val = v;
            lc = 0;
            dpc = 1;
        }
    }
    
    List<Integer> re;
    
    public List<Integer> countSmaller(int[] nums) {
        // Augmented BST
        re = new ArrayList<>();
        if(nums.length == 0)    return re;
        
        // build backwards
        TreeNode root = new TreeNode(nums[nums.length-1]);
        re.add(0);
        for(int i = nums.length-2; i >= 0; i--){
            buildTree(root, nums[i], 0);
        }
        return re;
        
    }
    
    public void buildTree(TreeNode node, int val, int cnt){
        // same: cnt + plus leftchildren
        if(node.val == val){
            cnt += node.lc;
            node.dpc++;
            re.add(0, cnt);
        }
        // right: update cnt with lc and dpc
        else if(node.val < val){
            cnt += node.lc + node.dpc;
            if(node.right != null){
                buildTree(node.right, val, cnt);
            }
            else{
                re.add(0, cnt);
                TreeNode n = new TreeNode(val);
                node.right = n;
            }
        }
        // left: update lc
        else{
            node.lc++;
            if(node.left != null){
                buildTree(node.left, val, cnt);
            }
            else{
                re.add(0, cnt);
                TreeNode n = new TreeNode(val);
                node.left = n;
            }
        }
    }
}