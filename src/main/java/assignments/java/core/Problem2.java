package assignments.java.core;

public class Problem2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode tree = TreeUtil.populateTree1();
		// TreeUtil.printTree(tree);
		System.out.println("\n\n\n******************  Inverted Tree  **************************\n\n\n");
		TreeUtil.printTree(solution.invertTree(tree));
		System.out.println("\n\n\n******************  Original Tree  **************************\n\n\n");
		TreeUtil.printTree(tree);
	}

	static class Solution {

		public TreeNode invertTree(TreeNode root) {
			TreeNode clone = TreeUtil.cloneTree(root);
			updateTree(clone);
			return clone;
		}

		private void updateTree(TreeNode root) {
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			root.setLeft(right);
			root.setRight(left);
			if (left != null) {
				updateTree(left);
			}
			if (right != null) {
				updateTree(right);
			}
		}
	}

}
