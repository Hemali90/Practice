package general;

import java.util.HashSet;
import java.util.Set;

/**
 * Is a given word smashable

Meaning

Print -> pint -> pit -> it -> i
Can a word be broken down into meaningful words

 * @author hwaghode
 *
 */
public class ISSmashable {

	public static boolean isSmashable(String word, Set<String> words){
		if(word.length() == 1 && words.contains(word)){
			return true;
		}
		
		for(int i = 0 ; i < word.length() ;i++ ){
			String smashed = null;
			if(i == 0){
				smashed = word.substring(1);
				//System.out.print("smashed "+  smashed);
			} else{
				smashed = word.substring(0,i) + word.substring(i+1);
			}
			System.out.println("smashed "+  smashed);
			if(words.contains(word) && isSmashable(smashed,words)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isSmashable(String word, Set<String> words, Set<String> mem){
		if( mem.contains(word)){
			return false;
		}
		if(word.length() == 1 && words.contains(word)){
			return true;
		}
		
		
		for(int i = 0 ; i < word.length() ;i++ ){
			String smashed = null;
			if(i == 0){
				smashed = word.substring(1);
				//System.out.print("smashed "+  smashed);
			} else{
				smashed = word.substring(0,i) + word.substring(i+1);
			}
			System.out.println("smashed "+  smashed);
			if(words.contains(word) && isSmashable(smashed,words,mem)){
				return true;
			}
		}
		mem.add(word);
		return false;
	}
	
	public static void main(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("print");
		set.add("pint");
		set.add("pit");
		set.add("it");
		set.add("i");
		set.add("sprint");
		set.add("dsprint");
		set.add("sprintt");
		set.add("dsprintt");
		set.add("dsprinte");
		set.add("sprinte");
		set.add("sprrinted");
		set.add("sprinted");
		
		Long start = System.currentTimeMillis();
		System.out.println(isSmashable("sprinted",set));
		Long end = System.currentTimeMillis();
		Set<String> mem = new HashSet<String>();
		System.out.println(" without mem time "+ (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(isSmashable("sprinted",set,mem));
		end = System.currentTimeMillis();
		
		System.out.println(" with mem time "+ (end - start));
		
		
	}
}
