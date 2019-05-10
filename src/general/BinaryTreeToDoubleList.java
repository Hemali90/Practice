package general;
public class BinaryTreeToDoubleList {
	 static TreeNode prev = null;
	void  BinaryTree2DoubleLinkedList(TreeNode root, TreeNode head)
	{
	    // Base case
	    if (root == null) return;
	 
	    // Initialize previously visited node as NULL. This is
	    // static so that the same value is accessible in all recursive
	    // calls
	   
	 
	    // Recursively convert left subtree
	    BinaryTree2DoubleLinkedList(root.left, head);
	 
	    // Now convert this node
	    if (prev == null)
	        head = root;
	    else
	    {
	        root.left = prev;
	        prev.right = root;
	    }
	    prev = root;
	 
	    // Finally convert right subtree
	    BinaryTree2DoubleLinkedList(root.right, head);
	}
	
	public TreeNode binTree2ListUtil(TreeNode root)
	{
	    // Base case
	    if (root == null)
	        return root;
	    // Convert the left subtree and link to root
	    if (root.left != null)
	    {
	        // Convert the left subtree
	        TreeNode left = binTree2ListUtil(root.left);	 
	        // Find inorder predecessor. After this loop, left
	        // will point to the inorder predecessor
	        for (; left.right!=null; left=left.right);	 
	        // Make root as next of the predecessor
	        left.right = root;	 
	        // Make predecssor as previous of root
	        root.left = left;
	    }	 
	    // Convert the right subtree and link to root
	    if (root.right!=null)
	    {
	        // Convert the right subtree
	        TreeNode right = binTree2ListUtil(root.right);	 
	        // Find inorder successor. After this loop, right
	        // will point to the inorder successor
	        for (; right.left!=null; right = right.left);	 
	        // Make root as previous of successor
	        right.left = root;	 
	        // Make successor as next of root
	        root.right = right;
	    }	 
	    return root;
	}
 
	// The main function that first calls bintree2listUtil(), then follows step 3 
	//  of the above algorithm
	TreeNode binTree2List(TreeNode root)
	{
	    // Base case
	    if (root == null)
	        return root;
	 
	    // Convert to DLL using bintree2listUtil()
	    root = binTree2ListUtil(root);
	 
	    // bintree2listUtil() returns root node of the converted
	    // DLL.  We need pointer to the leftmost node which is
	    // head of the constructed DLL, so move to the leftmost node
	    while (root.left != null)
	        root = root.left;
	 
	    return (root);
	}
}
