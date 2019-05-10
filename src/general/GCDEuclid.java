package general;
public class GCDEuclid {

	/**
	 * @param args
	 */
	public static int  gcdRecurse(int a,int b){
		if(b==0)
			return a;
		else return gcdRecurse(b,a%b);
		
	}
	public static int gcdIterative(int a,int b){
		while(b!=0){
			int t = a%b;
			a = b;
			b = t;
		}
		return a;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
