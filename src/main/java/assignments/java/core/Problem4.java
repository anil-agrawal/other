package assignments.java.core;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode tree = TreeUtil.populateTree1();
		TreeUtil.printTree(tree);
		System.out.println("\n\n******************************** Postorder Traversal *******************************\n\n");
		System.out.println(solution.postorderTraversal(tree));
	}

	static class Solution {

		public List<Integer> postorderTraversal(TreeNode tree) {
			List<Integer> list = new ArrayList<Integer>();
			TreeNode root = tree;
			while(root!=null) {
				list.add(root.getVal());
				TreeNode left = root.getLeft();
				TreeNode right = root.getRight();
				if (left != null) {
					list.add(left.getVal());
				}
				if (right != null) {
					list.add(right.getVal());
				}
			}
			return list;
		}
	}

}