package general;
public class DoubleTree {
public void constructdouble(TreeNode root){
	if(root==null){
		return;
	}
	TreeNode left=root.left;
	constructdouble(root.left);
	constructdouble(root.right);
	root.left=new TreeNode(root.nodeValue);
	root.left.left=left;
}
}
