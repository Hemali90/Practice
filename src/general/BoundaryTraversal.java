package general;
public class BoundaryTraversal {
	void printLeafNodes(TreeNode head) {
		if(head == null) {
		return;
		}
		if(head.left == null && head.right == null) {
		System.out.println(head.nodeValue);
		}
		else {
		printLeafNodes(head.left);
		printLeafNodes(head.right);
		}
		}

		void printBoundaryLeft(TreeNode root)
		{
		if (root!=null)
		{
		if (root.left!=null)
		{
		System.out.println("\t"+ root.nodeValue);
		printBoundaryLeft(root.left);
		}
		else if( root.right!=null )
		{
		System.out.println("\t"+ root.nodeValue);
		printBoundaryLeft(root.right);
		}
		}
		}

		void printBoundaryRight(TreeNode root)
		{
		if (root != null) {
			if (root.right != null) {
				printBoundaryRight(root.right);

				System.out.println("\t" + root.nodeValue);

			}

			else if (root.left != null)

			{
				printBoundaryRight(root.left);

				System.out.println("\t" + root.nodeValue);
			}
		}
		}

			void printBoundary(TreeNode head) {

			if(head == null) {
			return;
			}
			System.out.println(head.nodeValue+"\t");
			printBoundaryLeft(head.left);
			printLeafNodes(head.left);
			printLeafNodes(head.right);
			printBoundaryRight(head.right);
			}
public static void main(String[] args){
	
}
}
