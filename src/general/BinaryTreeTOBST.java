package general;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 1) Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
2) Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm. In the following implementation, Quick Sort is used which takes (n^2) time. This can be done in O(nLogn) time using Heap Sort or Merge Sort.
3) Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.
 */
public class BinaryTreeTOBST {
	static ArrayList<Integer> list=new ArrayList<Integer>();
public static void inorder(TreeNode root,ArrayList<Integer> list){
	if(root==null) return;
	inorder(root.left,list);
	list.add(root.nodeValue);
	inorder(root.right,list);
}
public static void addArr(Tree t,ArrayList<Integer> l,int start,int end){
	if(start>end){
		return;
	}
	int mid=start+end/2;
	t.add(l.get(mid));
	addArr(t,l,start,mid-1);
	addArr(t,l,mid+1,end);
	
	
}
public static void print(TreeNode r){
	if(r==null) return;
	print(r.left);
	System.out.println(r.nodeValue);
	print(r.right);
}
public static void main(String[] args){
	TreeNode root= new TreeNode(34);
	root.left=new TreeNode(3);
	root.right=new TreeNode(10);
	root.left.left=new TreeNode(20);
	root.left.right=new TreeNode(21);
	root.right.left=new TreeNode(1);
	inorder(root,list);
	for(Integer i:list){
		System.out.println(i);
	}
	Collections.sort(list);
	System.out.println("Sorted");
	for(Integer i:list){
		System.out.println(i);
	}
	Tree t=new Tree();
	Integer it[]=list.toArray(new Integer[list.size()]);
	t.addArray(it, 0,it.length);
	TreeNode r=t.root;
	System.out.println("BST");
	print(r);
	
	
}
}
