package general;import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfIntegerStream {

public static Queue<Integer> minHeap;
public static Queue<Integer> maxHeap;
public int numOfElements;

public MedianOfIntegerStream() {
minHeap = new PriorityQueue();
maxHeap = new PriorityQueue(10, new MaxHeapComparator()); 
numOfElements = 0;
}
public void add(int num){
	
}
public void addNumberToStream(int randomNumber) {
	  if (maxHeap.size() == minHeap.size()) {
	    if ((minHeap.peek() != null) && randomNumber > minHeap.peek()) {
	      maxHeap.offer(minHeap.poll());
	      minHeap.offer(randomNumber);
	    } else {
	      maxHeap.offer(randomNumber);
	    }
	  }
	  else {  
	    if(randomNumber < maxHeap.peek()) {
	      minHeap.offer(maxHeap.poll());
	      maxHeap.offer(randomNumber);
	    }
	    else {
	      minHeap.offer(randomNumber);
	    }
	  }
	}

	public static double getMedian() {
	  if (maxHeap.isEmpty()) return minHeap.peek();
	  else if (minHeap.isEmpty()) return maxHeap.peek();

	  if (maxHeap.size() == minHeap.size()) {
	    return (minHeap.peek() + maxHeap.peek()) / 2;
	  } else if (maxHeap.size() > minHeap.size()) {
	    return maxHeap.peek();
	  } else {
	    return minHeap.peek();
	  }
	}
	
private class MaxHeapComparator implements Comparator<Integer> {

@Override
public int compare(Integer o1, Integer o2) {
	// TODO Auto-generated method stub
	return o2.compareTo(o1);
}
}

public static void main(String[] args) {
MedianOfIntegerStream streamMedian = new MedianOfIntegerStream();

streamMedian.addNumberToStream(1);
System.out.println(streamMedian.getMedian()); // should be 1

streamMedian.addNumberToStream(5);
streamMedian.addNumberToStream(10);
streamMedian.addNumberToStream(12);
streamMedian.addNumberToStream(2);
System.out.println(streamMedian.getMedian()); // should be 5

streamMedian.addNumberToStream(3);
streamMedian.addNumberToStream(8);
streamMedian.addNumberToStream(9);
System.out.println(streamMedian.getMedian()); // should be 6.5
}
}