package general;
public class CountBinStringWithoutCons1 {
//It is basically fibbonacci series
	public int count(int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 2;
		}
		if(n==2){
			return 3;
		}
		return count(n-1)+count(n-2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
