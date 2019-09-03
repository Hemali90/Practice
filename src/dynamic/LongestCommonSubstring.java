package dynamic;

public class LongestCommonSubstring {
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
    
	static int LCSubStr(char X[], char Y[], int m, int n)  
    { 
        // Create a table to store lengths of longest common suffixes of 
        // substrings. Note that LCSuff[i][j] contains length of longest 
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and 
        // first column entries have no logical meaning, they are used only 
        // for simplicity of program 
        int LCStuff[][] = new int[m + 1][n + 1]; 
        int result = 0;  // To store length of the longest common substring 
          
        // Following steps build LCSuff[m+1][n+1] in bottom up fashion 
        for (int i = 0; i <= m; i++)  
        { 
            for (int j = 0; j <= n; j++)  
            { 
                if (i == 0 || j == 0) 
                    LCStuff[i][j] = 0; 
                else if (X[i - 1] == Y[j - 1]) 
                { 
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1; 
                    result = Integer.max(result, LCStuff[i][j]); 
                }  
                else
                    LCStuff[i][j] = 0; 
            } 
        } 
        return result; 
    } 
	
	static int lcs(String X, String Y, int i, int j, int count) { 
		  
        if (i == 0 || j == 0) { 
            return count; 
        } 
  
        if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
            count = lcs(X,Y,i - 1, j - 1, count + 1); 
        } 
        count = Math.max(count, Math.max(lcs(X,Y,i, j - 1, 0), 
                            lcs(X,Y,i - 1, j, 0))); 
        return count; 
    } 
    /**
     * Recursive way of calculating lcs
     */
    public int longestCommonSubstringRec(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){
            if(str1[pos1] == str2[pos2]){
                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
            }else{
                return 0;
            }
        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }
        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }
    
    public static void main(String args[]){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdemf".toCharArray();
        System.out.println(lcs.longestCommonSubstring(str1, str2));
        System.out.println(lcs.longestCommonSubstringRec(str1, str2,str1.length-1, str2.length-1,false));
    }

}
