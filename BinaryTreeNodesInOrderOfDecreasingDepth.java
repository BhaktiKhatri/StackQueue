package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinarySearchTrees.BinaryTreeNode;

public class BinaryTreeNodesInOrderOfDecreasingDepth {

	BinaryTreeNode root;
	
	public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> currentDepthNodes = new LinkedList<>();
		currentDepthNodes.add(root);
		
		List<List<Integer>> result = new ArrayList<>();
		
		while(!currentDepthNodes.isEmpty()) {
			Queue<BinaryTreeNode> nextDepthNodes = new LinkedList<>();
			List<Integer> thisLevel = new ArrayList<>();
			
			while(!currentDepthNodes.isEmpty()) {
				BinaryTreeNode curr = currentDepthNodes.poll();
				
				if(curr != null) {
					thisLevel.add(curr.data);
					
					nextDepthNodes.add(curr.left);
					nextDepthNodes.add(curr.right);
				}
			}
			
			if(!thisLevel.isEmpty()) {
				result.add(0, thisLevel);
			}
			
			currentDepthNodes = nextDepthNodes;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeNodesInOrderOfDecreasingDepth tree = new BinaryTreeNodesInOrderOfDecreasingDepth();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		System.out.println(binaryTreeDepthOrder(tree.root));
	}

}
