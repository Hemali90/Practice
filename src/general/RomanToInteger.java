package general;

import java.util.TreeMap;

public class RomanToInteger {
	private final static TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	static {

        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

    }
    public static int romanToInt(String s) {
        int i = 0;
       
        int result = 0;
        while (i < s.length()){
        	//String ss = ""+s.charAt(i);
            String s1 = s.substring(i,i+1);
            String s2=null;
            if(i+1 < s.length()){
                s2 = s.substring(i+1,i+2);
            }
            if(s2 !=null){	
              if(map.get(s1+s2) != null){
                i++;i++;
                  result = result+map.get(s1+s2);
                }  else {
                  i++;
                  result = result + map.get(s1);
              }
            } else {
                i++;
                result = result + map.get(s1);
            }
              
        }
        return result; 
    }
}
