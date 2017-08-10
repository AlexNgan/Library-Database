import java.lang.String;

/* Author: Alex
 * 
 * This class regulates students borrowing books. Restrictions
 * include a two book limit and a two week limit on borrowed
 * material.
 */ 

public class StudentBorrower extends Borrower{
  //Fields for each borrower's info.
  private String name;
  private String OSIS;
  private String grade;              
  private String offClass;       
  private int borrowLimit = 2;    //Two book limit.
  private Boolean canBorrow;
  
  //Constructor.
  public StudentBorrower(String ID, String n, String g, String c){
    super(n, ID);
    OSIS = ID;
    name = n;
    grade = g;
    offClass = c;
  }
  
  /*
   * Students can only borrow 2 books at a time, for
   * 14 days each. If either of these conditions is
   * exceeded, the student cannot borrow books.
   * Params: Time the book has been borrowed for and
   * the number of books borrowed.
   */ 
  public Boolean allowBorrow(int borrowTime, int bookCount){
    if(borrowTime >= 14 || bookCount >= 2)
      return false;
    else
      return true;
  }
  
  //Converts object to String.
  public String toString(){
        return name + ", " + OSIS + ", grade: " + grade + ", class: " + offClass;
    }
}
