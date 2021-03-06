package dynamic;

public class MinInsertPalindrome {
	
	/*
	 * int min(int a, int b)
{   return a < b ? a : b;  }
 
// A DP function to find minimum number of insersions
int findMinInsertionsDP(char str[], int n)
{
    // Create a table of size n*n. table[i][j] will store
    // minumum number of insertions needed to convert str[i..j]
    // to a palindrome.
    int table[n][n], l, h, gap;
 
    // Initialize all table entries as 0
    memset(table, 0, sizeof(table));
 
    // Fill the table
    for (gap = 1; gap < n; ++gap)
        for (l = 0, h = gap; h < n; ++l, ++h)
            table[l][h] = (str[l] == str[h])? table[l+1][h-1] :
                          (min(table[l][h-1], table[l+1][h]) + 1);
 
    // Return minimum number of insertions for str[0..n-1]
    return table[0][n-1];
}
 
// Driver program to test above function.
int main()
{
    char str[] = "geeks";
    printf("%d", findMinInsertionsDP(str, strlen(str)));
    return 0;
}
	 */
	public static int minInsert(char str[],int l,int h){ //Recursive solution
		/*The minimum number of insertions in the string str[l…..h] can be given as:
           minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
           min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise*/
		//if(l > h) return Integer.MAX_VALUE;
		if (l >= h) return 0;
	    //if (l == h - 1) return (str[l] == str[h])? 0 : 1;
	 
	    // Check if the first and last characters are same. On the basis of the
	    // comparison result, decide which subrpoblem(s) to call
	    return (str[l] == str[h])? minInsert(str, l + 1, h - 1):(Math.min(minInsert(str, l, h - 1),minInsert(str, l + 1, h)) + 1);
	}
public static void main(String args[]){
	//char str[] = "geeks";
	String s="geeksa";
	char[] str=s.toCharArray();
    System.out.println(minInsert(str,0,s.length()-1));
    
    
}
}
