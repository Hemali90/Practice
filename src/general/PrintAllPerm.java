package general;
public class PrintAllPerm {

	/**
	 * @param args
	 */
	public static void printPerm(char s[],int k,int n){
		if(k==n){
			System.out.println(s);
		}else{
			//char a[]=s.toCharArray();
			for(int i=k;i<n;i++){
				/*
				 * swap(s[k],s[i]);
				 * printPerm(s,k+1,n);
				 * swap(s[k],s[i]);
				 */
				char t=s[i];
				s[i]=s[k];
				s[k]=t;
				printPerm(s,k+1,n);
				t=s[i];
				s[i]=s[k];
				s[k]=t;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=new String("abcd");
		char a[]=s.toCharArray();
 printPerm(a,0,s.length());
	}

}
