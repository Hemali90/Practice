package general;
public class MinElementPivotedArray {

	/**
	 * @param args
	 */
	int findMin(int arr[], int start, int end) {
		if(start < end) {
			int mid = ((end - start)/2) + start;
			if(mid > start && arr[mid - 1] > arr[mid]) {
				return arr[mid];
			}
			else if(mid < end && arr[mid+1] < arr[mid]) {
				return arr[mid+1];
			}
			else if(arr[end] < arr[mid]) {
				return findMin(arr, mid + 1, end);
			}
			else {
				return findMin(arr, start, mid - 1);
			}
		}
			else if(start == end) {
				return arr[start];
			}
		return arr[0];
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
