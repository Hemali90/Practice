package general;import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String");
		char[] text = scan.nextLine().toCharArray();
		int end = text.length;
		int start=0;
		//Reverse the entire string 
		int s=0;
		for(int i=0;i<text.length/2;i++){
			char temp=text[i];
			text[i]=text[end-1];
			text[end-1]=temp;
			end=end-1;
		}
		for(int i=0;i<text.length;i++){
			//int s=i,e=i;
			if(text[i]==' '|| i==text.length-1){
				int e = text[i] == ' ' ? i - 1 : i;
			while(s<e){
				char temp=text[s];
				text[s]=text[e];
				text[e]=temp;
				e--;
				s++;
			}
			s=i+1;
			}
		}
		

		/*for (int i = 0; i < text.length; i++) {
			if (text[i] == ' ' || i == text.length - 1) {
				int tempI = text[i] == ' ' ? i - 1 : i;
				while (tempI > start) {
					char temp = text[start];
					text[start] = text[tempI];
					text[tempI] = temp;
					start++;
					tempI--;
				}
				start = i + 1;
			}
		}
		for (int i = 0; i < text.length / 2; i++) {
			char temp = text[i];
			text[i] = text[text.length - i - 1];
			text[text.length - i - 1] = temp;
		}*/

		System.out.println(text);
	}
}
