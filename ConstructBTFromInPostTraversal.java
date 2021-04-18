import java.util.HashMap;

/*
q2 -
Binary Tree From Inorder And Postorder
Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 */

 class BinaryTree{
	 int data;
	 BinaryTree leftNode;
	 BinaryTree rightNode;
	 public BinaryTree(int data){
		 this.data = data;
		 leftNode = rightNode = null;
	 }
 }

 class ConstructBTFromInPostTraversal{

	static HashMap<Integer, Integer> dataIndexMap = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> dataPostIndexMap = new HashMap<Integer, Integer>();


	static int currentIndex;

	public static void main(String args[]){
		//int[] inOrder = new int[]{6, 1, 3, 2};
		//int[] postOrder = new int[]{6, 3, 2, 1};
		int[] inOrder = new int[]{9,5,1,7,2,12,8,4,3,1};
		int[] postOrder = new int[]{9,1,2,12,7,5,3,11,4,8};
		currentIndex = inOrder.length-1;
		for (int i=0;i<inOrder.length; i++){
			dataIndexMap.put(inOrder[i],i);
		}
		BinaryTree root = constructBT(inOrder, postOrder, 0, inOrder.length - 1);
		System.out.print(root.data);
	}

	public static BinaryTree constructBT(int[] inOrder, int[] postOrder, int startIndex, int endIndex){
		if (startIndex > endIndex){
			return null;
		}
		// get root Node in current inorder tree

		int currentNodeData = postOrder[currentIndex--];
		BinaryTree root = new BinaryTree(currentNodeData);
		int rootNodeInIndex = dataIndexMap.get(currentNodeData);
		if (startIndex == endIndex){
			return root;
		}
		root.rightNode = constructBT(inOrder, postOrder, rootNodeInIndex+1, endIndex);
		root.leftNode = constructBT(inOrder, postOrder, startIndex, rootNodeInIndex-1);
		return root;
	}

 }