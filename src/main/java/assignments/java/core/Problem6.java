package assignments.java.core;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode tree = TreeUtil.populateTree1();
		TreeUtil.printTree(tree);
		System.out.println("\n\n******************************** Postorder Traversal *******************************\n\n");
		System.out.println(solution.postorderTraversal(tree));
	}

	static class Solution {

		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			traversTree(root, list);
			return list;
		}

		private void traversTree(TreeNode root, List<Integer> list) {
			if (root != null) {
				TreeNode left = root.getLeft();
				TreeNode right = root.getRight();
				if (left != null) {
					traversTree(left, list);
				}
				if (right != null) {
					traversTree(right, list);
				}
				list.add(root.getVal());
			}
		}
	}

}