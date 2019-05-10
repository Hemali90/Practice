package zscaler;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * Split the Reuters SGML documents into Simple Text files containing: Title, Date, Dateline, Body
 */
public class ExtractReuters {
  private Path reutersDir;
  private Path outputDir;
  private Path nonFinOutputDir;
  List<String> interested_topics;

  public ExtractReuters(Path reutersDir, Path outputDir, Path nonFinOutputDir ) throws IOException {
    this.reutersDir = reutersDir;
    this.outputDir = outputDir;
    this.nonFinOutputDir=nonFinOutputDir;
    System.out.println("Deleting all files in " + outputDir);
    interested_topics=new ArrayList<String>();
    addTopics();
  }

  public void addTopics(){
	  interested_topics.add("earn"); 
	  interested_topics.add("income"); 
	  interested_topics.add("instal-debt"); 
	  interested_topics.add("interest"); 
	  interested_topics.add("bop"); 
	  interested_topics.add("money-fx"); 
	  interested_topics.add("money-supply"); 
	  interested_topics.add("trade"); 
	  interested_topics.add("cpi");  
	  interested_topics.add("wpi"); 
	  interested_topics.add("gnp"); 
	  interested_topics.add("reserves"); 
	  interested_topics.add("lei"); 
	  interested_topics.add("dlr"); 
	  interested_topics.add("austdlr"); 
	  interested_topics.add("hk"); 
	  interested_topics.add("singdlr"); 
	  interested_topics.add("nzdlr"); 
	  interested_topics.add("can"); 
	  interested_topics.add("stg"); 
	  interested_topics.add("dmk"); 
	  interested_topics.add("yen"); 
	  interested_topics.add("sfr"); 
	  interested_topics.add("ffr"); 
	  interested_topics.add("bfr"); 
	  interested_topics.add("dfl"); 
	  interested_topics.add("lit");
	  interested_topics.add("dkr"); 
	  interested_topics.add("nkr"); 
	  interested_topics.add("skr"); 
	  interested_topics.add("mexpeso");
	  interested_topics.add("cruzado");
	  interested_topics.add("austral");
	  interested_topics.add("saudiyal");
	  interested_topics.add("rand");
	  interested_topics.add("ringgit");
	  interested_topics.add("escudo");
	  interested_topics.add("peseta");
	  interested_topics.add("drachma");
	  interested_topics.add("acq");	  
  }
  public void extract() throws IOException {
    long count = 0;
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(reutersDir, "*.sgm")) {
      for (Path sgmFile : stream) {
        extractFile(sgmFile);
        count++;
      }
    }
    if (count == 0) {
      System.err.println("No .sgm files in " + reutersDir);
    }
  }

  Pattern EXTRACTION_PATTERN = Pattern
      .compile("<TOPICS>(.*?)</TOPICS>|<BODY>(.*?)</BODY>");

  private static String[] META_CHARS = { "&", "<", ">", "\"", "'" };

  private static String[] META_CHARS_SERIALIZATIONS = { "&amp;", "&lt;",
      "&gt;", "&quot;", "&apos;" };

  /**
   * Override if you wish to change what is extracted
   */
  protected void extractFile(Path sgmFile) {
    try (BufferedReader reader = Files.newBufferedReader(sgmFile, StandardCharsets.UTF_8)) {
      StringBuilder buffer = new StringBuilder(1024);
      StringBuilder outBuffer = new StringBuilder(1024);
      
      String line = null;
      int fdocNumber = 0;
      int ndocNumber = 0;
      
      while ((line = reader.readLine()) != null) {
        // when we see a closing reuters tag, flush the file

        if (line.indexOf("</REUTERS") == -1) {
          // Replace the SGM escape sequences

          buffer.append(line).append(' ');// accumulate the strings for now,
                                          // then apply regular expression to
                                          // get the pieces,
        } else {
          // Extract the relevant pieces and write to a file in the output dir
          Matcher matcher = EXTRACTION_PATTERN.matcher(buffer);
          boolean matchFound=false;
          while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
            	if(i==1){
            		String match=matcher.group(i);
            		if(match!=null && ! match.isEmpty()){
            		String topics[]=matcher.group(i).split("</D>");
            		
            		for(int k=0;k<topics.length;k++){
            			//String topic=topics[k].substring(1);
            			if(topics[k]!=null && !topics[k].isEmpty())
            			{
            				String topic=topics[k].substring(3, topics[k].length());
            				//   System.out.println(topic);
            				if(interested_topics.contains(topic)){
            					 matchFound=true; 
            				}
            				//outBuffer.append(topic);
            				//outBuffer.append(System.lineSeparator()).append(System.lineSeparator());
            			}
            			else{//System.out.println("NULL1");
            			}
            		}
            		}
            		else{
            			//System.out.println("NULL");
            		}
            	}
            	else if(i!=1){
            		
              if (matcher.group(i) != null ) {
            	  outBuffer.append(matcher.group(i));
                  outBuffer.append(System.lineSeparator()).append(System.lineSeparator());  
              }
              
            }
            }
            
          }
          
          String out = outBuffer.toString();
          
          for (int i = 0; i < META_CHARS_SERIALIZATIONS.length; i++) {
            out = out.replaceAll(META_CHARS_SERIALIZATIONS[i], META_CHARS[i]);
          }
          
          if(matchFound && !out.isEmpty() && out!=null && !out.equals("") && !out.equals("null")){
          Path outFile = outputDir.resolve(sgmFile.getFileName() + "-" + (fdocNumber++) + ".txt");
          // System.out.println("Writing " + outFile);
          try (BufferedWriter writer = Files.newBufferedWriter(outFile, StandardCharsets.UTF_8)) {
            writer.write(out);
          }
          outBuffer.setLength(0);
          buffer.setLength(0);
          }
          else if(!matchFound  && !out.isEmpty() && out!=null && !out.equals("") && !out.equals("null")){
        	  Path outFile = nonFinOutputDir.resolve(sgmFile.getFileName() + "-" + (ndocNumber++) + ".txt");
              // System.out.println("Writing " + outFile);
              try (BufferedWriter writer = Files.newBufferedWriter(outFile, StandardCharsets.UTF_8)) {
                writer.write(out);
              }
              outBuffer.setLength(0);
              buffer.setLength(0);  
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws Exception {
//    if (args.length != 2) {
//      usage("Wrong number of arguments ("+args.length+")");
//      return;
//    }
	 /**
	  * We have to keep on changing the .sgm directory because there is some error in reut2-017 .sgm file which causes an exception . Hence , I have put reut2-001.sgm file in /reut2-001 dir 
	  * and so on.
	  */
    Path reutersDir = Paths.get("/Users/hemali/Zscaler/reuters21578/reut2-021");
    
    
    if (!Files.exists(reutersDir)) {
      usage("Cannot find Path to Reuters SGM files ("+reutersDir+")");
      return;
    }
    
    // First, extract to a tmp directory and only if everything succeeds, rename
    // to output directory.
    Path outputDir = Paths.get("/Users/hemali/Zscaler/reuters21578txt/fin");
    Path nonFinDir = Paths.get("/Users/hemali/Zscaler/reuters21578txt/nonfin");
    //if(!Files.exists(outputDir))
    //Files.createDirectories(outputDir);
    //if(!Files.exists(outputDir))
    //Files.createDirectories(nonFinDir);
    
    ExtractReuters extractor = new ExtractReuters(reutersDir, outputDir,nonFinDir);
    extractor.extract();
    // Now rename to requested output dir
    //Files.move(outputDir, Paths.get("/Users/hemali/Zscaler/reuters21578txt/fin"), StandardCopyOption.ATOMIC_MOVE);
    //Files.move(nonFinDir, Paths.get("/Users/hemali/Zscaler/reuters21578txt/nonfin"), StandardCopyOption.ATOMIC_MOVE);
    
  }

  private static void usage(String msg) {
    System.err.println("Usage: "+msg+" :: java -cp <...> org.apache.lucene.benchmark.utils.ExtractReuters <Path to Reuters SGM files> <Output Path>");
  }
  
}