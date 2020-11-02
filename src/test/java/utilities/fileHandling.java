package utilities;
import java.io.FileWriter;
import java.io.IOException;

public class fileHandling {

	public void writeToFile(String inputText, String fileNamewithExtension) 
	{
		try {
			 FileWriter fw=new FileWriter(fileNamewithExtension);    
	           fw.write(inputText);    
	           fw.close();    
			}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
			}
	}
}
