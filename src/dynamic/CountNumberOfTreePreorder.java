package dynamic;

public class CountNumberOfTreePreorder {
	 public int count(int num){
	        if(num == 0){
	            return 0;
	        }
	        int T[] = new int[num+1];
	        T[0] = 1;
	        T[1] = 1;
	        for(int i=2; i <= num; i++){
	            int sum = 0;
	            for(int k=0; k < i; k++){
	                sum += T[k]*T[i-k-1];
	            }
	            T[i] = sum;
	        }
	        return T[num];
	    }
	    
	    public int countRec(int num){
	        if(num == 0 || num ==1){
	            return 1;
	        }
	        int sum = 0;
	        for(int i=1; i <= num; i++){
	            sum += countRec(i-1)*countRec(num-i);
	        }
	        return sum;
	    }
	    
	    public static void main(String args[]){
	        CountNumberOfTreePreorder cn = new CountNumberOfTreePreorder();
	        System.out.println(cn.count(3));
	        System.out.println(cn.count(4));
	        System.out.println(cn.count(5));
	        System.out.println(cn.countRec(3));
	        System.out.println(cn.countRec(4));
	        System.out.println(cn.countRec(5));
	    }
}
