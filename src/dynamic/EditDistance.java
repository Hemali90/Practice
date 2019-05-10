package dynamic;

public class EditDistance {
private static int EDIT_COST = 1;
    
    public int recEditDistance(char[]  str1, char str2[], int len1,int len2){
        
        if(len1 == str1.length){
            return str2.length - len2;
        }
        if(len2 == str2.length){
            return str1.length - len1;
        }
        return min(recEditDistance(str1,str2,len1+1,len2+1) + str1[len1] == str2[len2] ? 0 : 1, recEditDistance(str1,str2,len1,len2+1) + 1, recEditDistance(str1,str2,len1+1,len2) + 1);
    }
    
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    int editDist(char[] str1 , char[] str2 , int m ,int n) 
    { 
        // If first string is empty, the only option is to 
        // insert all characters of second string into first 
        if (m == 0) return n; 
      
        // If second string is empty, the only option is to 
        // remove all characters of first string 
        if (n == 0) return m; 
      
        // If last characters of two strings are same, nothing 
        // much to do. Ignore last characters and get count for 
        // remaining strings. 
        if (str1[m-1] == str2[n-1]) 
            return editDist(str1, str2, m-1, n-1); 
      
        // If last characters are not same, consider all three 
        // operations on last character of first string, recursively 
        // compute minimum cost for all three operations and take 
        // minimum of three values. 
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert 
                         editDist(str1,  str2, m-1, n),   // Remove 
                         editDist(str1,  str2, m-1, n-1) // Replace 
                       ); 
    } 
   
     int editDistDP(String str1, String str2, int m, int n) 
    { 
        // Create a table to store results of subproblems 
        int dp[][] = new int[m+1][n+1]; 
       
        // Fill d[][] in bottom up manner 
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                // If first string is empty, only option is to 
                // insert all characters of second string 
                if (i==0) 
                    dp[i][j] = j;  // Min. operations = j 
       
                // If second string is empty, only option is to 
                // remove all characters of second string 
                else if (j==0) 
                    dp[i][j] = i; // Min. operations = i 
       
                // If last characters are same, ignore last char 
                // and recur for remaining string 
                else if (str1.charAt(i-1) == str2.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1]; 
       
                // If the last character is different, consider all 
                // possibilities and find the minimum 
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert 
                                       dp[i-1][j],  // Remove 
                                       dp[i-1][j-1]); // Replace 
            } 
        } 
   
        return dp[m][n]; 
    } 
    
    public static void main(String args[]){
        String str1 = "SUNDAY";
        String str2 = "SATURDAY";
        EditDistance editDistance = new EditDistance();
        //int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        //System.out.print(result);
    }

}
