package general;
public class ConstructTrees {
	
	/*
	 * Construct tree given preorder
	 */
	
TreeNode constructTreeUtil( int pre[], int preIndex, int key,
            int min, int max, int size )
{
// Base case
if( preIndex >= size )
return null;
TreeNode root = null;
// If current element of pre[] is in range, then
// only it is part of current subtree
if( min < key && key < max )
{
// Allocate memory for root of this subtree and increment *preIndex
root = new TreeNode ( key );
preIndex = preIndex + 1;

if (preIndex < size)
{
// Contruct the subtree under root
// All nodes which are in range {min .. key} will go in left
// subtree, and first such node will be root of left subtree.
root.left = constructTreeUtil( pre, preIndex, pre[preIndex],
                    min, key, size );

// All nodes which are in range {key..max} will go in right
// subtree, and first such node will be root of right subtree.
root.right = constructTreeUtil( pre, preIndex, pre[preIndex],
                     key, max, size );
}
}

return root;
}

//The main function to construct BST from given preorder traversal.
//This function mainly uses constructTreeUtil()
TreeNode constructTree (int pre[], int size)
{
int preIndex = 0;
return constructTreeUtil ( pre, preIndex, pre[0], Integer.MIN_VALUE,Integer.MAX_VALUE, size );
}

	/*public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length-1;
        int postStart =0;
        int postEnd = postorder.length-1;
 
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
 
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
                            int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;
 
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
 
        root.left = buildTree(inorder, inStart, k-1, postorder, postStart, postStart+k-(inStart+1));
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = buildTree(inorder, k+1, inEnd, postorder, postStart+k-inStart, postEnd-1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1
 
        return root;
    }
   */
    private TreeNode constructTree(int pre[],int post[],int prestart,int preend,int poststart,int postend){
    	if (poststart > postend)
            return null;
     
        // The first node in preorder traversal is root. So take the node at
        // preIndex from preorder and make it root, and increment preIndex
        TreeNode start = new TreeNode(pre[prestart]);//newNode ( pre[*preIndex] );
        ++prestart;
     
        // If the current subarry has only one element, no need to recur
        if ( poststart== postend)
            return start;
     
        // Search the next element of pre[] in post[]
        int i;
        for (i = poststart; i <= postend; i++)
        { if (pre[prestart] == post[i])
                break;}
     
        // Use the index of element found in postorder to divide postorder array in
        // two parts. Left subtree and right subtree
        	int len= i-poststart;
            start.left = constructTree (pre, post,prestart,prestart+len,poststart, i);
            start.right = constructTree (pre, post,prestart+len+1,preend, i + 1, postend-1);
        
     
        return start;
    }
    public TreeNode construct(int pre[],int post[],int size){
    	int preIndex = 0;
        return constructTree (pre, post, 0, size-1,0 , size-1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int preLength = preorder.length;
        int inLength = inorder.length;
        return buildTree(preorder, 0, preLength-1, inorder, 0, inLength-1);
    }
   
    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
       }
        int rootVal = pre[preStart];
        int rootIndex = 0;
       
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
       
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
        root.right = buildTree(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);
                return root;
    }

}
