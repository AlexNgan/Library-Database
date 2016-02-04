/* Author: Gloria Ngan
 * 
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */ 

public abstract Borrower{
  private String name;
  
  //Constructor.
  public Borrower(String n){
    name = n;
  }
}
