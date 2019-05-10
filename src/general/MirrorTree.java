package general;
public class MirrorTree {

	void mirrortree(TreeNode ptr) {

		if(ptr == null)
			return;
		// recursively create mirror on both subtree
		mirrortree(ptr.left);
		mirrortree(ptr.right);
		// swap left & right subtree
		TreeNode temp = ptr.left;
		ptr.left = ptr.right;
		ptr.right = temp;
	}
	
	public static boolean mirrorTree(TreeNode l, TreeNode r){
		if(l == null && r == null) return true;
		if(l == null || r == null) return false;
		return (l.nodeValue == r.nodeValue)
		        && mirrorTree(l.right, r.left)
		        && mirrorTree(l.left, r.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
