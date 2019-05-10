package dynamic;

public class CountPathsMatrix {
//dynamic programming
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
//recursive	
	static int  numberOfPaths(int m, int n)
	{
	   // If either given row number is first or given column number is first
	   if (m == 1 || n == 1)
	        return 0;
	 
	   // If diagonal movements are allowed then the last addition
	   // is required.
	   return  1+numberOfPaths(m-1, n) + numberOfPaths(m, n-1); 
	           // + numberOfPaths(m-1,n-1);
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(numberOfPaths(4,4));
	}

}
