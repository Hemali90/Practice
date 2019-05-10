package general;import java.util.Scanner;


public class IsUniqueString {
	private static Scanner sc;

	public boolean isUnique(String s)
	{
		boolean verify[]=new boolean[256];
		for(int i=0;i<s.length();i++)
		{
			int val=s.charAt(i);
			if(verify[val]) return false;
			verify[val]=true;
	     
		}
		return true;
	}

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.next();
		IsUniqueString check=new IsUniqueString();
		if(check.isUnique(str)) 
			{
			System.out.println("String is unique");
			}
		else
		{
			System.out.println("String is not unique");
		}
		

	}

}
