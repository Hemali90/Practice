package general;import java.util.Scanner;


public class IsSubStringRotational {
private static Scanner sc;

public boolean isSubStringRotation(String s1,String s2){
	int len=s1.length();
	if(len==s2.length() && len>0)
	{
		String s1s1=s1+s1;
		return s1s1.contains(s2);
	}
	return false;
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubStringRotational is=new IsSubStringRotational();
		sc = new Scanner(System.in);
		System.out.println("Enter the string 1");
		String str1=sc.next();
		System.out.println("Enter the string 2");
		String str2=sc.next();
		
		if(is.isSubStringRotation(str1, str2)){
			System.out.println("Is substring");
		}
		else{
			System.out.println("Not substring");
		}
		
	}

}
