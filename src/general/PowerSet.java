package general;import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/*» Let first = S[0]. Let smallerSet = S[1, ..., n].
» Compute all subsets of smallerSet and put them in allsubsets.
» For each subset in allsubsets, clone it and add first to the subset.*/

public class PowerSet {
	
	/*public Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
		Set<Set<Integer>> sets= new HashSet<Set<Integer>>();
        sets.add(new HashSet<Integer>());
        if (originalSet.isEmpty()) {
            //sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
           sets.add(set);
        }
        Iterator it1=sets.iterator();
        while(it1.hasNext()){
        	System.out.print(it1.next()+"\n");
        }
        return sets;
        
    }
public static void main(String args[]){
	Set<Integer> st=new HashSet<Integer>();
	//Scanner sc=new Scanner(System.in);
	PowerSet set=new PowerSet();
	st.add(1);
	st.add(2);
	st.add(3);
	
		set.powerSet(st);
}*/
	
public static List<List<String>> power(char c[],int i){
	if(i==c.length){
		return new ArrayList<>();
	}

		char val=c[i];
		List<List<String>> subset=power(c,i+1);
		List<List<String>> returnlist=new ArrayList<>();
		returnlist.add(Arrays.asList(String.valueOf(val)));
		returnlist.addAll(subset);
		for(List<String> subsetval:subset){
			for(String s:subsetval){
			returnlist.add(Arrays.asList(String.valueOf(s+","+val)));	
			}
		}	
	return returnlist;
}
public static List<String> powerSet(char c[], int i){
	if(i==c.length){
		return new ArrayList<String>();
	}
	List<String> subset = powerSet(c,i+1);
	List<String> returnList=new ArrayList<String>();
	returnList.add(String.valueOf(c[i]));
	for(String str: subset){
		returnList.add(str);
		returnList.add(str+c[i]);
	}
	return returnList;
}

    public static void main(String[] args) {
	        final List<List<String>> allSubsets = powerSet(Arrays.asList(1, 2, 3,4), 0);
	        //System.out.println("[]");
	        for (List<String> subsets : allSubsets) {
	            System.out.println(subsets);
	        }
	        
	  
	       
/*	    char ch[]="1234".toCharArray();
	    List<String> set=powerSet(ch,0);
	    for(String str: set)
	    {
	    	System.out.println(str);
	    }*/
	    
//	    List<String> set1=powerSet1(ch,0);
//	    for(String str: set1)
//	    {
//	    	System.out.println(str);
//	    }
//	        char c[]={'a','b','c','d'};
//	        List<List<String>> result=power(c,0);
//	        for (List<String> subsets : result) {
//	            System.out.println(subsets);
//	        }
	        
	    }
	    private static List<List<String>> powerSet(final List<Integer> values,
	                                               int index) {
	        if (index == values.size()) {
	            return new ArrayList<>();
	        }
	        int val = values.get(index);
	        List<List<String>> subset = powerSet(values, index + 1);
	        List<List<String>> returnList = new ArrayList<>();
	        returnList.add(Arrays.asList(String.valueOf(val)));
	        returnList.addAll(subset);
	        for (final List<String> subsetValues : subset) {
	            for (final String subsetValue : subsetValues) {
	                returnList.add(Arrays.asList(val + "," + subsetValue));
	            }
	        }
	        return returnList;
	    }
	
}
