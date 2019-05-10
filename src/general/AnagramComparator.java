package general;
import java.util.Arrays;
import java.util.Comparator;


public class AnagramComparator /*implements Comparator<String>*/{
/*public String sortChars(String s){
	char contents[]=s.toCharArray();
	Arrays.sort(contents);
	return new String(contents);
}
public int compare(String s1,String s2){
	return sortChars(s1).compareTo(sortChars(s2));
}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="hello there olleh cat act smart";
String sp[]=s.split(" ");
//Arrays.sort(sp,new AnagramComparator());
Arrays.sort(sp,new Comparator<String>(){
	public String sortCh(String s){
		char cont[]=s.toCharArray();
		Arrays.sort(cont);
		return new String(cont);
	}
	public int compare(String s1,String s2){
		return sortCh(s1).compareToIgnoreCase(sortCh (s2));
	}
});
for(String st:sp){
	System.out.print(st+" ");
}
	}

}
