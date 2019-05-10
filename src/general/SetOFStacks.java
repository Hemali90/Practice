package general;import java.util.ArrayList;
import java.util.Stack;

class StackSet{
	ArrayList<Stack<Integer>> set=new ArrayList<>();
	int capacity=10;
	static int size=0;
	public void push(int value){
		if(set.isEmpty()){
			Stack<Integer> stack=new Stack<>();
			stack.push(value);
			set.add(stack);
		}
		else{
			Stack<Integer> stack=set.remove(set.size()-1);
			if(stack.size()!=capacity){
				stack.push(value);
				set.add(stack);
			}
			else{
				set.add(stack);
				Stack<Integer> st=new Stack<Integer>();
				st.push(value);
				set.add(st);
			}
			
		}
	}
	
	public Integer pop(){
		if(set.isEmpty()){
			System.out.println("Empty stacks");
			return -1;
		}
		else {
			Stack<Integer> stack=set.get(set.size()-1);
			if(stack.size()==0){
				set.remove(set.size()-1);
				if(set.size()==0){
					System.out.println("Empty stacks");
					return -1;	
				}
				else{
					Stack<Integer> st=set.get(set.size()-1);
					Integer value=st.pop();
					return value;
				}
			}
			else{
				return stack.pop();
			}
		}
	}
}

public class SetOFStacks{
	
	public static void main(String args[]){
		StackSet ss=new StackSet();
		ss.push(10);
		ss.push(11);
		ss.push(12);
		ss.push(13);
		ss.push(14);
		ss.push(15);
		ss.push(16);
		ss.push(17);
		ss.push(18);
		ss.push(19);
		ss.push(20);
		ss.push(21);
		ss.push(22);
		ss.push(23);
		ss.push(24);
		ss.push(25);
		
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());		
		System.out.println(ss.pop());	
		
		
			
		
		
		
		
		
	}
}

