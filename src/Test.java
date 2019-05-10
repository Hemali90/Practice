import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Test {

	
	public static int countBits(int i){
		int count = 0;
		while(i != 0){
			
		if(( i & 1) == 1){
			count++;
		}
		i = i>>>1;
		}
		
		return count;
	}
	
	 public List<String> topKFrequent(String[] words, int k) {
	        List<String> result = new ArrayList<>();
	        
	        Map<String,Integer> map = new HashMap<>();
	        
	        for(int i = 0 ; i< words.length ; i++){
	            map.put(words[i],(map.get(words[i]) == null? 1 : map.get(words[i]+1)));
	        }
	        List<Map.Entry<String,Integer>> set = new ArrayList<>(map.entrySet());
	        Collections.sort(set, new Comparator <Map.Entry<String,Integer>>(){
	           public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
	               return b.getValue().compareTo(a.getValue());
	           } 
	        });
	        
	        for(int i = 0 ; i < k; i++){
	            result.add(set.get(i).getKey());
	        }
	        
	        return result;
	    }
	 
	public static List<String> combineComponents(List<List<String>> components){
		
		List<String> solutionList = new ArrayList<>();
		
		List<String> list = components.get(0);
		
		for(int j=1;j<components.size(); j++){
			solutionList = new ArrayList<>();
			System.out.println("Before"+list);
			for(String outer:list){
				for(String inner:components.get(j)){
					StringBuilder sb = new StringBuilder();
					sb.append(outer).append(inner);
					solutionList.add(sb.toString());
				}
			}
			
			list = new ArrayList(solutionList);
			System.out.println("After"+list);
		}
		 
		return solutionList;
	}
public static void main(String[] args){
	List<String> abc = Arrays.asList("http","https");
	List<String> bc = Arrays.asList("geeks","geek");
	List<String> ad = Arrays.asList("amz","com");
	List<String> newone = Arrays.asList("uvq","co.uk");
	
	List<List<String>> testList = new ArrayList<>();
	testList.add(abc);
	testList.add(bc);
	testList.add(ad);
	testList.add(newone);
	List<String> list = combineComponents(testList);
	
	for(String str: list){
		System.out.println(str);
	}
	
	Map<String,List<String>> ticketsMap = new HashMap<>();
	
	Collection<List<String>> c = ticketsMap.values();
	
	int[] a= new int[5];
	
}

}
