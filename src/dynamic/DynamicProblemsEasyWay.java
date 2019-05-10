package dynamic;

import java.util.Arrays;

public class DynamicProblemsEasyWay {
	/*
	 * Knapsack 0-1 : maximum value item
	 */

	public static int calculateKnapSack(int val[], int wt[], int W){
		int K[]=new int[W];
		for(int i=0;i<val.length;i++){
			for(int j=i;j< W; j++){
				if((j-wt[i]) > 0)
				K[j]=Math.max(K[j], K[j-wt[i]]+val[i]);	
			}
		}
		return K[W-1];
	}
	
	/*
	 * Rod cutting - maximum price cuts
	 */
	 public int maxValueRodCutting(int price[]){
	        int max[] = new int[price.length+1];
	        for(int i=1; i <= price.length; i++){
	            for(int j=i; j <= price.length; j++){
	                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
	            }
	        }
	        return max[price.length];
	    }
	 /*
	  * Coins change: optimal number of coins to obtain given sum 
	  */
	 
	 public int minCoinChangeInfinteSupply(int total, int arr[]){
	        int temp[] = new int[total+1];
	        temp[0] = 0;
	        for(int i=1; i <= total; i++){
	            temp[i] = Integer.MAX_VALUE;
	        }
	        for(int i=0; i < arr.length; i++){
	            for(int j=1; j <= total; j++){
	                if(j - arr[i] >= 0){
	                    //be careful here. Max_val + 1 can result in very small neg number.
	                    temp[j] = Math.min(temp[j], temp[j-arr[i]] +1);
	                }
	            }
	        }
	        return temp[total];
	    }
	 /*
	  * Coin change: number of ways to obtain the given total 
	  */
	 public int numberOfSolutionsOnSpace(int total, int arr[]){
	        
	        int temp[] = new int[total+1];
	        
	        temp[0] = 1;
	        for(int i=0; i < arr.length; i++){
	            for(int j=1; j <= total ; j++){
	                if(j - arr[i] >= 0){
	                	temp[j]= temp[j] + temp[j-arr[i]];
	                }
	            }
	        }
	        return temp[total];
	    }
	 /*
	  * Edit Distance
	  */
	 public int dynamicEditDistance(char[] str1, char[] str2){
	        int temp[][] = new int[str1.length+1][str2.length+1];
	        
	        for(int i=0; i < temp[0].length; i++){
	            temp[0][i] = i;
	        }
	        
	        for(int i=0; i < temp.length; i++){
	            temp[i][0] = i;
	        }
	        
	        for(int i=1;i <=str1.length; i++){
	            for(int j=1; j <= str2.length; j++){
	                if(str1[i-1] == str2[j-1]){
	                    temp[i][j] = temp[i-1][j-1];
	                }else{
	                    temp[i][j] = min(temp[i-1][j-1] + 1,temp[i-1][j] + 1 /*(EDIT_COST)*/,temp[i][j-1] +1 /*(EDIT_COST)*/);
	                }
	            }
	        }
	        return temp[str1.length][str2.length];  
	    }
	 private int min(int a,int b, int c){
	        int l = Math.min(a, b);
	        return Math.min(l, c);
	    }
	 /**
	  * Longest Common Subsequence
	  * 
	  */
	 
	 public int lcsDynamic(char str1[],char str2[]){
		    
	        int temp[][] = new int[str1.length + 1][str2.length + 1];
	        int max = 0;
	        for(int i=1; i < temp.length; i++){
	            for(int j=1; j < temp[i].length; j++){
	                if(str1[i-1] == str2[j-1]) {
	                    temp[i][j] = temp[i - 1][j - 1] + 1;
	                }
	                else
	                {
	                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
	                }
	                if(temp[i][j] > max){
	                    max = temp[i][j];
	                }
	            }
	        }
	        return max;
	    
	    }
	 /**
	  * Longest Common Substring
	  */
	 public int longestCommonSubstring(char str1[], char str2[]){
	        int T[][] = new int[str1.length+1][str2.length+1];
	        
	        int max = 0;
	        for(int i=1; i <= str1.length; i++){
	            for(int j=1; j <= str2.length; j++){
	                if(str1[i-1] == str2[j-1]){
	                    T[i][j] = T[i-1][j-1] +1;
	                    if(max < T[i][j]){
	                        max = T[i][j];
	                    }
	                }
	            }
	        }
	        return max;
	    }
	 /**    Maximize Job (Similar to -> Interval sort - maximum interval (except that each interval has a cost) )
	     * Sort the jobs by finish time.
	     * For every job find the first job which does not overlap with this job
	     * and see if this job profit plus profit till last non overlapping job is greater
	     * than profit till last job.
	     * @param jobs
	     * @return
	     */
	    public int maximizeDynamic(Job[] jobs){
	        int T[] = new int[jobs.length];
	        FinishTimeComparator comparator = new FinishTimeComparator();
	        Arrays.sort(jobs, comparator);
	        
	        T[0] = jobs[0].profit;
	        for(int i=1; i < jobs.length; i++){
	            T[i] = Math.max(jobs[i].profit, T[i-1]);
	            for(int j=i-1; j >=0; j--){
	                if(jobs[j].end < jobs[i].start){
	                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
	                    //break;
	                }
	            }
	        }
	        return T[jobs.length-1];
	    }
	    
