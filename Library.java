
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
  
  
  /*
   * Method to import books from a .txt file.
   * Param: Name of file.
   */ 
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
  
  //Prints out the teachers.
  public void displayTeachers(){
    for(int i = 0; i < teachers.size(); i++){
      System.out.println(teachers.get(i));
    }
  }
  
  //Prints out the students.
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
  public void removeBook(String input){
    if(findBook(input) != null){
      database.remove((findBook(input)));
    }
  }
  
  /*
   * Method to determine if book in library is available.
   * Param: String with title or ISBN of book.
   * Return: True or False.
   */ 
  public Boolean isAvailable(String input){
    if(findBook(input) != null){
      return (findBook(input)).getAvailability();
    }
    return false;
  }
  
  public static void writeTo(String fileName, String content){
    try {
      File file = new File("F:/AP Java/Library Database/" + fileName);
      
      // If file doesnt exists, then create it.
      if (!file.exists()) {
        file.createNewFile();
      }
      
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();
      
      System.out.println("Done");
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /* 
   * Method to mark a book as borrowed if it is available.
   * Params: Title or ISBN of a book and the name of the user.
   */ 
  public void borrowBook(String book, String borrower){
    if(findBook(book) != null){
      (findBook(book)).makeBorrowed();
      String fileName = (findBook(book)).getTitle() + "Log.txt";
      String content = "Returned by:" + borrower;
      
      writeTo(fileName, content);
    }
  }
  
  /* 
   * Method to mark a book as returned if possible.
   * Params: Title or ISBN of a book and the name of the user.
   */ 
  public void returnBook(String book, String borrower){
    if(findBook(book) != null){
      (findBook(book)).makeReturned();
      String fileName = (findBook(book)).getTitle() + "Log.txt";
      String content = "Borrowed by:" + borrower;
      
      writeTo(fileName, content);
    }
  }
  
  /*
   * Method to display all books of a genre in the library.
   * Param: String with the genre of a book.
   * Return: List of books in the same genre.
   */ 
  public void browse(String genre){
    for(int i = 0; i < database.size(); i++){
      String bookGenre = (database.get(i)).getGenre();
      if(genre.equals(bookGenre)){
        System.out.println(database.get(i));
      }
    }
  }
  
  /* 
   * Finds book object based on String. Basically converts
   * from String to Book.
   * Param: String containing title or ISBN
   * Return: Book object with a title or ISBN matching the input.
   */ 
  public Book findBook(String input){
    for(int i = 0; i < database.size(); i++){
      String str = (database.get(i)).getTitle();     //Gets title of book at index.
      String ISBN = (database.get(i)).getISBN();     //Gets ISBN of book at index.
      if(input.equals(str) || input.equals(ISBN))
        return database.get(i);
    }
    return null;
  } 
  
  /* 
   * Method to display the history of a book.
   * Param: String with the title or ISBN of a book.
   */ 
  public void getBookLog(String input){
    String line;
    if(findBook(input) != null){     //If String of book exists, the book object is retrieved.
      String file = (findBook(input)).getTitle() + "Log.txt";
      try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(file);
        
        //Wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        //Prints line.
        while((line = bufferedReader.readLine()) != null) {
          System.out.println(line);
        }   
        
        bufferedReader.close();   //Close reader.      
      }   
      catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + file + "'");                
      }
      catch(IOException ex) {
        System.out.println("Error reading file '" + file + "'");                  
      }
    }else{
      System.out.println("No such book exists.");
    }
  }
}
