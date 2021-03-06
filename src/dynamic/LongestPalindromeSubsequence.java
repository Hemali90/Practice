package dynamic;

public class LongestPalindromeSubsequence {
	//dynamic programming
	 public int calculate(char []str){
	        int T[][] = new int[str.length+1][str.length+1];
	        for(int i=0; i < str.length; i++){
	            T[1][i] = 1;
	        }
	        for(int c = 2; c <= str.length; c++){
	            for(int i = 1; i <= str.length-c+1; i++){
	                if(str[i-1] == str[i-1 + c-1] && c == 2){
	                    T[c][i] = 2;
	                }else if(str[i-1] == str[i+c-2]){
	                    T[c][i] = T[c-2][i+1] + 2;
	                }else{
	                    T[c][i] = Math.max(T[c-1][i+1], T[c-1][i]);
	                }
	            }
	        }
	        return T[str.length][1];
	    }
//recurcive	    
	    public int calculateRecursive(char str[],int start,int len){
	        if(len == 1){
	            return 1;
	        }
	        if(len ==0){
	            return 0;
	        }
	        if(str[start] == str[start+len-1]){
	            return 2 + calculateRecursive(str,start+1,len-2);
	        }else{
	            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
	        }
	    }
	    
	    
	    public int longestPalindromeSubseq(String str) {
	        int T[][] = new int[str.length()][str.length()];
	        for(int i=0; i < str.length(); i++){
	            T[i][i] = 1;
	        }
	        for(int l = 2; l <= str.length(); l++){
	            for(int i = 0; i < str.length()-l + 1; i++){
	                int j = i + l - 1;
	                if(str.charAt(i) == str.charAt(j)){
	                    T[i][j] = T[i + 1][j-1] + 2;
	                }else{
	                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
	                }
	            }
	        }
	        return T[0][str.length()-1];
	    }
	    public static void main(String args[]){
	        LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence();
	        String str = "GEEKSFORGEEKS";
	        int  r = lps.calculate(str.toCharArray());
	        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
	        System.out.print(r + " " + r1);
	    }
}
