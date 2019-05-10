package general;
public class CheckBST {

	/**
	 * @param args
	 */
	
	 //incorrect
	public static boolean check(TreeNode root){
		if(root==null){
			return true;
		}
		else{
			if(root.left!=null || root.right!=null){
				if(root.left!=null){
					if(root.left.nodeValue>root.nodeValue){
						return false;
					}
				}
				if(root.right!=null){
					if(root.right.nodeValue<root.nodeValue);
					return false;
				}
			}
		}
		if(!check(root.left))
			return false;
		return check(root.right);
	}
	
	static int maxValue=Integer.MIN_VALUE;
	boolean isBST(TreeNode node) 
	{ 
	  return(isBSTUtil(node,Integer.MIN_VALUE, Integer.MAX_VALUE)); 
	} 
	 
	//correct and efficient
	/* Returns true if the given tree is a BST and its 
	   values are >= min and <= max. */
	boolean isBSTUtil(TreeNode node, int min, int max) 
	{ 
	 
	  /* an empty tree is BST */
	  if (node==null) 
	     return true;
	       
	  /* false if this node violates the min/max constraint */ 
	  if (node.nodeValue < min || node.nodeValue > max) 
	     return false; 
	 
	  /* otherwise check the subtrees recursively, 
	   tightening the min or max constraint */
	  return
	    isBSTUtil(node.left, min, node.nodeValue) &&  // Allow only distinct values
	    isBSTUtil(node.right, node.nodeValue, max);  // Allow only distinct values
	} 
	//correct and efficient
	public static boolean inorder(TreeNode root){
		if(root==null){
			return true;
		}
		else{
			if(!inorder(root.left)){
				return false;
			}
			if(root.nodeValue < maxValue)
			{//System.out.println(root.nodeValue);
			//maxValue=root.nodeValue;
			return false;
			}
			//else return false;
			maxValue=root.nodeValue;
			return inorder(root.right);
		}
		//return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(10);
		root.left=new TreeNode(5);
		root.right=new TreeNode(12);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(6);
		root.right.left=new TreeNode(11);
		root.right.right=new TreeNode(20);
		
		System.out.println(inorder(root));
		System.out.println(check(root));
	}

}
