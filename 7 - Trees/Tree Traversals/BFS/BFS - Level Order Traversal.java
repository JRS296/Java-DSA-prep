//Using Iterative + Queue i.e. BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> op = new LinkedList<List<Integer>>();

        if (root == null)
            return op;

        queue.offer(root); // queue.add(root) - offer returns false if unsuccessful
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
                // Same as queue.remove() - poll() will not return error if q is empty.
            }
            op.add(subList);
        }
        return op;
    }
}

// Using Recursion
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(ans, root, 0);
        return ans;
    }

    public void compute(List<List<Integer>> ans, TreeNode curr, int level) {
        if (curr == null)
            return;

        if (ans.size() == level)
            ans.add(new ArrayList<Integer>());

        ans.get(level).add(curr.val);
        compute(ans, curr.left, level + 1);
        compute(ans, curr.right, level + 1);
    }
}