	    /**
	     * Maximum size square submatrix of all one's
	     */
	    public void printMaxSubSquare(int M[][])
		{
		  int i,j;
		  int R=M.length;
		  int C=M[0].length;
		  int S[][]=new int[R][C];
		  int max_of_s, max_i, max_j; 
		  
		  for(i = 0; i < R; i++)
		     S[i][0] = 0; 
		  for(j = 0; j < C; j++)
		     S[0][j] = 0;
		      
		  /* Construct other entries of S[][]*/
		  for(i = 1; i < R; i++)
		  {
		    for(j = 1; j < C; j++)
		    {
		      if(M[i][j] == 1) 
		        S[i][j] = Math.min(Math.min(S[i][j-1], S[i-1][j]), S[i-1][j-1]) + 1;
		      else
		        S[i][j] = 0;
		    }    
		  } 
		}
	    
	    /**
	     * Maximum size rectangular submatrix of all ones
	     */
	    public int maximum(int input[][]){
	        int temp[] = new int[input[0].length];
	        //MaximumHistogram mh = new MaximumHistogram();
	        int maxArea = 0;
	        int area = 0;
	        for(int i=0; i < input.length; i++){
	            for(int j=0; j < temp.length; j++){
	                if(input[i][j] == 0){
	                    temp[j] = 0;
	                }else{
	                    temp[j] += input[i][j];
	                }
	            }
	             
	            area = HistogramRectangle.maxHistogram(temp);
	            if(area > maxArea){
	                maxArea = area;
	            }
	        }
	        return maxArea;
	    }
	    
	    /**
	     * Minimum cost path matrix - if only down and right movement is allowed
	     */
	    public int minCost(int [][]cost,int m,int n){
	        
	        int temp[][] = new int[m+1][n+1];
	        int sum = 0;
	        for(int i=0; i <= n; i++){
	            temp[0][i] = sum + cost[0][i];
	            sum = temp[0][i];
	        }
	        sum = 0;
	        for(int i=0; i <= m; i++){
	            temp[i][0] = sum + cost[i][0];
	            sum = temp[i][0];
	        }
	        
	        for(int i=1; i <= m; i++){
	            for(int j=1; j <= n; j++){
	                temp[i][j] = cost[i][j] + Math.min(temp[i-1][j],temp[i][j-1]);
	            }
	        }
	        return temp[m][n];
	    }
	    /**
	     * Count total number of paths to reach from top-left to bottom-right in matrix
	     */
	    public int countPaths(int n,int m){
	        int T[][] = new int[n][m];
	        for(int i=0; i < n; i++){
	            T[i][0] = 1;
	        }
	        
	        for(int i=0; i < m; i++){
	            T[0][i] = 1;
	        }
	        for(int i=1; i < n; i++){
	            for(int j=1; j < m; j++){
	                T[i][j] = T[i-1][j] + T[i][j-1];
	            }
	        }
	        return T[n-1][m-1];
	    }
/**
 * Longest Palindromic Subsequence - (Triangular matrix) 
 */
	    public int calculate1(char []str){
	        int T[][] = new int[str.length][str.length];
	        for(int i=0; i < str.length; i++){
	            T[i][i] = 1;
	        }
	        for(int l = 2; l <= str.length; l++){
	            for(int i = 0; i < str.length-l + 1; i++){
	                int j = i + l - 1;
	                if(l == 2 && str[i] == str[j]){
	                    T[i][j] = 2;
	                }else if(str[i] == str[j]){
	                    T[i][j] = T[i + 1][j-1] + 2;
	                }else{
	                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
	                }
	            }
	        }
	        return T[0][str.length-1];
	    }
	    
}
