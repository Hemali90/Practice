package general;import java.util.Stack;


public class MinElementStack {
	int minimum;
	Stack<Integer> s3=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	MinElementStack(){
		minimum=Integer.MAX_VALUE;
	}
	public void push(int value){
		if(value<=min()){
			s2.push(value);
		}
		s3.push(value);
	}
	public Integer pop()
	{
		if(s3.peek()==s2.peek()){
			s2.pop();
		}
		int value=s3.pop();
		return value;
	}
	public int min() {
		if (s2.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else{
			return s2.peek();
		}
	}
	public boolean isEmpty(){
		return s3.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    MinElementStack s=new MinElementStack();
    s.push(5);
    s.push(6);
    s.push(1);
    s.push(2);
    s.push(6);  
    s.push(9);
    s.push(11);
    System.out.println("Minimum "+s.min());
    while(!s.isEmpty()){
    	System.out.println(s.pop());
    }
   
	}

}
