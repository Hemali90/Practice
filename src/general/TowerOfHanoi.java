package general;
/*For Tower of hanoi 
 * for n=2
 * Move from A to B
 * Move from A to C
 * Move from B to C
 * Assume that the first and last step is recursive
 * while the middle step is the same 
 * move n-1 discs from A to B 
 * and then move the last disc from A to C
 * and then move n-1 discs from B to C
 * */
import java.util.Scanner;


public class TowerOfHanoi {
private static Scanner sc;
public void solve(int n,String start,String aux,String last){
	if(n==1){
		System.out.println("Move "+start+" from "+last );
	}
	else{
		solve(n-1,start,last,aux);
		System.out.println("Move "+start+" from "+last );
		solve(n-1,aux,start,last);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of towers");
		sc = new Scanner(System.in);
		int num=sc.nextInt();
		TowerOfHanoi th =new TowerOfHanoi();
		th.solve(num,"A","B","C");
	}

}
