package general;
public class CicularQueuee {
	private final int SIZE = 10;
	private int[] arr = new int[SIZE];
	private int head = -1;
	private int tail = 0;
	
	public void enqueue(int n){
		if(head == tail){
			System.out.println("Queue is Full");
		} else {
			synchronized (this){
				if(head == -1) head = 0;
				arr[tail] = n;
				tail=(tail+1)%SIZE;
			}
		}
	}
	public int dequeue() throws Exception{
		if(head == -1){
			throw new Exception("Queue is Empty");
		} else {
			int n;
			synchronized (this) {
				n = arr[head];
				head=(head+1)%SIZE;
				if(head == tail){
					head = -1;
					tail = 0;
				}
			}
			return n;
		}
	}
}
