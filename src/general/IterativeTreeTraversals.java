package general;import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class IterativeTreeTraversals {

	/**
	 * @param args
	 */
	public void inorder(TreeNode root){
		if(root==null){
			return;
		}
		else{
			Stack<TreeNode> st=new Stack<TreeNode>();
			TreeNode current=root;
			st.push(root);
			while(current!=null||!st.isEmpty()){
				if(current!=null){
					st.push(current.left);
					current=current.left;
				}
				else{
					TreeNode t=st.pop();
					System.out.println(t.nodeValue);
					current=t.right;
				}
			}
		}
	}
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
 
        if(root == null)
            return returnList;
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            returnList.add(n.nodeValue);
 
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
 
        }
        return returnList;
    }
public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result=new ArrayList<Integer>();
        if (root==null){
            return result;
        }
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode runner=root;
        
        while (runner!=null){
            stack.push(runner);
            runner=runner.left;
        }
        // child node used to record if mid node's child has been visited inorder to tell if need to pop out        
        //the mid node
        
        TreeNode child=null;
        
        while (!stack.isEmpty()){
            TreeNode current=stack.peek();
            if (current.right==null || current.right==child){
                result.add(stack.pop().nodeValue);
                // catch the child node, inorder mid node could check if its child already be visited
                child=current;
            }
            else{
                current=current.right;
                while (current!=null){
                    stack.push(current);
                    current=current.left;
                }
            }
        }
        
        return result; 
    }

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
