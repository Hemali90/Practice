package general;/* C++ program to find Inorder successor in a BST */
/*#include<iostream>
using namespace std;
struct Node {
	int data;
	struct Node *left;
	struct Node *right;
};
 
//Function to find some data in the tree
TreeNode Find(TreeNode root, int data) {
	if(root == null) return null;
	else if(root.data == data) return root;
	else if(root.data < data) return Find(root.right,data);
	else return Find(root.left,data);
}
 
//Function to find Node with minimum value in a BST
public TreeNode FindMin(TreeNode root) {
	if(root == null) return null;
	while(root.left != null)
		root = root.left;
	return root;
}
 
//Function to find Inorder Successor in a BST
TreeNode Getsuccessor(TreeNode root,int data) {
	// Search the Node - O(h)
	TreeNode current = Find(root,data);
	if(current == null) return null;
	if(current.right != null) {  //Case 1: Node has right subtree
		return FindMin(current.right); // O(h)
	}
	else {   //Case 2: No right subtree  - O(h)
		TreeNode successor = null;
		TreeNode ancestor = root;
		while(ancestor != current) {
			if(current.data < ancestor.data) {
				successor = ancestor; // so far this is the deepest node for which current node is in left
				ancestor = ancestor.left;
			}
			else
				ancestor = ancestor.right;
		}
		return successor;
	}
}
 
//Function to visit nodes in Inorder
void Inorder(Node *root) {
	if(root == NULL) return;
 
	Inorder(root->left);       //Visit left subtree
	printf("%d ",root->data);  //Print data
	Inorder(root->right);      // Visit right subtree
}
 
// Function to Insert Node in a Binary Search Tree
Node* Insert(Node *root,char data) {
	if(root == NULL) {
		root = new Node();
		root->data = data;
		root->left = root->right = NULL;
	}
	else if(data <= root->data)
		root->left = Insert(root->left,data);
	else 
		root->right = Insert(root->right,data);
	return root;
}
 
int main() {
	/*Code To Test the logic
	  Creating an example tree
	            5      
			   / \
			  3   10
			 / \   \
			1   4   11
    */
	/*Node* root = NULL;
	root = Insert(root,5); root = Insert(root,10);
	root = Insert(root,3); root = Insert(root,4); 
	root = Insert(root,1); root = Insert(root,11);
 
	//Print Nodes in Inorder
	cout<<"Inorder Traversal: ";
	Inorder(root);
	cout<<"\n";
 
	// Find Inorder successor of some node. 
	struct Node* successor = Getsuccessor(root,1);
	if(successor == NULL) cout<<"No successor Found\n";
	else
    cout<<"Successor is "<<successor->data<<"\n";
}
public class InorderSuccessor {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}*/
public class InorderSuccessor{
	//more time complex method=O(n)
	static void inorder(TreeNode node,int value,int flag){
		if(node==null){
			return;
		}
		if(flag==1){
			System.out.println(node.nodeValue);
			return;
		}
		inorder(node.left,value,flag);
		if(node.nodeValue==value){
			flag=1;
		}
		inorder(node.right,value,flag);
	}
	
	public TreeNode findMin(TreeNode right){
		while(right.left!=null){
			right=right.left;
		}
		return right;
	}
	public TreeNode findNode(TreeNode node,int value){
		TreeNode current=node;
		while(current!=null){
			if(value==current.nodeValue){
				return current;
			}
			else if(value<current.nodeValue){
				current=current.left;
			}
			else{
				current=current.right;
			}
			
		}
		return null;
	}
	//time complexity O(h)
	public TreeNode inordersucces(TreeNode root,int value){
		TreeNode nnode=findNode(root,value);
		if(nnode==null){
			return null;
		}
		else if(nnode.right!=null){
			return findMin(nnode.right);
		}
		else{
			TreeNode successor=null;
			TreeNode current= root;
			while(current!=nnode){
				if(current==null){
					return null;
				}
				else if(nnode.nodeValue< current.nodeValue){
					successor=current;
					current=current.left;
				}
				else{
					current=current.right;
				}	
			}
			return successor;
		}
	}
	public static void main(String args[]){
		
	}
}