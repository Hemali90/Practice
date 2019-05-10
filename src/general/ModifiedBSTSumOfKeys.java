package general;
public class ModifiedBSTSumOfKeys {

	/**
	 * @param args
	 */
	void addGreaterUtil(TreeNode root, int sum_ptr)
	{
	    // Base Case
	    if (root == null)
	        return;
	 
	    // Recur for right subtree first so that sum of all greater
	    // nodes is stored at sum_ptr
	    addGreaterUtil(root.right, sum_ptr);
	 
	    // Update the value at sum_ptr
	    sum_ptr = sum_ptr + root.nodeValue;
	 
	    // Update key of this node
	    root.nodeValue = sum_ptr;
	 
	    // Recur for left subtree so that the updated sum is added
	    // to smaller nodes
	    addGreaterUtil(root.left, sum_ptr);
	}
	 
	// A wrapper over addGreaterUtil().  It initializes sum and calls
	// addGreaterUtil() to recursivel upodate and use value of sum
	void addGreater(TreeNode root)
	{
	    int sum = 0;
	    addGreaterUtil(root, sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
