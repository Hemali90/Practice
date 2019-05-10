
package general;
/*anagram is whether a string is having same as the other.Except that the order can be different.
 * Eg.cat and act*/
//import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*eg:cat and act ,hello and elloh*/
public class AnagramsStr {
    private static Scanner sc;
    public boolean isAnagram(String s1,String s2){
    	
    	char st1[]=s1.toCharArray();
    	
    	char st2[]=s2.toCharArray();
    	Arrays.sort(st1);
    	Arrays.sort(st2);
    	if(st1.length!=st2.length){
    		return false;
    	}
    	for(int i=0;i<st1.length;i++){
    		if(st1[i]!=st2[i]){
    			return false;
    		}
    	}
    	return true;
    }
	/*public boolean isAnagram(String str1,String str2){
        
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();
       LinkedList<Character> chl1=new LinkedList<Character>();
       for(char c:ch2)
       {
    	   chl1.add(new Character(c));
       }
       for(char ch:ch1){
    	   if(!chl1.contains(ch))
    		   {return false;}
    	   else{
    		   chl1.removeFirstOccurrence(ch);
    	   }
       }
       if(!chl1.isEmpty()){return false;}
       return true;
       
    	
    }*/
    public boolean checkAna(String s1,String s2){
    	int check[]=new int[256];
    	for(int i=0;i<s1.length();i++){
    		check[s1.charAt(i)]++;
    	}
    	for(int i=0;i<s2.length();i++){
    		check[s2.charAt(i)]++;
    	}
    	for(int i=0;i<256;i++){
    		if(check[i]%2==1){
    			return false;
    		}
    	}
    	return true;
    	
    }
	public static void main(String[] args) {
		sc = new Scanner(System.in);
      System.out.println("Enter first string");
      String s1=sc.next();
      System.out.println("Enter second string");
      String s2=sc.next();
      AnagramsStr a=new AnagramsStr();
      if(a.isAnagram(s1,s2)){System.out.println("True");}
      else{System.out.println("False");}
      System.out.println("Second check " +a.checkAna(s1,s2));
      
	}

}
