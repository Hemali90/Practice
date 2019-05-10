package general;import java.util.ArrayList;

public class RadixSort {

	public void radixSort(int arr[]){
		int exp = 1;//10^0;
		/*for(int i =0; i < maxDigits; i++)*/
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		
		while(max/exp>0){
			ArrayList<Integer> bucketList[] = new ArrayList[10];
			for(int k=0; k < 10; k++){
				bucketList[k] = new ArrayList<Integer>();
			}
			for(int j =0; j < arr.length; j++){
				int number = (arr[j]/exp)%10;
				bucketList[number].add(arr[j]);
			}
			exp *= 10;
			int index =0;
			for(int k=0; k < 10; k++){
				for(int num: bucketList[k]){
					arr[index] = num;
					index++;
				}
			}
		}

		System.out.println("Sorted numbers");
		for(int i =0; i < arr.length; i++){
			System.out.print(arr[i] +" ");
		}
	}

	public static void main(String[] argv){
		
		int arr[] = {1,4,2,11,12,990,2201,9,3,5,10,8,20};
		//System.out.println(("substringbig").contains("substring"));
		new RadixSort().radixSort(arr);
	}
}