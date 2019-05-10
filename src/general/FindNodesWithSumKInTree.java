package general;import java.util.ArrayList;


public class FindNodesWithSumKInTree {

	/*
	 * Find nodes having sum
	 */
	public void findSum(TreeNode head,int sum,ArrayList<Integer> buffer,int level){
	if (head == null) return;
	int tmp = sum;
	buffer.add(head.nodeValue);
	for (int i = level;i >- 1; i--){
	tmp -= buffer.get(i);

	if (tmp == 0) print(buffer, i, level);
	}
	ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
	ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone(); 
	findSum(head.left,sum,c1,level+1);
	findSum(head.right,sum,c2,level+1);
	}
	
	void print(ArrayList<Integer> buffer, int i2, int level) { 
		for (int i = i2; i <= level; i++) {
	System.out.print(buffer.get(i ) + " "); 
	}
	System.out.println(); }

	/*
	 * last K elements of a tree
	 * 1)same like inorder traversal except ,starting from the right node rather than left node
	 * 2)keep a count for k,decrement k 
	 */
	public void print_k_nodes(TreeNode node, int K){
		 
	    if(node == null || (K) == 0) return;

	    print_k_nodes(node.right, K);
	    System.out.println();
	    System.out.println(node.nodeValue);
	    K--;
	    print_k_nodes(node.left, K);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
