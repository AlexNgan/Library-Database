/* Author: Gloria Ngan
 * 
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */ 

public abstract class Borrower{
  private String name;
  private String ID;
  
  //Constructor. Params for name and ID of user.
  public Borrower(String n, String i){
    name = n;
    ID = i;
  }
  
  public abstract Boolean allowBorrow(int time);
}
