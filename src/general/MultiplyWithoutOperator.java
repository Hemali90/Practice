package general;
public class MultiplyWithoutOperator {
	//multiply without *
	private static int PrintSum(int a, int b, int result)
	{
	if (b == 0)
	return result;
	if ((b & 1) == 1)
	result = result + a;
	a <<= 1;
	b >>= 1;
	return PrintSum(a, b, result);
	}
	public static void multiply(int a,int b){
		int result=0;
		while(b!=0){
			if((b&1)==1){
				result=result+a;
			}
			a<<=1;
			b>>=1;
		}
		System.out.println(result);
	}
	//add without +
	int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	int AddRec(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return Add( x ^ y, (x & y) << 1);
	}
//subtract without -
	int sub(int a,int b){
		return a+~b+1;
	}
//divide without /
	static int divide(int numerator, int denominator) { 

		int mask = 1; 
		int quotient = 0; 

		while (denominator <= numerator) { 
		denominator <<= 1; 
		mask <<= 1; 
		} 

		while (mask > 1) { 
		denominator >>= 1; 
		mask >>= 1; 
		if (numerator >= denominator) { 
		numerator -= denominator; 
		quotient |= mask; 
		} 
		} 

		return quotient; 
		}


	public static void main(String args[]){
		//char s[]=new String("abcd").toCharArray();
		;
	System.out.println(PrintSum(19,5,0));
	multiply(12, 3);
	System.out.println(13+~2+1);
	String s;
	System.out.println(divide(10,5));
	}
}
