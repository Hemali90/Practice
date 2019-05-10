package general;public class HeapSort{
	public static int left(int i){
		if(i==0){
			return 1;
		}
		return 2*i+1;
	}
	public static int right(int i){
		if(i==0){
			return 2;
		}
		return 2*i+2;
	}
	
	public static void max_heapify(int[] a,int length,int i){
		int l=left(i);
		int r=right(i);
		int largest;
		if(l<length && a[l]>a[i]){
			largest=l;
		}
		else{
			largest=i;
		}
		if(r<length && a[r]> a[i]){
			largest=r;
		}
		if(largest!=i){
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			max_heapify(a,length,largest);
		}
		
	}
	
	public static void build_max_heap(int[] a){
		for(int i=(int)(a.length/2)-1; i>=0;i--){
			max_heapify(a,a.length,i);
		}
	}
	public static void heapsort(int a[]){
		build_max_heap(a);
		int length=a.length;
		for(int i=a.length-1;i>=1;i--){
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			//System.out.println(a[i]);
			length=length-1;
			max_heapify(a,length,0);
		}
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	public static void main(String args[]){
		int a[]={20,21,5,6,7,11};
		heapsort(a);
	}
}