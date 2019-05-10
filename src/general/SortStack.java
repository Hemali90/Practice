package general;import java.util.HashMap;
import java.util.Random;
import java.util.Stack;


public class SortStack {



 public void sort(Stack<Integer> s){
	
	 Stack<Integer> r=new Stack<Integer>();
	 
	 while(!s.isEmpty()){
		 int tmp=s.pop();
		 while(!r.isEmpty() && r.peek()>tmp){
			 s.push(r.pop());
		 }
		 r.push(tmp);
	 }
	 System.out.println("Sorted stack");
	 while(!r.isEmpty()){
		 System.out.println(r.pop());
	 }
 }
 
 Stack<Integer> r=new Stack<Integer>();
 public void recursiveReverese(Stack<Integer> s){
//Stack<Integer> r=new Stack<Integer>();
	// Stack<Integer> rev;
	 if(s.isEmpty()){
		 printStack(r);
		 return ;
	 }
	 else{
		 //System.out.println(s.pop());
		 r.push(s.pop());
		 recursiveReverese(s);
	 }
	
 }
 public void printStack(Stack<Integer> s){
	 while(!s.isEmpty()){
		 System.out.println(s.pop());
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     SortStack ss=new SortStack();
   System.out.println((new Random().nextInt(10-4))+5 );
     Stack<Integer> s=new Stack<Integer>();
     s.push(5);
     s.push(4);
     s.push(8);
     s.push(9);
     s.push(1);
     s.push(2);
    /* while(!s.isEmpty()){
    	 System.out.println("Element"+s.pop());
     }*/
     ss.recursiveReverese(s);
    //Stack<Integer> rstack=ss.recursiveReverese(s);
    /*while(!rstack.isEmpty()){
    	System.out.println(rstack.pop());
    }*/
    
     //ss.sort(s);
	}

}
