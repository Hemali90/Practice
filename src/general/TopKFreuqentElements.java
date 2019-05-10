package general;import java.util.*;
import java.util.Map.Entry;

/**
 * Created by ideven on 31/01/15.
 */
public class TopKFreuqentElements {
    int[] num={1,2,6,5,4,6,7,8,8,4,2,3,2,2,2,2,2,1,1,1,1};
    public final int K=3;
    Map<Integer,Integer> map= new HashMap<Integer,Integer>();

    public void topK(){

        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])){
                int n=map.get(num[i]);
                map.put(num[i],++n);
            }
            else{
                map.put(num[i],1);
            }

        }
        List<Map.Entry> list = new LinkedList<Map.Entry>(map.entrySet());

        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });


       for(int k=0;k<K;k++){
           System.out.println(list.get(k));
       }
    }

    public static int findNumDivisible(int k){
    	for(int i=10;i<Integer.MAX_VALUE;i=i*10){
    		if((i % k)==0){return i;}
    	}
    	return -1;
    }
    public static void main(String[] args){
        TopKFreuqentElements t= new TopKFreuqentElements();
        t.topK();
        //System.out.println(findNumDivisible(3));
        
    }
}