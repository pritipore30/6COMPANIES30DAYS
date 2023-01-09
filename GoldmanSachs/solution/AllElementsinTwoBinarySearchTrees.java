package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode root;

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

class BSTIterator {
	public BSTIterator(TreeNode root) {
		pushLeftsUntilNull(root);
	}

	public int peek() {
		return stack.peek().val;
	}

	public void next() {
		pushLeftsUntilNull(stack.pop().right);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private Deque<TreeNode> stack = new ArrayDeque<>();

	private void pushLeftsUntilNull(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}

public class AllElementsinTwoBinarySearchTrees {
	
	
	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		
		List<Integer> ans = new ArrayList<>();
		BSTIterator bstIterator1 = new BSTIterator(root1);
		BSTIterator bstIterator2 = new BSTIterator(root2);
		
		while (bstIterator1.hasNext() && bstIterator2.hasNext()) {
			if (bstIterator1.peek() < bstIterator2.peek()) {
				ans.add(bstIterator1.peek());
				bstIterator1.next();
			} else {
				ans.add(bstIterator2.peek());
				bstIterator2.next();
			}
		}
		
		while (bstIterator1.hasNext()) {
			ans.add(bstIterator1.peek());
			bstIterator1.next();
		}
		
		while (bstIterator2.hasNext()) {
			ans.add(bstIterator2.peek());
			bstIterator2.next();
		}
		return ans;
	}
	
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode();
        tree1.root = new TreeNode(2);
        tree1.root.left = new TreeNode(1);
        tree1.root.right = new TreeNode(4);
      
        TreeNode tree2 = new TreeNode();
        tree2.root = new TreeNode(1);   
        tree2.root.left = new TreeNode(0);
        tree2.root.right = new TreeNode(3);
        
        List<Integer> tree = getAllElements(tree1.root, tree2.root);
        for(int i=0;i<tree.size();i++){
            System.out.print(tree.get(i) + " ");
        } 
        
        
	}
}
