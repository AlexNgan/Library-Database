//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.*;
import java.util.Scanner;

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
  
  //Method run at the start of the program.
  public void init(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Are you a borrower (1) or a librarian (2)? Please enter the corresponding number.");
    int reply1 = scan.nextInt();
    
    //If user is borrowing...
    if(reply1 == 1){
     System.out.println("Do you want to A). Browse, B). Check avalability, "    //Gets options for borrower.
                          + "C). Check out a book, or D). Return a book?"); 
     String reply2 = scan.nextLine();
    }
    //If user is a librarian...
    else if(reply1 == 2){
      System.out.println("A). Enter a new book, B. Remove a book, or "     //Gets options for librarian.
                           + "C. Check borrowing history of a book.");
    String reply2 = scan.nextLine();
    }
  }
}
