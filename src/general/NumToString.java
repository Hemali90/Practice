package general;
public class NumToString {

	public String numToStringUtil(String abc){
		String[] units=new String[11];
		units[0]="";
		units[1]="one";
		units[2]="two";
		units[3]="three";
		units[4]="four";
		units[5]="five";
		units[6]="six";
		units[7]="seven";
		units[8]="eight";
		units[9]="nine";
		units[10]="ten";
		String[] tens=new String[11];
		tens[1]="eleven";
		tens[2]="twelve";
		tens[3]="thirteen";
		tens[4]="fourteen";
		tens[5]="fifteen";
		tens[6]="sixteen";
		tens[7]="seventeen";
		tens[8]="eighteen";
		tens[9]="nineteen";
		String[] twenties=new String[11];
		twenties[2]="twenty";
		twenties[3]="thirty";
		twenties[4]="fourty";
		twenties[5]="fifty";
		twenties[6]="sixty";
		twenties[7]="seventy";
		twenties[8]="eighty";
		twenties[9]="ninety";
		char ch[]=abc.toCharArray();
		int a=ch[0];
		int b=ch[1];
		int c=ch[2];
		
		if(a==0 && b==0 && c==0){
			return null;
		}
		else if(a==0 && b!=0 && c!=0){
			if(b==1){
				return tens[c];
			}
			else{
				return twenties[b]+ " "+ units[c];
			}
		}
		else if(a==0 && b==0 && c!=0){
			return units[c];
		}
		else if(a!=0 && b==0 && c!=0){
			return units[a]+" hundered and "+units[c];
		}
		else if(a!=0 && b==0 && c==0){
			return units[a]+" hundred ";
		}
		else if(a!=0 && b!=0 && c==0){
			if(b==1) return units[a]+ " hundred "+ units[10];
			else return units[a]+" hundred "+twenties[b];
		}
		return units[a]+" hundred and "+ twenties[b]+" "+ units[c];
	}
	public void numToString(int num){
		int n=num;
		while(n!=0){
			int threedig=n%1000;
			String ans;
			if(threedig==0){
				ans=numToStringUtil("000");
			}
			else if(threedig >0 && threedig <10 ){
				ans=numToStringUtil("00"+String.valueOf(threedig));
			}
			else if(threedig >=10 && threedig<100){
				ans=numToStringUtil("0"+String.valueOf(threedig));
			}
			else ans=numToStringUtil(String.valueOf(threedig));
			n=n/1000;
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      NumToString str=new NumToString();
    // str.numToString(1233);
	}

}
