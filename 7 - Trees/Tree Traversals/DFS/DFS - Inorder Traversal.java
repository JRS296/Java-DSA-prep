//Link: https://www.youtube.com/playlist?list=PLTw5Q54Ws9iYTVxr7-MK2nzQEaDr1-IfF

// Iterative - using stack i.e. DFS
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                OP.add(cur.val);
                cur = cur.right;
            }
        }

        return OP;
    }
}

// Using Recursion
class Solution {
    public List<Integer> inOrder(TreeNode root) {
            List<Integer> pre = new LinkedList<Integer>();
            preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        preHelper(root.left, pre);
        pre.add(root.val);
        preHelper(root.right, pre);
    }
}