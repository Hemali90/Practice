package general;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class TreeNode{
	int nodeValue;
	TreeNode left;
	TreeNode right;
	boolean visited;
	TreeNode(int value){
		nodeValue=value;
		left=null;
		right=null;
		visited=false;
	}
	TreeNode(TreeNode node){
		this.nodeValue=node.nodeValue;
		this.left=node.left;
		this.right=node.right;
	}
	
}

public class BalancedTree {
	
	private static Scanner sc;
	public void add(TreeNode n,TreeNode root){
		if(root==null||n==null){
			return;
		}
		else{
		 if(root.nodeValue>n.nodeValue){
			 if(root.left==null){
				root.left=n;
			 }
			 else{
				 add(n,root.left);
			 }
		 }
		 else{
			 if(root.right==null){
					root.right=n;
				 }
				 else{
					 add(n,root.right);
				 }
		 }
		}
	}
	public void preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         //ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return; 
 
        Stack<TreeNode> st = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;
 
        
        st.push(p);
        while(!st.isEmpty()){
        	TreeNode t=st.pop();
        	System.out.println(t.nodeValue);
        	if(t.left!=null){
        		st.push(t.left);
        	}
        	if(t.right!=null){
        		st.push(t.right);
        	}
        }
 
        
    }
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;
 
        while(!stack.empty() || p != null){
 
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.nodeValue);
                p = t.right;
            }
        }
 
        return lst;
    }
	public boolean BST(TreeNode root,int value){
		if(root==null){
			return false;
		}
		else{
			if(value==root.nodeValue){
				return true;
			}
			else if(value<root.nodeValue){
				return BST(root.left,value);
			}
			else{
				return BST(root.right,value);
			}
		}
	}
	public void inOrder(TreeNode root){
		if(root!=null){
		inOrder(root.left);
		System.out.println(root.nodeValue);
		inOrder(root.right);
		}
	}
	
	public int maxDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		else{
			return 1+Math.max(maxDepth(root.left),maxDepth( root.right));
		}
	}
	public int minDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		else{
			return 1+Math.min(minDepth(root.left),minDepth( root.right));
		}
	}
	
	
	public boolean isBalanced(TreeNode root){
		return (maxDepth(root)-minDepth(root)<=1);
	}
	
	
	public void run(){
		System.out.println("Enter the number of nodes in the tree");
		sc = new Scanner(System.in);
		//BalancedTree bt=new BalancedTree();
		int num=sc.nextInt();
		TreeNode root=new TreeNode(10);
		 //add(root, root);
		for(int i=1;i<num;i++){
			System.out.println("Enter element");
			int value=sc.nextInt();
			TreeNode newnode=new TreeNode(value);
			add(newnode,root);
		}
		inOrder(root);
		System.out.println("Tree is balanced? "+isBalanced(root));
	}
	
public void preorder(TreeNode root){
	if(root==null){
		return;
	}
	System.out.println(root.nodeValue);
	preorder(root.left);
	preorder(root.right);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
BalancedTree bt=new BalancedTree();

System.out.println("Enter the number of nodes in the tree");
sc = new Scanner(System.in);
//BalancedTree bt=new BalancedTree();
int num=sc.nextInt();
TreeNode root=new TreeNode(1);
 //add(root, root);
for(int i=1;i<num;i++){
	System.out.println("Enter element");
	int value=sc.nextInt();
	TreeNode newnode=new TreeNode(value);
	bt.add(newnode,root);
}
bt.inOrder(root);
System.out.println("Tree is balanced? "+bt.isBalanced(root));
//bt.run();
ArrayList<Integer> al= bt.inorderTraversal(root);
for(Integer i:al){
	System.out.println(i);
}

System.out.println("Preorder traversal");
bt.preorderTraversal(root);
System.out.println("Original Preorder traversal");
bt.preorder(root);

	}

}
