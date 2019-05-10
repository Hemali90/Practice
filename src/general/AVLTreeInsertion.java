package general;
class AVLNode{
	int data;
	AVLNode left;
	AVLNode right;
	int height;
	int size;
	AVLNode(int data){
		this.data=data;
	}
	public static AVLNode newAVLNode(int data){
		return new AVLNode(data);
	}
}
public class AVLTreeInsertion {
	private AVLNode leftRotate(AVLNode root){
        AVLNode newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }
    
    private AVLNode rightRotate(AVLNode root){
        AVLNode newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);       
        newRoot.height = setHeight(newRoot);
        
        return newRoot;
    }

    private int setHeight(AVLNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }
    
    private int height(AVLNode root){
        if(root == null){
            return 0;
        }else {
            return root.height;
        }
    }
    
   
    public AVLNode insert(AVLNode root, int data){
        if(root == null){
            return AVLNode.newAVLNode(data);
        }
        if(root.data <= data){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);
        }
        int balance = balance(root.left, root.right);
        /**
         * if left subtree is greater than right subtree
         */
        if(balance > 1){
        	/**
        	 * Left Left Case
        	 * 
        	 * T1, T2, T3 and T4 are subtrees.
         z                                      y 
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \ 
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2

        	 */
            if(height(root.left.left) >= height(root.left.right)){
                root = rightRotate(root);
                
            }
            /**
             * Left Right Case

     z                               z                           x
    / \                            /   \                        /  \ 
   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
T1   x                          y    T3                    T1  T2 T3  T4
    / \                        / \
  T2   T3                    T1   T2

             */
            else{
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } // right subtree is greater than left subtree
        else if(balance < -1){
        	
        	/**
        	 * c) Right Right Case

  z                                y
 /  \                            /   \ 
T1   y     Left Rotate(z)       z      x
    /  \   - - - - - - - ->    / \    / \
   T2   x                     T1  T2 T3  T4
       / \
     T3  T4

        	 */
            if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            }
            /**
             * Right Left Case

   z                            z                            x
  / \                          / \                          /  \ 
T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
   x   T4                      T2   y                  T1  T2  T3  T4
  / \                              /  \
T2   T3                           T3   T4

             */
            else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else{
            root.height = setHeight(root);
            //root.size = setSize(root);
        }
        return root;
    }
    
    private int balance(AVLNode rootLeft, AVLNode rootRight){
        return height(rootLeft) - height(rootRight);
    }
    
    public static void main(String args[]){
        AVLTreeInsertion avlTree = new AVLTreeInsertion();
        AVLNode root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
        
        //TreeTraversals tt = new TreeTraversals();
        //tt.inOrder(root);
        System.out.println();
        //tt.preOrder(root);
    }
}
