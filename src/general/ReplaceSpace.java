package general;import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReplaceSpace {
	private static Scanner sc;

	public char[] replaceSpace(char str[]){
		int space=0,newlength,i=0;
		
		for(i=0;i<str.length;i++){
			if(str[i]==' '){
				space=space+1;
			}
		}
		newlength=space*2+str.length;
		str[newlength]='\0';
		for(i=0;i<str.length;i++){
			if(str[i]==' '){
				str[newlength-1]='0';
				str[newlength-2]='2';
				str[newlength-3]='%';
				newlength=newlength-3;
			}
			else{
				str[newlength-1]=str[i];
				newlength=newlength-1;
			}
		}
		return str;
	}
	public void replace(char str[]){
		int space=0;
		for(int i=0;i<str.hashCode();i++){
			if(str[i]==' '){
				space=space+1;
			}
		}
		int newlength=str.length+2*space;
		
	}
	public static void regexreplace(String toreplace){
		Pattern pat=Pattern.compile("\\s+");
		Matcher match=pat.matcher(toreplace.trim());
		System.out.println("Regex replace "+match.replaceAll("%02"));
	}
	public static void main(String args[]){
		
		sc = new Scanner(System.in);
	      System.out.println("Enter  string");
	      String s1=sc.nextLine();
	      System.out.print(s1.replaceAll("\\s+", "%20"));
	      char[] str=s1.toCharArray();
	       
	      //ReplaceSpace sp=new ReplaceSpace();
	      //regexreplace(s1);
	      
	}

}
