package general;import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval implements Comparable<Interval>{
	Integer start;
	Integer end;
	
	Interval(Integer s,Integer e){
		start=s;
		end=e;
	}

	public int compareTo(Interval b){
		/*if(this.end<b.end){
			return -1;
		}
		if(this.end>b.end){
			return 1;
		}
		return 0;*/
		return this.end.compareTo(b.end);
	}
	
}

public class IntervalSort{
	
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	
	    public List<Interval> merge(List<Interval> intervals) {
	        Collections.sort(intervals, new Comparator<Interval>(){
	            @Override
	            public int compare(Interval a, Interval b){
	               return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
	            }
	        });
	        List<Interval> mergedIntervals = new ArrayList<>();
	        for(Interval curInt : intervals){
	            if(mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() -1).end < curInt.start){
	                mergedIntervals.add(curInt);
	            }
	            else {
	                int maxEnd = Math.max(mergedIntervals.get(mergedIntervals.size() -1).end, curInt.end);
	                mergedIntervals.get(mergedIntervals.size() -1).end = maxEnd;
	            }
	        }
	        return mergedIntervals;
	    }
	
}
