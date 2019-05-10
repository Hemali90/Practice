package general;import java.util.Scanner;


public class Pangram {
	
	public static boolean isPangram(String s){
        for (char a = 'A'; a <= 'Z'; a++)
        {
            if ((s.indexOf(a) < 0) || (s.indexOf((char)(a + 32)) < 0))
        {
            return false;
        }
       
        }
       return true;
   }

   public static void main(String[] args) {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter");
       String pangram=sc.next();
       if(isPangram(pangram)){
           System.out.println("pangram");
       }
       else{
           System.out.println("not pangram");
       }
   }
}
