package general;public class BSTMinMaxTree{
	public static void  bst(Tree t,int min,int max){
		TreeNode temp=t.root;
		getTree(temp,min,max);
	}
	static Tree res=new Tree();
	public static void getTree(TreeNode n,int min,int max){
		if (n == null)
	        return;
	    getTree(n.left,min,max);
	if(n.nodeValue>=min && n.nodeValue<=max)
	    {
		System.out.println(n.nodeValue);
	    res.add(n.nodeValue);
	    }
	    getTree(n.right,min,max);
	}
	public static void print(TreeNode r){
		if(r ==null){
			return;
		}
		print(r.left);
		System.out.println(r.nodeValue);
		print(r.right);
	}
	public static void main(String args[]){
		Tree t=new Tree();
		t.root=new TreeNode(10);
		t.root.left=new TreeNode(7);
		t.root.right=new TreeNode(13);
		t.root.left.left=new TreeNode(6);
		t.root.left.right=new TreeNode(9);
		t.root.right.left=new TreeNode(11);
		bst(t,6,11);
		TreeNode r=res.root;
		System.out.println();
		print(r);
		
	}
}