
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

/* Author: Gloria Ngan
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  
  private ArrayList<Book> database = new ArrayList<Book>();                           //Holds all books.
  private ArrayList<TeacherBorrower> teachers = new ArrayList<TeacherBorrower>();     //Holds all teachers.
  private ArrayList<StudentBorrower> students = new ArrayList<StudentBorrower>();     //Holds all students.
  
  
  //Method to import books from a .txt file.
  public void importBooks(String fileName){
    String file = fileName;     // The file to open.
    String line;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      //Wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //Saves each line as a book object.
      while((line = bufferedReader.readLine()) != null) {
        String[] str = line.split(", ");     // Takes a single line and saves info as an array
        // with the format: [ISBN, title, author, etc.]
        
        Book book = new Book(str[0], str[1], str[2], str[3], str[4]);    //Creates new book with elements in array.
        database.add(book);                                              //Adds new book to library.
      }   
      
      bufferedReader.close();   //Close reader.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
    }    
  }
  
  public void importTeachers(String fileName){
    String file = fileName;     // The file to open.
    String line;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      //Wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //Saves each line as a book object.
      while((line = bufferedReader.readLine()) != null) {
        String[] str = line.split(", ");     
        TeacherBorrower teacher = new TeacherBorrower(str[1], str[0]); 
        teachers.add(teacher);
      }   
      
      bufferedReader.close();   //Close reader.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
    }    
  }
  
  public void importStudents(String fileName){
    String file = fileName;     // The file to open.
    String line;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      //Wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //Saves each line as a book object.
      while((line = bufferedReader.readLine()) != null) {
        String[] str = line.split(", ");     
        
        StudentBorrower student = new StudentBorrower(str[0], str[1], str[2], str[3]); 
        students.add(student);                                           
      }   
      
      bufferedReader.close();   //Close reader.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
    }    
  }
  
  //Prints out the contents of the Library.
  public void displayBooks(){
    for(int i = 0; i < database.size(); i++){
      System.out.println(database.get(i));
    }
  }
  
  //Prints out the contents of the Library.
  public void displayTeachers(){
    for(int i = 0; i < teachers.size(); i++){
      System.out.println(teachers.get(i));
    }
  }
  
  //Prints out the contents of the Library.
  public void displayStudents(){
    for(int i = 0; i < students.size(); i++){
      System.out.println(students.get(i));
    }
  }
  
  //Modifier method to add a books to database.
  public void addBook(Book book){
    database.add(book);
  }
  
  //Modifier method to remove books from database.
  public void removeBook(Book book){
    database.remove(book);
  }
  
  //Method to mark a book as borrowed if it is available.
  public void borrowBook(Book book){
    book.makeBorrowed();
  }
  
  public void returnBook(Book book){
    book.makeReturned();
  }
  
  //Method to display all books in the library.
  public void browse(String genre){
    //TODO
  }
}
