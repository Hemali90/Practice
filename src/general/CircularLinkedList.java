package general;


class Node1{
	static int noOfLinkedlist=0;
int data;
Node1 next;
Node1(int data){
	this.data=data;
	noOfLinkedlist++;
}

}
public class CircularLinkedList {
     static Node1 current;
     static Node1 temp;
     static Node1 root;
     
     public void add(int data){
    	 Node1 node=new Node1(data);
    	if(root==null)
    	{
    		root=node;
    		//node.next=null;
    		root.next=root;
    	}else
    	{
    	current=root;
    	while(current.next!=root){
    		current=current.next;
    	}
    	current.next=node;node.next=root;
    	}
     }
     
     /*public void addAtIndex(int data,int index){
    	 Node node=new Node(data);
    	 current=root;
    	 int i=0;
    	 while(i<index){
    		 current=current.next;
    	 }
    	 temp=current.next;
    	 current.next=node;
    	 node.next=temp; 
     }*/
     
     public void delete(int index){
    	 int i=1;
    	 current=root;
    	 if(index==1){
    		temp=root.next;
    		while(temp.next!=root){
    			temp=temp.next;
    		}
    		temp.next=temp.next.next;
    		root=current.next;
    		Node1.noOfLinkedlist--;
    	 }
    	 else{
    	 while(i<index-1){
    		 current=current.next;
    		 i++;
    	 }
    	 current.next=current.next.next;
    	 Node1.noOfLinkedlist--;
    	 }

     }
     
     public void print(){
    	 current=root;
    	do{
    		 System.out.println(current.data);
    		 current=current.next;
    	} while(current!=root);
     }
    /* public int size(){
    	 int size=0;
    	 current=root;
    	 while(current!=null){
    		 current=current.next;
    		 size++;
    	 }
    	 return size;
     }*/
	public static void main(String[] args) {
		// TODO Auto-generated method stu
CircularLinkedList ml=new CircularLinkedList();
ml.add(7);
ml.add(9);
ml.add(3);
ml.add(2);
ml.add(1);
ml.add(8);
ml.add(6);
ml.print();
//ml.delete(3);
//ml.print();
//ml.addAtIndex(10, 2);
//ml.print();
	}

}
