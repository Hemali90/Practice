package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	private static Map<Integer,String> map = new HashMap<>();
	static {
		map.put(2,"abc");
		map.put(3,"def");
		map.put(4,"ghi");
		map.put(5,"jkl");
		map.put(6,"mno");
		map.put(7,"pqr");
		map.put(8,"stu");
		map.put(9,"vwxz");
		
	}
	
	public static List<String> getMapping(String digits, int index){
		
		if(index == digits.length()){
			return new ArrayList<>();
		}
		String mapping = map.get(Integer.parseInt(digits.charAt(index)+""));
		//System.out.println(mapping);
		List<String> subList = getMapping(digits,index+1);
		List<String> returnList = new ArrayList<>();
		
		for(int i = 0; i< mapping.length() ; i++){
			returnList.add(mapping.charAt(i)+"");
		}
		
		List<String> list = new ArrayList<>(returnList);
		
		for(String sub : subList){
			for(String ret : list){
				returnList.add(ret+sub);
			}
		}
		/*for(int i = 0; i< mapping.length() ; i++){
			returnList.remove(mapping.charAt(i)+"");
		}*/
		
		return returnList;
	}
	
	public static String convert(String s, int numRows) {
	       // int ind = 0;
	        StringBuilder[] array = new StringBuilder[numRows];
	        for(int i = 0 ; i< numRows ; i++){
	        	array[i] = new StringBuilder();
	        }
	        boolean notRev = false;
	        for(int j = 1; j < s.length() ; j++){
	            
	            if(!notRev){
	              for(int i = 0 ; i< numRows ; i++){
	                  System.out.println(j);
	                     array[i].append(s.charAt(j));
	                } 
	                notRev = true;
	            } else {
	               for(int i = numRows - 1 ; i > 0 ; i--){
	                    array[i].append(s.charAt(j));
	               } 
	                notRev = false;
	            }
	            
	        }
	        
	        StringBuilder finalS = new StringBuilder();
	        for(int i =0 ; i< numRows ; i++){
	            finalS.append(array[i]);
	        }
	        return finalS.toString();
	    }
	
	public static void main(String args[]){
	System.out.println(convert("PAYPALIS", 3));	
	}
}
