package general;import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestor {

	
	
	/**
	 * path from root to node
	 * @param root
	 * @param path
	 * @param k
	 * @return
	 */
	
	public Boolean printPath(TreeNode root, TreeNode dest, List<Integer> path){
		if(root==null) return false;
		if(root==dest||printPath(root.left,dest,path)||printPath(root.right,dest,path)){
			//System.out.print("  " + root.data);
			path.add(0,root.nodeValue);
			return true;
		}
		return false;
	}
	/*
	 * Method 1: time complexity: O(n), extra space
	 */
	
	boolean findPath(TreeNode root, ArrayList<Integer> path, int k)
	{
	    // base case
	    if (root == null) return false;
	 
	    // Store this node in path vector. The node will be removed if
	    // not in path from root to k
	    path.add(root.nodeValue);
	 
	    // See if the k is same as root's key
	    if (root.nodeValue == k)
	        return true;
	 
	    // Check if k is found in left or right sub-tree
	    if ( (root.left != null && findPath(root.left, path, k)) ||
	         (root.right!= null && findPath(root.right, path, k)) )
	        return true;
	 
	    // If not present in subtree rooted with root, remove root from
	    // path[] and return false
	    path.remove(path.size()-1);
	    return false;
	}
	// Returns LCA if node n1, n2 are present in the given binary tree,
	// otherwise return -1
	int findLCA1(TreeNode root, int n1, int n2)
	{
	    // to store paths to n1 and n2 from the root
	    ArrayList<Integer> path1=new ArrayList<Integer>();
	    ArrayList<Integer> path2=new ArrayList<Integer>();	 
	    // Find paths from root to n1 and root to n1. If either n1 or n2
	    // is not present, return -1
	    if ( !findPath(root, path1, n1) || !findPath(root, path2, n2))
	          return -1;
	 
	    /* Compare the paths to get the first different value */
	    int i;
	    for (i = 0; i < path1.size() && i < path2.size() ; i++)
	        if (path1.get(i) != path2.get(i))
	            break;
	    return path1.get(i-1);
	}
	/*
	 * Method 2: time Complexity: O(n) ,no extra space. assumes that both the nodes are present in the tree
	 */
	// This function returns pointer to LCA of two given values n1 and n2.
	// This function assumes that n1 and n2 are present in Binary Tree
	 public TreeNode findLCA2( TreeNode root, int n1, int n2)
	{
	    // Base case
	    if (root == null) return null;
	 
	    // If either n1 or n2 matches with root's key, report
	    // the presence by returning root (Note that if a key is
	    // ancestor of other, then the ancestor key becomes LCA
	    if (root.nodeValue == n1 || root.nodeValue == n2)
	        return root;
	 
	    // Look for keys in left and right subtrees
	    TreeNode left_lca  = findLCA2(root.left, n1, n2);
	    TreeNode right_lca = findLCA2(root.right, n1, n2);
	 
	    // If both of the above calls return Non-NULL, then one key
	    // is present in once subtree and other is present in other,
	    // So this node is the LCA
	    if (left_lca != null  && right_lca != null )  return root;
	 
	    // Otherwise check if left subtree or right subtree is LCA
	    return (left_lca != null)? left_lca: right_lca;
	}
	 
	 /**Method 3:
	  * 
	  * 
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
	 	if(root==null) {return false;}
	 	if(root==test) return true;
	 	return (covers(root.left,test) || covers(root.right,test));
	 }
}
