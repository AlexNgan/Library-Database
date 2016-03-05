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
  private int borrowTime = 14;    //Two week limit on borrowed material.
  private int borrowLimit = 2;    //Two book limit.
  
  //Constructor.
  public StudentBorrower(String ID, String n, String g, String c){
    super(n, ID);
    OSIS = ID;
    name = n;
    grade = g;
    offClass = c;
  }
  
  //Converts object to String.
  public String toString(){
        return name + ", " + OSIS + ", grade: " + grade + ", class: " + offClass;
    }
}
