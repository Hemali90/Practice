package general;import java.util.Iterator;
import java.util.LinkedList;
//import java.util.ListIterator;
import java.util.Scanner;



public class NthLastElementList {
private static Scanner sc;
public Integer nthLast(LinkedList<Integer> l,int n){
	
	int i=0;
	Iterator<Integer> it1=l.iterator();
	Iterator<Integer> it2=l.iterator();
	
	while(i<n && (it1.hasNext())){
	  it1.next();
		i++;
	}
	while((it1.hasNext()) && (it2.hasNext())){
		it1.next();
		it2.next();
		}
	Integer ret=it2.next();
	return ret;
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
		   System.out.println("Enter the nth element");
		   int n=sc.nextInt();
		   
		   NthLastElementList ele=new NthLastElementList();
		   System.out.println(ele.nthLast(list,n));
	}

}
