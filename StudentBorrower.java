import java.lang.String;

/* Author: Gloria Ngan
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
  
  public Boolean allowBorrow(){
    if(borrowTime > 14)
      return false;
    else
      return true;
  }
  
  //Converts object to String.
  public String toString(){
        return name + ", " + OSIS + ", grade: " + grade + ", class: " + offClass;
    }
}
