package general;
public class GenericClassEx<E>{

public static <E extends Comparable<E>>E max(E[] a){
	int n=a.length;
	E max=a[0];
	for(int i=0;i<n;i++){
		if(a[i].compareTo(max)>0){
			max=a[i];
		}
	}
	return max; 
}
	public static void main(String args[]){
		Integer a[]={20,2211,2110,65,10,11,19,21,214,102,205,619};
		Double d[]={1.2,3.44,4.77,0.99};
		Integer max=max(a);
		System.out.println(max);
		Double md=max(d);
		System.out.println(md);
	}
}