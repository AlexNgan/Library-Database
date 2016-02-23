import java.lang.String;

/* Author: Gloria Ngan
 * 
 * This class regulates students borrowing books. Restrictions
 * include a two book limit and a two week limit on borrowed
 * material.
 */ 

public class StudentBorrower extends Borrower{
  //Fields for each borrower's info.
  //private String OSIS;
  //private String name;            //Name.
  private int grade;              //Grade.
  private String offClass;        //Homeroom.
  private int borrowTime = 14;    //Two week limit on borrowed material.
  private int borrowLimit = 2;    //Two book limit.
  
  public StudentBorrower(String ID, String n, int g, String c){
    super(n, ID);
    grade = g;
    offClass = c;
  }
}
