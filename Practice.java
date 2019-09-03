package Stack_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import BinarySearchTrees.BinaryTreeNode;

class Practice {
	
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
				result.add(thisLevel);
			}
			
			currentDepthNodes = nextDepthNodes;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
