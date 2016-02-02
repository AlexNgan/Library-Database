/* Author: Gloria Ngan
 * 
 */

public class Library{
  //Untested; ArrayList of Strings or Book objects???.
  private ArrayList<Book> database = new ArrayList<Book>();     //Holds all books.
  
  //Constructor.
  public Library(){
    //Need to import books from .txt file.
  }
  
  //Modifier method to add a books to database.
  public addNewBook(Book book){
    database.add(book);
  }
  
  //Modifier method to remove books from database.
  public removeOldBook(Book book){
    database.remove(book);
  }
  
  //Method to mark a book as borrowed if it is available.
  public borrowBook(){
    
  }
  
  returnBook();
}
