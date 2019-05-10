package general;import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumInSlidingWindow {

	/**
	 * @param args
	 */
	public static void  maximumSlide(int arr[],int k){
		int n=arr.length;
		int i=0;
		Deque<Integer> q=new ArrayDeque<Integer>();
		q.add(0);
		for(i=1;i<k;i++){
			if(arr[i]>=arr[q.peekLast()]){
				q.addLast(i);
			}
			else{
				q.addFirst(i);
			}
		}
		System.out.println(arr[q.peekLast()]);
		for(;i<n;i++){
			while(!q.isEmpty() && q.peekLast()<=i-k){
				q.removeLast();
			}
			if(arr[i]>=arr[q.peekLast()]){
				q.addLast(i);
			}
			else{
				while(q.peekFirst()<=i-k || arr[q.peekFirst()]<=arr[i])
				q.removeFirst();
				q.addFirst(i);
			}
			System.out.println(arr[q.peekLast()]);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={2,5,1,2,0,2,7,6,5,4,8,19};
		maximumSlide(arr,3);
	}

}
