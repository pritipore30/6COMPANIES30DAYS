package solution;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class CountNodesEqualtoAverageofSubtree {
	public int averageOfSubtree(TreeNode root) {
		dfs(root);
		return ans;
	}

	private int ans = 0;

	private Pair<Integer, Integer> dfs(TreeNode root) {
		if (root == null) {
			return new Pair<>(0, 0);
		}
		Pair<Integer, Integer> left = dfs(root.left);
		Pair<Integer, Integer> right = dfs(root.right);
		int sum = root.val + left.getKey() + right.getKey();
		int count = 1 + left.getValue() + right.getValue();
		if (sum / count == root.val) {
			++ans;
		}
		return new Pair<>(sum, count);
	}
	

}
