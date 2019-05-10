package general;import java.util.Stack;


public class QueueUsingStacks {
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	public void add (Integer i){
		s1.push(i);
	}
	public int remove(){
		if (!s2.isEmpty()){
			int value=s2.pop();
			return value;
		}
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStacks q=new QueueUsingStacks();
		q.add(3);
		q.add(8);
		q.add(6);
		q.add(2);
		q.add(1);
		q.add(9);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		
	}

}
