package general;
public class RotateMatrix {

	/**
	 * @param arg
	 */
	public static void rotate(int a[][],int n){
		
		for(int slow=0;slow<n/2;slow++){
			for(int fast=slow;fast<n-slow-1;fast++){
				int temp=a[slow][fast];
				a[slow][fast]=a[n-fast-1][slow];
				a[n-fast-1][slow]=a[n-slow-1][n-fast-1];
				a[n-slow-1][n-fast-1]=a[fast][n-slow-1];
				a[fast][n-slow-1]=temp;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * {{00,01,02,03}
	 *  {10,11,12,13}
	 *  {20,21,22,23}
	 *  {30,31,32,33}}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param a
	 * @param n
	 */
	public static void rotateCounter(int a[][],int n){
		for(int slow=0;slow<n/2;slow++){
			for(int fast=slow;fast<n-slow-1;fast++){
				int temp=a[slow][fast];
				a[slow][fast]=a[fast][n-slow-1];
				a[fast][n-slow-1]=a[n-slow-1][n-fast-1];
				a[n-slow-1][n-fast-1]=a[n-fast-1][slow];
				a[n-fast-1][slow]=temp;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		rotate(a,3);
		System.out.println();
		rotateCounter(a,3);
		
	}

}
