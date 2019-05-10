package general;import java.util.Scanner;
import java.util.Stack;


public class ParanthCheck {
	Stack<Character> st=new Stack<Character>();
public boolean check(String str){
	for(int i=0;i<str.length();i++){
		char ch=str.charAt(i);
		if(ch=='('|| ch=='{' || ch=='['){
			st.push(ch);
		}
		else if(ch==')'){
			if(st.isEmpty()){return false;}
			Character c=st.pop();
			if( c!='('){
				return false;
			}
		}
		else if(ch==']'){
			if(st.isEmpty()){return false;}
			Character c=st.pop();
			if(c!='['){
				return false;
			}
		}
		else if(ch=='}'){
			if(st.isEmpty()){return false;}
			Character c=st.pop();
			if(c!='{'){
				return false;
			}
		}
		
	}
	if(!st.isEmpty()){return false;}
	return true;
}
	public static void main(String[] args) {
		
		String ck;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string with paranthesis");
		ck=sc.next();
		ParanthCheck pc=new ParanthCheck();
		System.out.println("Balanced paranthesis? "+pc.check(ck));
        sc.close();
	}

}
