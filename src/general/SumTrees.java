package general;
public class SumTrees {

	/*
	 * Replacing node with sum of its children nodes.
	 */
	public int replace_sum(TreeNode root){
	    if (root==null)
	            return 0;
	     int left_sum =  replace_sum(root.left);
	     int right_sum = replace_sum(root.right);
	     
	     if(left_sum + right_sum != 0){
	             root.nodeValue = left_sum + right_sum;
	    }
	    return root.nodeValue;
	}

	/* A utility function to get the sum of values in tree with root
	as root */
	int sum(TreeNode root)
	{
	 if(root == null)
	   return 0;
	 return sum(root.left) + root.nodeValue + sum(root.right);
	}

	/* returns 1 if sum property holds for the given
	  node and both of its children */
	boolean isSumTree(TreeNode node)
	{
	  int ls, rs;

	  /* If node is NULL or it's a leaf node then
	     return true */
	  if(node == null ||
	          (node.left == null && node.right == null))
	      return true;

	 /* Get sum of nodes in left and right subtrees */
	 ls = sum(node.left);
	 rs = sum(node.right);

	 /* if the node and both of its children satisfy the
	     property return 1 else 0*/
	  if((node.nodeValue == ls + rs)&&(isSumTree(node.left)) && (isSumTree(node.right)))
	      return true;

	 return false;
	}
	/*
	 * Replace a node with sum of nodes which are greater than the node.
	 */

	public void replace_with_sum_greater_nodes(TreeNode node, int sum){
	    int temp;
	    if(node == null) return  ;

	    replace_with_sum_greater_nodes(node.right, sum);
	    /* Book keeping */
	    temp = node.nodeValue;
	    if(sum !=0){
	            node.nodeValue = sum;
	    }
	    sum = sum  + temp;
	    replace_with_sum_greater_nodes(node.left, sum );
	}
	/*
	 * Is child sum property
	 */
	public boolean isChildsum(TreeNode node){
		if(node==null||node.left==null||node.right==null){
			return true;
		}
		int left=0;
		int right=0;
		if(node.left!=null){
			left=node.left.nodeValue;
		}
		if(node.right!=null){
			right=node.right.nodeValue;
		}
		if(node.nodeValue==(left+right)&& isChildsum(node.left) && isChildsum(node.right))
		return true;
		else
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
