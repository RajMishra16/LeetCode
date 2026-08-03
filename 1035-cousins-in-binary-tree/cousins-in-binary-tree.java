import java.util.*;

class Solution {

    Map<Integer, Integer> depth = new HashMap<>();
    Map<Integer, TreeNode> parent = new HashMap<>();

    private void dfs(TreeNode node, TreeNode par) {

        if (node != null) {

            int l = (par == null) ? 0 : depth.get(par.val) + 1;

            depth.put(node.val, l);
            parent.put(node.val, par);

            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, null);

        if (depth.get(x).equals(depth.get(y)) &&
            parent.get(x) != parent.get(y))
            return true;

        return false;
    }
}