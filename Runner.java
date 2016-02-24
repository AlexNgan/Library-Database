//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.*;
import java.util.Scanner;

/* Author: Gloria Ngan
 * 
 * This class contains the methods that control the flow of
 * the program, calling other classes and methods based on 
 * user input.
 */

public class Runner{
  
  //Method to read and print text files.
  public void readFile(String fileName){
    
    String file = fileName;     // The file to open.
    String line = null;         // This will reference one line at a time.
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      //Wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      while((line = bufferedReader.readLine()) != null) {
        int start, end;  //For indexs of substring.
        String str;      //Substring holder.
        for(int i = 0; i < line.length(); i++){        
          //On first iteration.
          start = 0;
    
          if(i != 0){
            start = line.indexOf(",", start);    //Start where the last substring ended.
          }
          
          end = line.indexOf(",", start);          //Index to stop substring.
          str = line.substring(start, end);
          
          //System.out.println(str);           
        }
        break;
      }   
      
      bufferedReader.close();   //Close file.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
    }
  }
}
