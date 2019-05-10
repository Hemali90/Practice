package general;
public class MaximumWithoutIfElse {

	/**
	 * @param args
	 */
	public static void max(int a,int b){
		/*
		int diff = (int)(a-b) >> 31;
		System.out.println("Diff : "+diff);
		int sum = (1-diff)*a + (diff*b);
		System.out.println(" Max of a and b is : "+a+" "+b+" "+sum);*/
			int z = a - b;
		   int i  = (z  >>  31)  &  0x1;
		   int  max  =  a - i  *  z;
		   System.out.println(" Max of a and b is : "+a+" "+b+" "+max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
max(8,9);
	}

}
