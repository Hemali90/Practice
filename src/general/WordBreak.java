package general;

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
