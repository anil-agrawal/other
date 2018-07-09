package assignments.java.core;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode tree = TreeUtil.populateTree1();
		TreeUtil.printTree(tree);
		int k = 9;
		System.out.println("\n\n\n******************  " + k + "'th smallest value  **************************\n\n\n");
		System.out.println(solution.kthSmallest(tree, k));
	}

	static class Solution {
		public int kthSmallest(TreeNode root, int k) {
			List<Integer> data = new ArrayList<Integer>();
			findSmallestNode(root, data, k);
			return data.get(k - 1);
		}

		private void findSmallestNode(TreeNode root, List<Integer> data, int size) {
			if (root != null) {
				findSmallestNode(root.getLeft(), data, size);
				data.add(root.getVal());
				if (data.size() >= size) {
					return;
				} else {
					findSmallestNode(root.getRight(), data, size);
				}
			}
		}
	}
}