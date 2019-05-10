package general;
public class MaskString {
	public void maskString(String a,String b){
		char ar[]=a.toCharArray();
		char br[]=b.toCharArray();
	    int count[]=new int[256];
	    for(int i=0;i<b.length();i++){
	    	if(br[i]!=' ')
	    	count[br[i]]=count[br[i]] +1;
	    }
	    for(int i=0;i<a.length();i++){
	    	if(count[ar[i]] < 1){
	    		System.out.print(ar[i]);
	    	}
	    }
	}
public static void main(String args[]){
	String a="all the best";
	String b="mask";
	MaskString ms=new MaskString();
	ms.maskString(a, b);
}
}
