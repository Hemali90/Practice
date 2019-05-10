package general;import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class RemoveDuplicateString {
	//C style string
	public static char[] removeDuplicate(char[] str){
		//put zero in place of duplicate character
		for(int i=0;i<str.length-1;i++){
			for(int j=i+1;j<str.length;j++){
				
				if(str[i]==str[j]){
					str[j]='0';
				}
			}
		}
		//shift the zeros at the end
		System.out.println(str);
		int i=0;int j=str.length-1;
		while(i<=j && i<str.length-1){
			while(str[i]!='0'){
				if(i<str.length-1)
				i++;
			}
			while(str[j]=='0'){
				j--;
			}
			if(i<j){
			char temp=str[i];
			str[i]=str[j];
			str[j]=temp;}
		}
		int n=str.length;
		System.out.println(str);
		//trim the string uptil the zero's are reached
		for(int k=0;k<str.length-1;k++){
			if(str[k]=='0'){
				str[k]='\0';
				//break;
			}
		}
		if(n!=str.length)
		str[str.length-1]='\0';
		return str;
	}
	
	static void removeDuplicates(String li) {

		// Store unique items in result.
		List<String> list=new ArrayList<String>(Arrays.asList(li.split(" ")));
		ArrayList<String> result = new ArrayList<>();

		// Record encountered Strings in HashSet.
		HashSet<String> set = new HashSet<>();

		// Loop over argument list.
		for (String item : list) {

		    // If String is not in set, add it to the list and the set.
		    if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		    else{
		    	set.remove(item);
		    }
		}
		//return result;
		String ret=new String();
		for(String word: result){
			ret+=word +" ";
			//System.out.println(word);
		}
		System.out.println(ret);
		
	    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
 
        String text = "This is is the question is is easy";
        
        RemoveDuplicateString rm=new RemoveDuplicateString();
        rm.removeDuplicate("Helloo".toCharArray());
        /*
         * List<String> list = Arrays.asList(text.split(" "));
         */
        
 
        /*Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
           
           /*
            *  System.out.println(word + ": " + Collections.frequency(list, word));*/
            /*
             * 
import java.util.ArrayList;
import java.util.HashSet;

public class Program {

    static ArrayList<String> removeDuplicates(ArrayList<String> list) {

	// Store unique items in result.
	ArrayList<String> result = new ArrayList<>();

	// Record encountered Strings in HashSet.
	HashSet<String> set = new HashSet<>();

	// Loop over argument list.
	for (String item : list) {

	    // If String is not in set, add it to the list and the set.
	    if (!set.contains(item)) {
		result.add(item);
		set.add(item);
	    }
	}
	return result;
    }

    public static void main(String[] args) {

	ArrayList<String> list = new ArrayList<>();
	list.add("dog");
	list.add("cat");
	list.add("dog");
	list.add("dog");
	list.add("cat");
	list.add("bird");

	// Remove duplicates from ArrayList of Strings.
	ArrayList<String> unique = removeDuplicates(list);
	for (String element : unique) {
	    System.out.println(element);
	}
    }
}

             */
        }
    }

 