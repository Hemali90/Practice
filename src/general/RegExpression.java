package general;import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExpression {
public void regexpCheck(String reg,String stringcheck){
	Pattern regex=Pattern.compile(reg);
	Matcher match=regex.matcher(stringcheck);
	while(match.find()){
		if(match.group().length()!=0){
			System.out.println(match.group());
		}
		System.out.println("Start "+match.start());
		System.out.println("End "+match.end());
		
	}
}
//replace space wuth ", "
public static void regexreplace(String toreplace){
	Pattern pat=Pattern.compile("\\s+");
	Matcher match=pat.matcher(toreplace.trim());
	System.out.println("Regex replace "+match.replaceAll("%02"));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
regexreplace("     Hello there my name is Hemali    ");
	}

}
