package general;
public class HuffmanDecoding {
 
	   class Node{
	      public  int frequency; // the frequency of this tree
	       public  char data;
	       public  Node left, right;
	  
	   }

	public void getChar(Node parent,Node node,int i,char[] st,String str){
	    if(i==st.length){
	       System.out.println(str);
	    }
	    else{
	    if(st[i]=='1')
	    {
	                if(node.right.data=='\0'){
	                 getChar(parent,node.right,i+1,st,str);
	                }
	                else{
	                  getChar(parent,parent,i+1,st,str+node.right.data);
	                }
	    }
	    else if(st[i]=='0'){
	                if(node.left.data=='\0'){      
	                    getChar(parent,node.left,i+1,st,str);
	                }
	                else{
	                    getChar(parent,parent,i+1,st,str+node.left.data);
	                }
	    }
	    }
	}
	void decode(String S ,Node root)
	    {
	    char[] s=S.toCharArray();
	    getChar(root,root,0,s,"");
	    }

}
