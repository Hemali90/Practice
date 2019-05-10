package general;

import java.util.ArrayList;
import java.util.List;

public class PrintPathsTree {
	 public List<String> binaryTreePaths(TreeNode root) {
	        List<String> returnList = new ArrayList<>();
	        if(root == null){
	            return returnList;
	        }
	        
	        
	        
	        if(root.left == null && root.right == null){
	            returnList.add(String.valueOf(root.nodeValue));
	            return returnList;
	        }
	        List<String> leftPath = binaryTreePaths(root.left);
	        if(leftPath != null)
	        {
	            for(String s: leftPath){
	                StringBuilder sb = new StringBuilder(String.valueOf(root.nodeValue));
	                sb.append("->");
	                sb.append(s);
	                returnList.add(sb.toString());
	            } 
	        }
	        
	        List<String> rightPath = binaryTreePaths(root.right);
	        if(rightPath != null){
	            for(String s: rightPath){
	                StringBuilder sb = new StringBuilder(String.valueOf(root.nodeValue));
	                sb.append("->");
	                sb.append(s);
	                returnList.add(sb.toString());
	            } 
	        }
	       
	        return returnList;
	    }
public static void printArray(int path[],int len){
	for(int i=0;i<len;i++){
		System.out.println(path[i]);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
