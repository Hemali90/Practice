package general;
public class SortingAlgorithms {
	public static void insertion(int arr[]){
		if(arr.length==0){System.out.println("Empty array");}
		if(arr.length==1){
			System.out.println("Element"+arr[0]);
		}
		int i,k,temp;
		for(i=1;i<arr.length;i++){
			for (k = i; k >0 && arr[k] < arr[k-1]; k--){
			temp=arr[k];
			arr[k]=arr[k-1];
			arr[k-1]=temp;	
		}
		}
		for(i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}
	 static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] >= pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	     if (index < right)
	            quickSort(arr, index, right);
	}


	public void quickS(int arr[], int left, int right) {
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	 
	      /* partition */
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	 
	      /* recursion */
	      if (left < j)
	            quickSort(arr, left, j);
	      if (i < right)
	            quickSort(arr, i, right);
	}
	static void mergesort(int arr[],int start,int mid,int end,int B[]){
		//int B[]=new int[arr.length];
		for(int i=start;i<end;i++){
			B[i]=arr[i];
		}
		int i=start;
		int j=mid+1;
		int k=start;
		while(i<mid && j<end){
			if(B[i]<=B[j]){
				arr[k]=B[i];
				i++;
				k++;
			}
			else{
				arr[k]=B[j];
				k++;
				j++;
			}
		}
		while(i<mid){
			arr[k]=B[i];
			k++;
			i++;
		}
	}
	
	static void merge(int arr[],int start,int end,int B[]){
		if(start>end){
			return;
		}
		else{
			int mid=start+end/2;
			merge(arr,start,mid,B);
			merge(arr,mid+1,end,B);
			mergesort(arr,start,mid,end,B);
		}
		
	}
	public static void selection(int arr[]){
		int n=arr.length;
		int min,index,temp;
		for(int i=0;i<n;i++){
			min=Integer.MAX_VALUE;
			index=i;
			for(int j=i;j<n;j++){
				if(arr[j]<min){
					min=arr[j];
					index=j;
				}
			}
		temp=arr[i];
		arr[i]=min;
		arr[index]=temp;
		}
		int i;
		for(i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
public static void main(String args[]){
	int arr[]={8,9,1,2,4,10,11,5,3};
	System.out.println("Insertion sort ");
	insertion(arr);
	
//	System.out.println("Selection sort ");
//	int B[]=new int[arr.length];
//	merge(arr,0,arr.length-1,B);
	
//	quickSort(arr,0,arr.length-1);
//	
//	
//	for (int i=0;i<arr.length;i++){
//		System.out.println(arr[i]);
//	}
}
}
