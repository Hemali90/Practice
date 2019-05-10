package general;import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
 

public class MergeSortedLinkedList {

	/**
	 * @param args
	 */
	/*
	 * Time: log(k) * n.
		k is number of list and n is number of total elements.
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;
 
		//PriorityQueue is a sorted queue
		
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
		//add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}
 
		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer/cursor
 
		while (q.size() > 0) {
			ListNode temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;
 
			//keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
 
			p = p.next;
		}
 
		return head.next;
	}
	public static void merge(LinkedList<Integer> l1,LinkedList<Integer> l2){
		Iterator<Integer> it1=l1.iterator();
		Iterator<Integer> it2=l2.iterator();
		LinkedList<Integer> l3=new LinkedList<Integer>();
		Integer a=it1.next();
	    Integer b=it2.next();
		while(it1.hasNext() && it2.hasNext()){
			
			if(a<b){
				l3.add(a);
				a=it1.next();
			}
			else{
				l3.add(b);
				b=it2.next();
			}
		}
		while(it1.hasNext()){
			l3.add(it1.next());
		}
		while(it2.hasNext()){
			l3.add(it2.next());
		}
		
		Iterator it3=l3.iterator();
		while(it3.hasNext()){
			System.out.print(it3.next()+ " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> l1=new LinkedList<Integer>(Arrays.asList(1,3,5,10,11,14));
		LinkedList<Integer> l2=new LinkedList<Integer>(Arrays.asList(2,4,6,8,16,19,20));
		merge(l1,l2);
		
	}

}
