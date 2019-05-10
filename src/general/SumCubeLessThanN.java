package general;import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
 * Write a function that would print all positive numbers smaller than n that can be expressed 
 * as the sum of two cubes in two different ways. Bonus: calculate the complexity of that function. 
	For example, 1729 is one such number because 1729 = 1^3 + 12^3 = 9^3 + 10^3.
 */
public class SumCubeLessThanN {

	public static void sendSpecialNum(int num){
		int cuberoot=(int)Math.cbrt(num);
		Set hset=new HashSet<Integer>();
		ArrayList<Integer> l=new ArrayList<Integer>();
		for(int i=1;i<=cuberoot;i++){
			for(int j=i; i*i*i + j*j*j <= num;j++){
				int var=i*i*i + j*j*j;
				if(var < num && hset.contains(var)){
					l.add(var);
				}
				else{
					hset.add(var);
				}
			}
		}
		
		for(Integer i:l){
			System.out.println(i);
		}
	}

	public static void main(String[] argv){
		sendSpecialNum(10000);
			


	}
}