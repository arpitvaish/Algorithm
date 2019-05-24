
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {


        return buildT(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildT(int[] inOrder, int[] postOrder, int m, int n, int k, int l) {

        if (m > n) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[l]);
        int indexOfRoot = findIndex(inOrder, postOrder[l]);
        if (m == n) return root;
        else {
            root.left = buildT(inOrder, postOrder, m, indexOfRoot - 1, k, k + (indexOfRoot - m) - 1);
            root.right = buildT(inOrder, postOrder, indexOfRoot + 1, n, k + (indexOfRoot - m), l - 1);
        }


        return root;
    }

    public static int findIndex(int[] inOrder, int val) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == val) return i;
        }
        return -1;
    }

    public static void main(String args[]) throws Exception {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inOrder, postOrder);
        System.out.println(root);
    }
}
