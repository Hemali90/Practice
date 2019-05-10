package general;
public class BitManipulation {
	
	public void floattobinary(String str){
		//float f=Float.parseFloat(str);
		String st[]=str.split("\\.");
		String left=st[0];
		String right=st[1];
		System.out.println(left+" "+ right);
		int lefti=Integer.parseInt(left);
		//System.out.print(Integer.toBinaryString(lefti)+".");
		StringBuffer sb=new StringBuffer("");
		while(lefti>0){
			int bit=lefti%2;
			sb.append(Integer.toString(bit));
			lefti=lefti/2;
		}
		sb=sb.reverse();
		System.out.println(sb); 
		//int righti=Double.parseDouble(right);
		int temp=Integer.parseInt(right);
		String s=Integer.toString(temp);
		String sbr="0."+s;
		System.out.println(sbr);
		double dob=Double.parseDouble(sbr);
		System.out.println(dob);
		sb.append(".");
		//double dob1=1;
		while(dob>0){
			if(sb.length()>=32){System.out.println("Error");return;}
			if(dob==1.0){
				sb.insert(sb.length(), (int)dob);
				//sb.append((int)dob);
				break;
			}
			double r=dob*2;
			if(r>1){
				sb.insert(sb.length(),1);
				//sb.append(1);
				dob=r-1;
			}
			else{
				sb.insert(sb.length(),0);
				//sb.append(0);
				dob=r;
			}
			
			
			
	}
		System.out.println(sb);
		
		
	}
	
	//increment number without using +
public void increment(int a){
	a = ~a ;
	System.out.println(-a);
}
int increment2(int n) {
	int i = 1;
	System.out.println("i&n "+ (i&n));
	while((i&n)==1) {
		n = n&(~i);
		i <<= 1;
	}
	return n|i;
}
public void bit(int m,int n,int i,int j){
	System.out.println("M= "+Integer.toBinaryString(m));
	System.out.println("N= "+Integer.toBinaryString(n));
	int max=~0;
	int nshift=n<<i;
	int jshift=max<<j;
	int ishift=max<<i;
	int pad=~(ishift^jshift);  //Padding in the form:111000011
	//anding M with pad bits will make the bits from 2 to 6 0
	//and then we can or with the shifted n
	System.out.println("Pad= "+Integer.toBinaryString(pad));
	
	int result=(pad&m)|(nshift);
	System.out.println("Result= "+Integer.toBinaryString(result));
	
}


/**
 * count set bits in a number
 * @param i
 * @return
 */
public static int countBits(int i){
	int count = 0;
	while(i != 0){
		
	if(( i & 1) == 1){
		count++;
	}
	i = i>>>1;
	}
	
	return count;
}

/**
 * 
 */
public static void twosComplement(int i){
	int complement = (~i);
	System.out.println(complement);
}
/**
 * 
 * @param num
 */
public static void isPalindrome(int i){

	StringBuilder reverse = new StringBuilder();
	while(i != 0){
		if(( i & 1) == 1){
			reverse.append("1");
		} else {
			reverse.append("0");
		}
		i = i>>>1;	
	}
	
	
}

//Given a number,print the next smallest and next largest number that have the 
//same number of 1 bits in their binary representation
public void nextsmallarge(int num){
	String str=Integer.toBinaryString(num);
	int countorig=0;
    for(int i=0;i<str.length();i++){
    	if(str.charAt(i)=='1'){
    		countorig++;
    	}
    }
    int large=num;
    while(true){
    large++;
    String l=Integer.toBinaryString(large);
    int countlarge=0;
    for(int i=0;i<l.length();i++){
    	if(l.charAt(i)=='1'){
    		countlarge++;
    	}
    }
    if(countorig==countlarge){break;}
    }
    System.out.println("Larger than "+num+" ="+large);
    int flag=0;
    int small=num;
    while(true){
    	if(small==0){flag=1;System.out.println("No number available");break;}
    	small--;
    	 String l=Integer.toBinaryString(small);
    	    int countsmall=0;
    	    for(int i=0;i<l.length();i++){
    	    	if(l.charAt(i)=='1'){
    	    		countsmall++;
    	    	}
    	    }
    	    if(countorig==countsmall){break;}	
    }
   if(flag==0) System.out.println("smaller than"+num+"="+small);
    
}
	public static void main(String[] args) {
		
		
		BitManipulation b=new BitManipulation();
		twosComplement(-2);
		/*b.bit(210, 12, 2, 6);
	    String str="14.50";
	    b.floattobinary(str);
	    b.nextsmallarge(9);
	    System.out.println("Increment number "+b.increment2(10));
	    b.increment(2);
	    	int n=9;
//n&(n-1) checks whether n is power of 2
	    	if(((n)&(n-1))==0){System.out.println("True");}
	    		else{
	    			System.out.println("False");

//Difference in bits of two numbers if given by its xor
	    			int xor=31^14;
	    			int ct=0;
	    			String ss=Integer.toBinaryString(xor);
	    			for(int i=0;i<ss.length();i++){
	    				if(ss.charAt(i)=='1'){
	    					ct++;	
	    				}
	    			}
	    			System.out.println(ct);
	    		}*/
}
}


