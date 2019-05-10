package general;//1)LinkedList can be also reversed using Stacks
//2)Finding the Merging point linkedlist (find lenght of two linked lists 
//and the.start fromt he point sizeA-sizeB or sizeB-sizeA any of which is higher 
//and then parse to each node of the list until the two lists encounter a similar node)


class Node{
	int data;
	Node next;
	Node(int value){
		data=value;
		next=null;
	}
}
public class LinkList {
public Node start;
public int size;
LinkList(){
	start=null;
	size=0;
}
public void add(int value){
	Node temp=new Node(value);
	if(start==null){
		start=temp;size++;
	}
	else{
		Node cur=start;
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.next=temp;size++;
	}	
}
public void delete(int index){
	if(start==null){System.out.println("List empty"); return;}
	Node temp=start;
	//int ind=0;
	if(index==1){
		start=start.next;
		return;
	}
	for(int i=0;i<index-2;i++){
		temp=temp.next;
	}
	
	temp.next=temp.next.next;
}
public int size(){
	return size;
}


public void revereseList(){
	Node prev = null;
	Node next = null;
	Node current = start;
	while(current != null){
		//This is a reference of the currents next position. // Store next
		next = current.next;
		//set the current.next position// Reverse current node's pointer
		current.next = prev;
		 // Move pointers one position ahead.
		//This is to move the prev pointer by 1 position
		prev = current;
		//This is to move the current pointer to next postion
		current = next;
	}
	
	start = prev;
}
public void reverse(){
	Node first=start;
	if(first==null){return;}
	Node second=first.next;
	if(second==null){return;}
	Node third=second.next;
	if(third==null){second.next=first;first.next=null;}
	else{
		second.next=first;
		first.next=null;
		Node temp=third.next;
		while(temp!=null){
			third.next=second;
			second=third;
			third=temp;
			temp=temp.next;
		}
		third.next=second;
		start=third;
	}
	
	
}
public void display(){
	Node temp=start;
    while(temp!=null){
    	System.out.println("Node value"+temp.data);
    	temp=temp.next;
    }
}
//Reverse linked list by kth node
/*
 * 1) Traverse the list by k nodes.
2) Keep kth node in temp.
3) Travese till end of list and set last node pointer to start.
4) Set kth nodes next to head.
5) Point kth node next to NULL.
 */
public void reversekth(int k){
	Node temp=start;
	int index=0;
	while(index<k-1){
		temp=temp.next;
		index++;
	}
	Node root=temp;
	while(temp.next!=null){
		temp=temp.next;
	}
	temp.next=start;
	start=root.next;
	root.next=null;
}
public void pairwiseRev(){
	Node temp=start;
	if(temp==null)return;
	while(temp!=null && temp.next!=null){
		Node first=temp;
		Node second=temp.next;
		int fdata=first.data;
		int sdata=second.data;
		first.data=sdata;
		second.data=fdata;
		temp=temp.next.next;
	}
}
public void printRev(Node n){
	if(n==null){
		return;
	}
	else{
		printRev(n.next);
		System.out.println("Value "+n.data);
	}
}
public void printReverse(){
	printRev(start);
}

public void RecursiveReverse(Node n){
	if(n.next==null){
		start=n;
		return;
	}
	RecursiveReverse(n.next);
	Node temp=n.next;
	temp.next=n;
	n.next=null;
	
}
public void recurseRev(){
	RecursiveReverse(start);
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
   LinkList l=new LinkList();
   l.add(12);
   l.add(13);
   l.add(11);
   l.add(22);
   l.add(1);
   /*System.out.println("Print after add");
   l.display();
   l.add(2);
   System.out.println("Print after add");
   l.display();
   System.out.println("Print after delete");
   l.delete(2);
   l.display();
   System.out.println("Recursive reverse Print");
   l.printReverse();
   System.out.println("Recursive reverse list");
   l.recurseRev();
   l.display();
   System.out.println("Reverse \n");
   l.reverse();
   l.display();*/
   l.reversekth(3);
   l.display();
	}

}
