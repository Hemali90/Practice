package general;
public class WildCharReplace {

	public static void print(char[] c,int i,String s){
		if(i==c.length){
			System.out.println(s);
			return;
		}
		if(c[i]=='?'){

			print(c,i+1,s+'1');
			print(c,i+1,s+'0');
		}
		else{
			print(c,i+1,s+c[i]);
		}
		
	}
	public static void main(String args[]){
	int a[]={2,9,3,4,5,10,45,12};
	print("01?00?10?".toCharArray(),0,"");
	}

}
