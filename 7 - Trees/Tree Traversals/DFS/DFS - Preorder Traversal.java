//Link: https://www.youtube.com/playlist?list=PLTw5Q54Ws9iYTVxr7-MK2nzQEaDr1-IfF

// Iterative - using stack i.e. DFS
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                OP.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return OP;
    }
}

//Using Recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }
}