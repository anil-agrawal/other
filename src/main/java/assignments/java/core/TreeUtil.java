package assignments.java.core;

public class TreeUtil {

	public static void printTree(TreeNode root) {
		int depth = findDepth(root, 0);
		// System.out.println("Tree Depth : " + depth);
		// long maxNodes = (long) Math.pow(2, depth - 1);// maxNodes=2^(depth-1)
		printHorizontalTree(root, 0, depth);
	}

	public static void printHorizontalTree(TreeNode root, int depth, int maxdepth) {
		if (root == null || (root.getLeft() == null && root.getRight() == null)) {
			for (int counter = depth; counter < maxdepth; counter++) {
				System.out.println();
			}
			for (int counter = 0; counter < depth; counter++) {
				System.out.print("\t");
			}
			System.out.print(root == null ? "#" : root.getVal());
			for (int counter = depth; counter < maxdepth; counter++) {
				System.out.println();
			}
		} else {
			printHorizontalTree(root.getRight(), depth + 1, maxdepth);
			for (int counter = 0; counter < depth; counter++) {
				System.out.print("\t");
			}
			System.out.print(root.getVal());
			printHorizontalTree(root.getLeft(), depth + 1, maxdepth);
		}
	}

	public static void printVerticalTree(TreeNode root, int depth, long maxNodes) {
	}

	public static int findDepth(TreeNode root, int parentDepth) {
		int depth = parentDepth;
		if (root != null) {
			// System.out.println("Depth at node (" + root.getVal() + ") is : " + depth);
			int l = findDepth(root.getLeft(), parentDepth + 1);
			int r = findDepth(root.getRight(), parentDepth + 1);
			depth = l > r ? l : r;
		}
		return depth;
	}

	public static TreeNode cloneTree(TreeNode root) {
		TreeNode clone = new TreeNode(root.getVal());
		if (root.getLeft() != null) {
			clone.setLeft(cloneTree(root.getLeft()));
		}
		if (root.getRight() != null) {
			clone.setRight(cloneTree(root.getRight()));
		}
		return clone;
	}

	public static void main(String[] args) {
		printTree(new TreeNode(9));
	}

	public static TreeNode populateTree1() {
		// *-------------------------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------25---------------------------------------------------
		// *-------------------------------22----------------------------------------------
		// *----------------------20-------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------18---------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *------------------15-----------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------13---------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *----------------------10-------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------#----------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------9----------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------#----------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *----------------------8--------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------7----------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *------------------6------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------5----------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *----------------------3--------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *--------------------------1----------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		// *-------------------------------------------------------------------------------
		TreeNode root = new TreeNode(9);
		root.setLeft(new TreeNode(6));
		root.setRight(new TreeNode(15));

		root.getLeft().setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(8));
		root.getRight().setLeft(new TreeNode(10));
		root.getRight().setRight(new TreeNode(20));

		root.getLeft().getLeft().setLeft(new TreeNode(1));
		root.getLeft().getLeft().setRight(new TreeNode(5));
		root.getLeft().getRight().setLeft(new TreeNode(7));
		// root.getLeft().getRight().setRight(new TreeNode(0));
		// root.getRight().getLeft().setLeft(new TreeNode(0));
		root.getRight().getLeft().setRight(new TreeNode(13));
		root.getRight().getRight().setLeft(new TreeNode(18));
		root.getRight().getRight().setRight(new TreeNode(25));
		root.getRight().getRight().getRight().setLeft(new TreeNode(22));
		return root;
	}

}
