package general;

import java.util.ArrayList;
import java.util.List;


public class CopyNaryTree {

	class Node{
		String val;
		List<Node> subTree;
	}

	public Node copy(Node root){
		if(root == null){
			return root;
		}
		
		Node newRoot = new Node();
		newRoot.val = root.val;
		List<Node> child = new ArrayList<>();
		for(Node n: root.subTree){
			
			child.add(n);
			copy(n);
		}
		
		newRoot.subTree = child;
		return newRoot;
	}
}
