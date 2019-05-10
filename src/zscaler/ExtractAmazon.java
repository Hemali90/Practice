package zscaler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtractAmazon {
	private Path inputDir;
	private Path outputDir;
	private int fdocNumber=1;
	public ExtractAmazon(Path inputDir, Path outputDir) throws IOException {
	    this.inputDir = inputDir;
	    this.outputDir = outputDir;
	}
	protected void extractFile(Path txtFile) {
		try (BufferedReader reader = Files.newBufferedReader(txtFile, StandardCharsets.UTF_8)) {
		      StringBuilder buffer = new StringBuilder(1024);
		      StringBuilder outBuffer = new StringBuilder(1024);
		      String line = null;
		      while ((line = reader.readLine()) != null) {
		    	  String arr[]=line.split(":");
		    	  if(arr[0].equals("review/text")){
		    		  //System.out.println(arr[0]);
		    		  /*if(fdocNumber<=10000)*/{
		    		  Path outFile = outputDir.resolve( (fdocNumber++) + ".txt");
		    		  BufferedWriter writer = Files.newBufferedWriter(outFile, StandardCharsets.UTF_8);
		    		  //System.out.println(arr[1]);
		    		 writer.write(arr[1]);
		    			 
		    		 writer.close();
		    		  }
		    	  }
		      }
		}catch(Exception e){}
	}
	
	public static void main(String args[]){
		Path inputDir = Paths.get("/Users/hemali/Zscaler/Health.txt");
		Path outputDir = Paths.get("/Users/hemali/Zscaler/amazon_reviews");
		try{
		ExtractAmazon ex=new ExtractAmazon(inputDir,outputDir);
		ex.extractFile(inputDir);
		}catch(Exception e){}
	}
}
