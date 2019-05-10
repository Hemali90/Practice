package dynamic;

public class LongestIncreasingSubsequence {
/*
 * Box stacking problem is somewhat same like the lis problem.
 * In box stacking problem,the boxes are arranged in such a way that the the box with highest base(width*depth)
 * is at the bottom,box with second highest base(width*depth) is on its top and so on.
 * 
 * 1) Generate all 3 rotations of all boxes. The size of rotation array becomes 3 times the size of original array. For simplicity, we consider depth as always smaller than or equal to width.

	2) Sort the above generated 3n boxes in decreasing order of base area.

	3) After sorting the boxes, the problem is same as LIS with following optimal substructure property.
	MSH(i) = Maximum possible Stack Height with box i at top of stack
	MSH(i) = { Max ( MSH(j) ) + height(i) } where j < i and width(j) > width(i) and depth(j) > depth(i).
	If there is no such j then MSH(i) = height(i)

	4) To get overall maximum height, we return max(MSH(i)) where 0 < i < n
 */
	private int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }
    
    public int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }
	public static int lis(int a[]){
		int max=0;
		for(int i=0;i<a.length;i++){
			int count=0;
			for(int j=i;j<a.length-1;j++){
				if(a[j]<a[j+1]){
					count++;
				}
			}
			if(count>max){
				max=count;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
