package general;
public class ArrayLeader {

	/**
	 *Find all the Leaders in an Array. 
An Array element is Leader if all the elements following that array element is lesser than or equal to it. 
Ex: Arr = {13, 17, 5, 4, 6, 2} 
O/p: 17, 6, 2
	 */
	public void FindLeader ( int Arr[]) {
		int ArrSize=Arr.length;
		int max = Arr[ArrSize-1] ;
		for ( int i = ArrSize-1; i >= 0; i-- ) {
			if ( Arr[i] >= max ) {
				System.out.print(Arr[i] + " ") ;
				max = Arr[i] ;
			}
		}
		System.out.println("\n");
	}
	
	public void findSpecial(int Arr[]){
		int max=Integer.MIN_VALUE;
		for(int i=1;i<Arr.length-1;i++){
			if(Arr[i-1]<= Arr[i] && Arr[i+1]>=Arr[i]){
				if(Arr[i]>=max){
					max=Arr[i];
				}
				System.out.println(Arr[i]);
			}
		}
		System.out.println("Max "+max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,6,7,8,9} ;
		ArrayLeader al=new ArrayLeader();
		al.findSpecial(arr);
	}

}
