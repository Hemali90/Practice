package general;
public class CountSingleValuedSubtrees {
	static int count=0;
	/*
	 * @param count should be a static variable
	 */
	static boolean countSingleRec(TreeNode root, int count)
	{
	    // Return false to indicate NULL
	    if (root == null)
	       return true;
	 
	    // Recursively count in left and right subtrees also
	    boolean left = countSingleRec(root.left, count);
	    boolean right = countSingleRec(root.right, count);
	 
	    // If any of the subtrees is not singly, then this
	    // cannot be singly.
	    if (left == false || right == false)
	       return false;
	 
	    // If left subtree is singly and non-empty, but data
	    // doesn't match
	    if (root.left !=null && root.nodeValue != root.left.nodeValue)
	        return false;
	 
	    // Same for right subtree
	    if (root.right!=null && root.nodeValue != root.right.nodeValue)
	        return false;
	 
	    // If none of the above conditions is true, then
	    // tree rooted under root is single valued, increment
	    // count and return true.
	    count++;
	    return true;
	}
}
