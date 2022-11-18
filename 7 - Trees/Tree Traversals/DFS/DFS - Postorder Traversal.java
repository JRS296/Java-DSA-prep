//Link: https://www.youtube.com/playlist?list=PLTw5Q54Ws9iYTVxr7-MK2nzQEaDr1-IfF

// Iterative - using stack i.e. DFS
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        if (root == null)
            return OP;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.peek().right == null) {
                    TreeNode temp = stack.pop();
                    OP.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        OP.add(temp.val);
                    }
                } else {
                    cur = stack.peek().right;
                }
            }
        }
        return OP;
    }
}

// Using Recursion
class Solution {
    public List<Integer> PostOrder(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        preHelper(root.left, pre);
        preHelper(root.right, pre);
        pre.add(root.val);
    }
}