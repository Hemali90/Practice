package zscaler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SgmlSplit {

	public static void  split(){
		try{
			File f=new File("/Users/hemali/Zscaler/reuters21578/reut2-000/reut2-000.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		 String s;  
		 
		 StringBuffer buf=new StringBuffer();
		  while((s=br.readLine())!=null)  
		  buf.append(s);
		 
		  System.out.println(buf);
		  s=new String(buf);
		  
		  
		  String splits[]=s.split("\\<\\/REUTERS\\>");
		  System.out.println(splits[0]);
		  for(int i=0;i<splits.length;i++){
			  FileWriter fw=new FileWriter((i+1)+".sgm");
			  fw.write(splits[i]);
			  fw.close();
		  }
		  
		  fr.close();  
		  br.close();
		}catch(Exception e){
			System.out.println("Exception");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
