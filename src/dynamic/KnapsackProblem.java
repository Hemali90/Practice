package dynamic;

public class KnapsackProblem {

	/** o-1 knapsack
	 * Recursive O(2^n)
	 * @param W
	 * @param wt
	 * @param val
	 * @param n
	 * @return
	 */
	 // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
       // Base Case 
   if (n == 0 || W == 0) 
       return 0; 
      
   // If weight of the nth item is more than Knapsack capacity W, then 
   // this item cannot be included in the optimal solution 
   if (wt[n-1] > W) 
      return knapSack(W, wt, val, n-1); 
      
   // Return the maximum of two cases:  
   // (1) nth item included  
   // (2) not included 
   else return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
                    knapSack(W, wt, val, n-1) 
                     ); 
     }
    
    
    /** 0- 1 knapsack
     * Dynamic O(n^2)
     * @param val
     * @param wt
     * @param W
     * @return
     */
	public int calculate(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        
        for(int i=0; i <= val.length; i++){
            for(int w=0; w <= W; w++){
                if(i == 0 || w == 0){
                    K[i][w] = 0;
                    continue;
                }
                //available weight is gte weight of current item
                if(w >= wt[i-1]){
                	// Return the maximum of two cases:  
                	   // (1) nth item included  
                	   // (2) not included 
                    K[i][w] = Math.max(K[i-1][w], K[i-1][w-wt[i-1]] + val[i-1]);
                }else{
                	//this item cannot be included in the optimal solution
                    K[i][w] = K[i-1][w];
                }
            }
        }
        return K[val.length][W];
    }
	
	/*
	 * Below method is similar to rod-cutting example
	 */
	public static int calculateKnapSack(int val[], int wt[], int W){
		int K[]=new int[W];
		
//		for(int i=0;i<W;i++){
//			K[i]=0;
//		}
		
		for(int i=0;i<val.length;i++){
			for(int j=i;j< W; j++){
				if((j-wt[i]) > 0)
				K[j]=Math.max(K[j], K[j-wt[i]]+val[i]);
				
			}
		}
		
		return K[W-1];
	}
    
    public static void main(String args[]){
        KnapsackProblem k = new KnapsackProblem();
        int val[] = {60,20,15,30};
        int wt[] = {4,2,3,5};
        int r = k.calculate(val, wt, 8);
        System.out.print(r);
        
        System.out.println("\n"+calculateKnapSack(val, wt, 8) );
    }

}
