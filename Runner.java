//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.*;

/* Author: Gloria Ngan
 * 
 */

public class Runner{
  
  //Method to read and print text files.
  public void readFile(String fileName){
    
    // The files to open.
    String file = fileName;
    
    // This will reference one line at a time
    String line = null;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      while((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }   
      
      bufferedReader.close();   //Close file.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
      // Or we could just do this: 
      // ex.printStackTrace();
    }
  }
  
  public void init(){
    
  }
}
