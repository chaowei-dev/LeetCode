/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsS(root, res);
        return String.join(",", res);
    }

    private void dfsS(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        dfsS(node.left, res);
        dfsS(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split
        String[] vals = data.split(",");

        // idx
        int[] i = {0};

        // return
        return dfsD(vals, i);
    }

    private TreeNode dfsD(String[] vals, int[] i) {
        if (vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        root.left = dfsD(vals, i);
        root.right = dfsD(vals, i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));