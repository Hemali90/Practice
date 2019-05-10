package general;import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;


public class TripletsLinkedList {

	/**
	 * @param args
	 * Sorting can be used to reduce the time complexity to O(n*n). Following are the detailed steps.
1) Sort list b in ascending order, and list c in descending order.
2) After the b and c are sorted, one by one pick an element from list a and find the 
pair by traversing both b and c. See isSumSorted() in the following code.
	 */
	public void triplets(LinkedList<Integer> l1,LinkedList<Integer> l2,LinkedList<Integer> l3,int sum){
		Collections.sort(l2);
		Collections.sort(l3,new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				return b.compareTo(a);
			}
		});
		Iterator<Integer> i1=l1.iterator();
		int a=i1.next();
		while(i1.hasNext()){
			Iterator<Integer> i2=l2.iterator();
			Iterator<Integer> i3=l3.iterator();
			int b=i2.next();
			int c=i3.next();
			while(i2.hasNext()&&i3.hasNext()){
				
				Integer s=a+b+c;
				if(sum==s){
					System.out.println(a+" "+b+" "+c+" "+" "+sum);
					return;
				}
				else if(s<sum){
					b=i2.next();
				}
				else{
					c=i3.next();
				}
			}
			a=i1.next();
		}
		System.out.println("No such triplets");
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
