package general;import java.util.Stack;


public class InfixToPostfix {
	public static int precedence(char c){
		int preced=0;
		if(c=='+' || c=='-'){
			preced=1;
		}
		else if(c=='*'){
			preced=2;
		}
		else if(c=='/'){
			preced=3;
		}
		return preced; 
	}
	public static boolean isHigherPrecedence(char a,char b){
		return (precedence(a) > precedence(b));
			
	}
public void infixToPostfix(String str){
	Stack<Character> opstack=new Stack<Character>();
	char exp[]=str.toCharArray();
	StringBuffer postexp=new StringBuffer();
	for(int i=0;i<exp.length;i++){
		if(isOperand(exp[i])){
			postexp.append(exp[i]);
		}
		if(isOperator(exp[i])){
			char c='0';
			if(!opstack.isEmpty()){
				c=opstack.peek();
			}
			if(isHigherPrecedence(exp[i],c)){
				while(!opstack.isEmpty()){
					postexp.append(opstack.pop());
				}
			}
			else{
				opstack.push(exp[i]);
			}
		}
	}
	while(!opstack.isEmpty()){
		postexp.append(opstack.pop());
	}
	
	System.out.println(postexp);
}

public boolean isOperand(char c){
	int i=Character.getNumericValue(c);
	if(i>0 && i<9){
		return true;
	}
	return false;	
}
public boolean isOperator(char c){
	if(c=='*'||c=='+'|| c=='-'|| c=='/') return true;
	return false;
}

}
