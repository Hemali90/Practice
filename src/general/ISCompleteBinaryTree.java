package general;
public class ISCompleteBinaryTree {
	/*
	 * @param countNodes is calculated by calculating the number of nodes in the tree
	 * @param level is zero initially
	 */
public boolean isComplete(TreeNode root, int level, int countNodes){
	if(root==null){
		return true;
	}
	if(level >= countNodes){
		return false;
	}
	
	return isComplete(root.left,2*level+1,countNodes) && isComplete(root.right,2*level+2, countNodes);
}


}
