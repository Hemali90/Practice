package general;import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


//add sorted array into a tree such that the tree has minimum height.
//Solution:add the middle element first and then add the left half of the array.And then
//add right half.
//recurse.
//check whether tree is balanced using the isbalanced method.
//write method for listing the nodes heightwise

public class Tree {
TreeNode root;
Tree(){
	root=null;
}
/*
 * Adding node iterative
 */
/*private void addNode(TreeNode node,int value){
	TreeNode newnode=new TreeNode(val);
	if(root==null){
		root=newnode;
	}
	else{
		TreeNode temp=root;
		TreeNode parent=root;
		while(temp!=null){
			parent=temp;
			if(temp.nodeValue<=val){
				temp=temp.left;
			}
			else{
				temp=temp.right;
			}
		}
		if(parent.nodeValue<=val){
			parent.left=newnode;
		}
		else{
			parent.right=newnode;
		}
		temp=newnode;
	}
}*/
/*
 * Adding node recursive
 */
/*
 * Preorder and postorder construct a tree
 */

/*
 * Given preorder and inorder construct a tree
 */


public void printInorder (TreeNode node)
{
    if (node == null)
        return;
    printInorder(node.left);
    System.out.println(node.nodeValue);
    printInorder(node.right);
}

private TreeNode addNode(TreeNode node,int value){
	TreeNode nnode=new TreeNode(value);
	if(node==null){
		node=nnode;
		
	}
	else{
		if(value<=node.nodeValue){
			node.left=addNode(node.left,value);
			
		}
		else{
			node.right=addNode(node.right,value);
			
		}
	}
	return node;
}

public void add(int value){
	root=addNode(root,value);
	
}
/*
 * Delete node recursive
 */

public TreeNode deleteNode(TreeNode node,int value){
	if(node==null){return node;}
	if(node.nodeValue>value){
		node.left=deleteNode(node.left,value);
	}
	else if(node.nodeValue<value){
		node.right=deleteNode(node.right,value);
	}
	else{
		if(node.left==null && node.right==null){
			node=null;//return node;
		}
		else if(node.left==null){
			node=node.right;
			//return node;
		}
		else if(node.right==null){
			node=node.left;
			//return node;
		}
		else{
			TreeNode temp=findMin(node.right);
			node.nodeValue=temp.nodeValue;
			node.right=deleteNode(node.right,temp.nodeValue);
		}
	}
	return node;
}

public void delete(int value){
	deleteNode(root,value);
}
//Function required for finding min element both for delete and inorder successor
public TreeNode findMin(TreeNode t){
	TreeNode temp=t;
	while(temp.left!=null){
		temp=temp.left;
	}
	return temp;
}
/*
 * Inorder traversal
 */
private void printNode(TreeNode node){
if(node!=null)
{
	printNode(node.left);
	System.out.println("Node "+node.nodeValue);
	printNode(node.right);
}
}
public void print(){
	printNode(root);
}
/*
 * Adding array
 */
public void addArray(Integer arr[],int left,int right){
	if(left>=right){return;}
	int mid=(left+right)/2;
	add(arr[mid]);
	addArray(arr,left,mid);
	addArray(arr,mid+1,right);
}
/*
 * Balanced tree check
 */
public int maxDepth(TreeNode node){
	if(node==null){
		return 0;
	}
	else{
		return 1+Math.max(maxDepth(node.left),maxDepth( node.right));
	}
}
public int minDepth(TreeNode node){
	if(node==null){
		return 0;
	}
	else{
		return 1+Math.min(minDepth(node.left),minDepth( node.right));
	}
}


public boolean isBalancedNode(TreeNode node){
	return (maxDepth(node)-minDepth(node)<=1);
}
public boolean isBalanced(){
	return isBalancedNode(root);
}

//Function to find some data in the tree
private TreeNode Find(TreeNode root, int data) {
	if(root == null) return null;
	else if(root.nodeValue == data) return root;
	else if(root.nodeValue < data) return Find(root.right,data);
	else return Find(root.left,data);
}
/*
 * Inorder successor
 */
//Function to find Inorder Successor in a BST
private TreeNode Getsuccessor(TreeNode root,int data) {
	// Search the Node - O(h)
	TreeNode current = Find(root,data);
	if(current == null) return null;
	if(current.right != null) {  //Case 1: Node has right subtree
		return findMin(current.right); // O(h)
	}
	else {   //Case 2: No right subtree  - O(h)
		TreeNode successor = null;
		TreeNode ancestor = root;
		while(ancestor != current) {
			if(current.nodeValue < ancestor.nodeValue) {
				successor = ancestor; // so far this is the deepest node for which current node is in left
				ancestor = ancestor.left;
			}
			else
				ancestor = ancestor.right;
		}
		return successor;
	}
}

public void GetSuccessor(int data){
	Getsuccessor(root,data);
}
//level order traversal
public void linkedlistHeightNode(TreeNode node){
	ArrayList<LinkedList<TreeNode>> al=new ArrayList<LinkedList<TreeNode>>();
	int ind=0;
	LinkedList<TreeNode> ll=new LinkedList<TreeNode>();
	if(node==null){return;}
	ll.add(node);
	//int level=0;
	al.add(ind,ll);
	while(true){
		//LinkedList<TreeNode> n=al.get(ind);
		LinkedList<TreeNode> lnew=new LinkedList<TreeNode>();
		
	for(int i=0;i<al.get(ind).size();i++){
		TreeNode t=(TreeNode)al.get(ind).get(i);
		
		if(t!=null){
			if(t.left!=null)lnew.add(t.left);
			if(t.right!=null)lnew.add(t.right);
		}
	}
	ind++;
		if(lnew.size()==0){
		break;
		}
		else{
			al.add(ind,lnew);
		}
		
	}
	
    ind=0;
    System.out.println("Index value"+ind);
	while(ind<al.size()){
		System.out.println("Height: "+(ind));
		
		for(int i=0;i<al.get(ind).size();i++){

			TreeNode tl=al.get(ind).get(i);
			System.out.print("\t"+tl.nodeValue+"\t\n");
		}
		
		ind++;
	}
		
	}
	

public void linkedlistHeight(){
	linkedlistHeightNode(root);
}


/*
 * Check if two nodes has common ancestors
 */
public TreeNode commonAncestors(TreeNode root,TreeNode p,TreeNode q){
	if(covers(root.left,p) && covers(root.left,q)){
	return commonAncestors(root.left,p,q);	
	}
	if(covers(root.right,p) && covers(root.right,q)){
		return commonAncestors(root.right,p,q);
	}
	return root;
}
public boolean covers(TreeNode root,TreeNode test){
	if(root==null) return false;
	if(root==test) return true;
	return (covers(root.left,test) || covers(root.right,test));
}
/*
 * Tree T2 subtree of Tree T1
 */
boolean containsTree(TreeNode t1, TreeNode t2) 
{
if (t2 == null) // The empty tree is always a subtree
	return true;
else return subTree(t1, t2);
} 
boolean subTree(TreeNode r1, TreeNode r2) 
{ 
if (r1 == null)
return false; // big tree empty & subtree still not found. 
if (r1.nodeValue == r2.nodeValue) {
if (matchTree(r1,r2)) return true;}
return (subTree(r1.left, r2) || subTree(r1.right, r2)); 
}

boolean matchTree(TreeNode r1, TreeNode r2) { 
if (r2 == null && r1 == null)
return true;
// nothing left in the subtree
if (r1 == null || r2 == null)
return false; // big tree empty & subtree still not found )
if (r1.nodeValue != r2.nodeValue)
return false;
// data doesn’t match
return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
} 

/**
 * Inorder traversal without recursion
 * @param root
 */
public static void inorder(TreeNode root){
	Stack<TreeNode> s = new Stack<TreeNode>();
	List<Integer> inorderList = new ArrayList<>();
	if(root == null){
		return;
	} else {
		//s.push(root);
		TreeNode temp = root;
		while(temp != null || s.size() > 0){
			if(temp != null){	
				s.push(temp);
				temp = temp.left;
			} else {
				temp = s.pop();
				inorderList.add(temp.nodeValue);
				temp = temp.right;
			}
		}
	}
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Tree t=new Tree();
		int[] arr={2,3,4,5,6,7,8,10,11,12};
		t.addArray(arr, 0, arr.length);
		t.add(33);
	    t.add(22);
		t.add(1);
		t.print();
		System.out.println("After deletion");
		t.delete(5);
		t.delete(7);
		t.print();
		System.out.println("Tree is balanced?"+t.isBalanced());
		t.linkedlistHeight();
		//System.out.println("\n\n Level order");
		//t.lvorderTraverse();(*/
		int pre[] = {1, 2, 4, 5, 3, 6, 7};
	    int post[] = {4,5,2,6,7,3,1};
	    int size = pre.length;
	    Tree t=new Tree();
	    //TreeNode r = t.construct(pre, post,size);
	 
	   System.out.println("Inorder traversal of the constructed tree: \n");
	   // t.printInorder(r);
	 
	}

}
