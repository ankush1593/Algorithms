import java.util.LinkedList;
import java.util.Queue;

/*q3- 
Level Order
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.*/

class BinaryTree{
	int data;
	BinaryTree leftNode;
	BinaryTree rightNode;
	public BinaryTree(int data){
		this.data = data;
		leftNode = null;
		rightNode = null;
	}
}

class LevelOrderTraversal {

	public static void printLevelOrder(BinaryTree root){
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);
		int nodeCount = queue.size();
		BinaryTree tempNode;
		while(nodeCount > 0){
			while(nodeCount > 0){
				tempNode = queue.poll();
				System.out.print(tempNode.data);
				System.out.print(" ");
				if(!(tempNode.leftNode == null)){
					queue.add(tempNode.leftNode);
				}
				if(!(tempNode.rightNode == null)){
					queue.add(tempNode.rightNode);
				}
				nodeCount--;
			}
			nodeCount = queue.size();
			System.out.println();
		}
	}

	public static void main(String args[]){
		BinaryTree root = new BinaryTree(3);
		root.leftNode = new BinaryTree(9);
		root.rightNode = new BinaryTree(20);
		root.rightNode.leftNode = new BinaryTree(15);
		root.rightNode.rightNode = new BinaryTree(7);
		printLevelOrder(root);
	}


}