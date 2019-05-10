package general;import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//without using HashSet(which removes duplicates)
public class RemoveDuplicatesFromList {
private static Scanner sc;
public void removeDup(LinkedList<Integer> ll){
	int ind=0;
	while(ind<ll.size()){
		Integer i=ll.get(ind);
		while((ll.indexOf(i))!=(ll.lastIndexOf(i))){
			int index=ll.lastIndexOf(i);
			ll.remove(index);
		}
		ind++;
	}
		Iterator<Integer> it=ll.iterator();
		 System.out.println("Elements after removing duplicates");
		 while(it.hasNext()){
			 Integer in=it.next();
			 System.out.println("Object "+in );
		 }
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of elements in the list");
		   sc = new Scanner(System.in);
		   int total=sc.nextInt();
		   LinkedList<Integer> list=new LinkedList<Integer>();
		   System.out.println("Enter the elements in the list");
		   for(int i=0;i<total;i++)
		   {
			   System.out.println("Enter");
			   int put=sc.nextInt();
			   list.add(new Integer(put));
		   }
		   
		   RemoveDuplicatesFromList rd=new RemoveDuplicatesFromList();
		   rd.removeDup(list);
			}
	}


