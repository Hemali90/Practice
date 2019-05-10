package zscaler;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPil {
	private Path pilDir;
	private Path outputDir;
	
	public ExtractPil(Path reutersDir, Path outputDir) throws IOException{
		this.pilDir = reutersDir;
	    this.outputDir = outputDir;
	}
	public void extract() throws IOException {
	    long count = 0;
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(pilDir, "*.sgml")) {
	      for (Path sgmFile : stream) {
	        extractFile(sgmFile);
	        count++;
	      }
	    }
	    if (count == 0) {
	      System.err.println("No .sgml files in " + pilDir);
	    }
	  }
	
	
	Pattern EXTRACTION_PATTERN = Pattern
		      .compile("<BLOCK>(.*?)</BLOCK>");

		  private static String[] META_CHARS = { "&", "<", ">", "\"", "'" };

		  private static String[] META_CHARS_SERIALIZATIONS = { "&amp;", "&lt;",
		      "&gt;", "&quot;", "&apos;" };
		  
	
		  protected void extractFile(Path sgmFile) {
			  try (BufferedReader reader = Files.newBufferedReader(sgmFile, StandardCharsets.UTF_8)){
				  StringBuilder buffer = new StringBuilder(1024);
			      StringBuilder outBuffer = new StringBuilder(1024);
			      String line = null;
			      int docNumber = 0;
			      while ((line = reader.readLine()) != null) {
			    	  if(!line.matches("\\<*\\>")){
			    		  System.out.println(line);
			    	  }
//			    	  if(buffer.capacity()!=0){
//			    		  buffer.append(line).append(' ');
//			    	  }
//			    	  else{
//			    		  buffer = new StringBuilder(1024);
//			    		  Matcher matcher = EXTRACTION_PATTERN.matcher(buffer);
//			    		  while (matcher.find()){
//			    			 System.out.println("Found"+matcher.groupCount());
//			    		  }
//			    	  }
			      }
			  }
			  catch (IOException e) {
			      throw new RuntimeException(e);
			    }
		  }
		  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Path pilDir = Paths.get("/Users/hemali/Zscaler/piltest");
		 Path outputDir = Paths.get("/Users/hemali/Zscaler/piltest");
		 if (!Files.exists(pilDir)) {
		      usage("Cannot find Path to pil SGM files ("+pilDir+")");
		      return;
		    }
		 try{
		 ExtractPil extractor = new ExtractPil(pilDir, outputDir);
		 extractor.extract();
		 }
		 catch(Exception ex){
			 
		 }
	}
	private static void usage(String msg) {
	    System.err.println("Usage: "+msg+" :: java -cp <...> org.apache.lucene.benchmark.utils.ExtractReuters <Path to Reuters SGM files> <Output Path>");
	  }

}
