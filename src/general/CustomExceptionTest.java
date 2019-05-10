package general;
class CustomException extends Exception {
	String str;
CustomException(String s){
	str=s;
}
public String toString(){
return ("Output string "+str);
}
}
public class CustomExceptionTest{
	public static void main(String args[]) throws Exception{
		try{
			throw new CustomException("Error");
		}
		catch(CustomException exp){
			System.out.println("Exception");
			System.out.println(exp);
		}
		finally{
			System.out.println("Finally block");
		}
	}
}