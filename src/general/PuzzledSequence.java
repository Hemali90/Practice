package general;
public class PuzzledSequence {

	public static void sequence(int n){
		StringBuilder sb=new StringBuilder("1");
		StringBuilder sb2;
		System.out.print("1"+" ");
		for(int i=2;i<=n;i++){
			char c;
			int freq=0;
			char old=sb.charAt(0);
			freq=freq+1;
			sb2=new StringBuilder();
			for(int j=1;j<sb.length();j++){
				c=sb.charAt(j);
				
				if(old!=c){
					sb2.append(Integer.toString(freq));
					sb2.append(old);
					freq=0;
				}
				freq=freq+1;
				old=c;
			}
			
			sb2.append(Integer.toString(freq));
			sb2.append(old);
			sb=sb2;
			System.out.print(sb2+" ");
		}
	}
	public static void main(String args[]){
	sequence(7);
	}
}
