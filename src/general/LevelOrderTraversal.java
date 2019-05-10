package general;import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class LevelOrderTraversal {

	/**
	 * @param args
	 */
	//Recursive
	//static int flag=0;
	
	static HashMap<Integer,LinkedList> map=new HashMap<Integer,LinkedList>();
	public static  void printloRecursive(TreeNode root,int level){
		if(root==null){
			return;
		}
		if(map.containsKey(level)){
			LinkedList<Integer> l=map.get(level);
			l.add(root.nodeValue);
			map.put(level, l);
		}
		else{
			LinkedList<Integer> l=new LinkedList<Integer>();
			l.add(root.nodeValue);
			map.put(level,l);
		}
			if(root.left!=null)printloRecursive(root.left,level+1);
			if(root.right!=null)printloRecursive(root.right,level+1);
		
	}
	public static void printMap(){
		int flag=1;
		Iterator it=map.entrySet().iterator();
		
		
		while(it.hasNext()){
			Map.Entry entry=(Map.Entry<Integer,LinkedList>)it.next();
			Integer j=(Integer)entry.getKey();
			j=j+1;
			System.out.print(j+"    ");
			LinkedList<Integer> l=(LinkedList<Integer>)entry.getValue();
			int size=l.size();
			
			if(flag==1){
			for(int i=0;i<size;i++){
				System.out.print(l.get(i)+" ");
			}
			System.out.println();
			flag=0;
			}else{
				for(int i=size-1;i>=0;i--){
					System.out.print(l.get(i)+" ");
				}
				System.out.println();
				flag=1;
			}
		}
	}
	
	//Iterative with levels printed
	public void linkedlistHeightNode(TreeNode node){
		ArrayList<LinkedList<TreeNode>> al=new ArrayList<LinkedList<TreeNode>>();
		int ind=0;
		LinkedList<TreeNode> ll=new LinkedList<TreeNode>();
		if(node==null){return;}
		ll.add(node);
		//int level=0;
		al.add(ind,ll);
		while(true){
			//LinkedList<TreeNode> n=al.get(ind);
			LinkedList<TreeNode> lnew=new LinkedList<TreeNode>();
			
		for(int i=0;i<al.get(ind).size();i++){
			TreeNode t=(TreeNode)al.get(ind).get(i);
			
			if(t!=null){
				if(t.left!=null)lnew.add(t.left);
				if(t.right!=null)lnew.add(t.right);
			}
		}
		ind++;
			if(lnew.size()==0){
			break;
			}
			else{
				al.add(ind,lnew);
			}
			
		}
		
	    ind=0;
	    System.out.println("Index value"+ind);
		while(ind<al.size()){
			System.out.println("Height: "+(ind));
			
			for(int i=0;i<al.get(ind).size();i++){

				TreeNode tl=al.get(ind).get(i);
				System.out.print("\t"+tl.nodeValue+"\t\n");
			}
			
			ind++;
		}
			
		}
	//Iterative without levels printed
	public void printLevelOrder(TreeNode root,int level){
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode t=q.poll();
			System.out.println(t.nodeValue);
			if(t.left!=null){
				q.add(t.left);
			}
			if(t.right!=null){
				q.add(t.right);
			}
		}
	}
	//Inorder traversal without recursion
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   /* Tree t=new Tree();
    t.add(2);
    t.add(4);
    t.add(7);
    t.add(8);
    t.add(9);
    t.add(10);
    t.add(23);
    t.add(6);*/
		TreeNode root= new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(10);
		root.left.left=new TreeNode(20);
		root.left.right=new TreeNode(21);
		root.right.left=new TreeNode(1);
    printloRecursive(root,0);
    printMap();
    System.out.println(map);
	}

}
