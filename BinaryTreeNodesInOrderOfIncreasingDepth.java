package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinarySearchTrees.BinaryTreeNode;

public class BinaryTreeNodesInOrderOfIncreasingDepth {

	BinaryTreeNode root;
	
	public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> currentDepthNodes = new LinkedList<>();
		currentDepthNodes.add(root);
		
		List<List<Integer>> result = new ArrayList<>();
	
		System.out.println("root: "+root.data+" currentDepthNodes: "+currentDepthNodes);
		
		while(!currentDepthNodes.isEmpty()) {
			
			Queue<BinaryTreeNode> nextDepthNodes = new LinkedList<>();
			List<Integer> thisLevel = new ArrayList<>();
			System.out.println("currentDepthNodes: "+currentDepthNodes+" nextDepthNodes: "+nextDepthNodes+" thisLevel: "+thisLevel);
			
			while(!currentDepthNodes.isEmpty()) {
				BinaryTreeNode curr = currentDepthNodes.poll();
				System.out.println("currentDepthNodes: "+currentDepthNodes);
				
				if(curr != null) {
					thisLevel.add(curr.data);
					System.out.println("curr: "+curr.data+" thisLevel: "+thisLevel);
					
					//Defer the null checks to the null test above
					nextDepthNodes.add(curr.left);
					nextDepthNodes.add(curr.right);
					
					System.out.println("nextDepthNodes: "+nextDepthNodes);
				}
			}
			
			System.out.println("thisLevel: "+thisLevel+" result: "+result);
			if(!thisLevel.isEmpty()) {
				result.add(thisLevel);
			}
			
			currentDepthNodes = nextDepthNodes;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeNodesInOrderOfIncreasingDepth tree = new BinaryTreeNodesInOrderOfIncreasingDepth();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		System.out.println(binaryTreeDepthOrder(tree.root));
		
//		System.out.println("      "+root.data);
//		System.out.println("     /"+"  \\");
//		System.out.println("    "+root.left.data+"    "+root.right.data);
//		System.out.println("   /"+" \\   "+" \\");
//		System.out.println("  "+root.left.left.data+"  "+root.left.right.data+"     "+root.right.right.data);
		
	}

}
