package general;import java.util.Comparator;
import java.util.PriorityQueue;
 
public class PriorityQueueTest {
 
	static class PQsort implements Comparator<Integer> {
 
		public int compare(Integer one, Integer two) {
			return one.compareTo(two);
		}
	}
 
	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
 
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			pq1.offer(x);
		}
 
		System.out.println("pq1: " + pq1);
 
		PQsort pqs = new PQsort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);
		for (int x : ia) {
			pq2.offer(x);
		}

		Integer x=pq2.poll();
		while(x!=null){
			System.out.println(x);
			x=pq2.poll();
		}
	}
}