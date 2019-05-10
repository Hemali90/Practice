package general;class DoubleNode{
	int data;
	DoubleNode next;
	DoubleNode previous;
	DoubleNode(int value){
		data=value;
	}
}
public class DobleLinkList {
DoubleNode start=null;

public void add(int value){
	DoubleNode newnode=new DoubleNode(value);
	if(start==null){
		start=newnode;
		start.previous=null;
		start.next=null;
	}
	else{
		DoubleNode temp,current;
		temp=start;
		while(temp.next!=null){
			temp=temp.next;
		}
		
		temp.next=newnode;
		current=temp.next;
		current.previous=temp;
	}
	
}

public void delete(int val){
	if (start==null){return;}
	if(val==start.data){
		start=start.next;
		start.previous=null;
	}
	else{
		DoubleNode temp,prev;
		temp=start;
		while(val!=temp.data){
			temp=temp.next;
			if(temp==null)break;
		}
		if(temp==null){System.out.println("No such value in the list");return;}
		if(temp.next==null){
			temp.previous.next=null;
		}
		else{
		prev=temp.previous;
		prev.next=temp.next;
		temp.next.previous=prev;
		}
	}
	
}
public void display(){
	DoubleNode temp;
	temp=start;
	while(temp!=null){
		System.out.println(temp.data+"\t");
		temp=temp.next;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DobleLinkList db=new DobleLinkList();
db.add(10);
db.add(9);
db.add(12);
db.add(17);
db.add(21);
db.add(31);
db.add(18);
System.out.println("List");
db.display();
db.delete(12);
System.out.println("List after delete");
db.display();

	}

}
