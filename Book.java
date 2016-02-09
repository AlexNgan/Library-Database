/* Author: Gloria Ngan 
 * 
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

public class Book{
  private String title, author, status;     //For title, author, and the physical condition of the book.
  private double borrowDate;                //Double for the date the book was checked out.
  private boolean isAvailable = true;       //Boolean for whether the book is borrowed or not.
  private int isbn;                         //???? Not sure if she wanted us to include this?????
  
  //Constructor.
  public Book(String t, String a, String s, int isbn){
    this.title = t;
    this.author = a;
    this.status = s;
    this.isbn = isbn;
  }
  
  //Modifier method to mark book as unavailible.
  public void makeBorrowed(){
    isAvailable = false;
  }
  
  //Modifier method to mark a book as availible.
  public void makeReturned(){
    isAvailable = true;
  }
  
  @Override
  public String toString(){
    return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nStatus: " + status;
  }
}
