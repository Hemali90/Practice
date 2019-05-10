package general;
public class Printparan {
	public void par(int n, int open, int closed, String str) {

		if (closed == n) {
		System.out.println(str);
		return;
		}

		if (open < n) {
		par(n, open+1, closed, str + "{");
		}

		if (closed < open) {
		par(n, open, closed+1, str + "}");
		}
		}
	
	public void printparan(int l,int r,char str[],int count){
		if(l<0||r<l){
			return;
		}
		if(l==0&&r==0){
			System.out.println(str);
		}
		else
		{
			if(l>0){
				str[count]='(';
				printparan(l-1,r,str,count+1);
			}
			if(r>l){
				str[count]=')';
				printparan(l,r-1,str,count+1);
			}
		}
	}
	
	
	public void printPar(int count)
	{ char[] str = new char[count*2]; 
	printparan(count, count, str, 0);
	}
	public static void main(String[] args){
		Printparan p=new Printparan();
		//p.printPar(3);
		p.par(4, 0, 0, "");
		
	}
}
