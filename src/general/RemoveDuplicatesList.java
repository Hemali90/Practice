package general;//import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*using Hashtable*/
public class RemoveDuplicatesList {
 private static Scanner sc;
public void removeDuplicates(LinkedList<Integer> l){
	 HashSet<Integer> hm=new HashSet<Integer>();
	 for(Integer obj:l){
		 hm.add(new Integer(obj));
	 }
	 Iterator<Integer> it=hm.iterator();
	 System.out.println("Elements after removing duplicates");
	 while(it.hasNext()){
		 Integer i=it.next();
		 System.out.println("Object "+i );
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
   
   RemoveDuplicatesList rd=new RemoveDuplicatesList();
   rd.removeDuplicates(list);
	}

}
