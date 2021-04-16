import java.util.Stack;

/*Inorder Traversal
Problem Description

Given a binary tree, return the inorder traversal of its nodes values.

NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */

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

class InorderTraversal{

	 public static void main(String args[]){
		System.out.println("Test Java Run");
		BinaryTree root = new BinaryTree(1);
		root.leftNode = new BinaryTree(6);
		root.rightNode = new BinaryTree(2);
		root.rightNode.leftNode = new BinaryTree(3);
		traverseInorder(root);
 	}

	 public static void traverseInorder(BinaryTree root){
		 if (root == null){
			 return;
		 }
		 Stack<BinaryTree> stack = new Stack<BinaryTree>();
		 BinaryTree current = root;
		 while(current != null || stack.size() >0 ){
			while(current != null){
				stack.push(current);
				current = current.leftNode;
			}
			current = stack.pop();
			System.out.print(current.data);
			current = current.rightNode;
		 }
	 }

}