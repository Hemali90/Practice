package general;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

 * @author hwaghode
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        return wordBreakUtil(s,set);
    }
    public boolean wordBreakUtil(String s, Set<String> wordDict){
        if(wordDict.contains(s) || s.length() == 0 ){
           return true;
        }
        
        boolean flag = false;
        for(String str: wordDict){
            if( s.startsWith(str) &&
                wordBreakUtil(s.substring(str.length()), wordDict))
            {
                return true;
            }
            
        } 
        
        return false;
    }
}
