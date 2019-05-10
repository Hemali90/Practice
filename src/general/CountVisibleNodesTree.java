package general;
public class CountVisibleNodesTree {

	/**
	 * @param args
	 */
	public static int countVisible(TreeNode r , int ancestorMax)
	{
		if(r==null){
			return 0;
		}
		int newMax=Math.max(ancestorMax, r.nodeValue);
		if(r.nodeValue >= ancestorMax){
			return 1+countVisible(r.left,newMax)+countVisible(r.right,newMax);
		}else{
			return countVisible(r.left,newMax)+countVisible(r.right,newMax);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeNode root= new TreeNode(5);
root.left=new TreeNode(3);
root.right=new TreeNode(10);
root.left.left=new TreeNode(20);
root.left.right=new TreeNode(21);
root.right.left=new TreeNode(1);
		/*TreeNode root=new TreeNode(8);
		root.left=new TreeNode(2);
		root.right=new TreeNode(6);
		root.left.right=new TreeNode(7);
		root.left.left=new TreeNode(8);*/
int minval=Integer.MIN_VALUE;
int count=countVisible(root,minval);
System.out.println(count);
	}

}
