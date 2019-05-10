package general;
public class MaxSubarray {
	
	//bruteforce approach O(n^3)
	public void subarray(int array[]){
		int max=Integer.MIN_VALUE;
		int count=0;
		int n=array.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<(n-i);j++){
				 count=0;
				for(int k=j,ct=0;ct<=i;k++,ct++){
					count+=array[k];
				}
				if(max<count){max=count;}
				
			}
		}
		System.out.println("Max"+max);
	}
	
	//kadane's algorithm O(n)
	public void maxsum(int arr[]){
		int n=arr.length;
		int ans=0;
		int sum=0;
		for(int i=0;i<n;i++){
			if((sum+arr[i])>0)
				sum=sum+arr[i];
			else
				sum=0;
			if(sum>ans) ans=sum;
		}
		System.out.println("Result"+ans);
	}

	public static void main(String[] args) {
		
int arr[]={2,-11,4,-20,13,7,11,-20,-11,-3};
MaxSubarray sb=new MaxSubarray();
sb.subarray(arr);
sb.maxsum(arr);
	}

}
