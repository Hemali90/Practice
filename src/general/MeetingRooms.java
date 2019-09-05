package general;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

 * @author hwaghode
 *
 */
public class MeetingRooms {
	/**
	 * sort the start and end time in ascending order and keeping two pointers startPtr and endPtr , increase endPtr only when all the elements in startPtr ar lower than endPtr.
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        int[] startArr = new int[intervals.length];
        int[] endArr = new int[intervals.length];
        
        for(int i = 0 ; i < startArr.length ; i++){
            startArr[i] = intervals[i][0];
        }
        for(int i = 0 ; i < endArr.length ; i++){
            endArr[i] = intervals[i][1];
        }
        
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int startPtr = 0;
        int endPtr = 0;
        int count = 0;
        while( startPtr < startArr.length){
            if(startArr[startPtr] >= endArr[endPtr]){
                endPtr++;
                count--;
            } 
            
            startPtr++;
            count++;
        }
        
        return count;
    }
}
