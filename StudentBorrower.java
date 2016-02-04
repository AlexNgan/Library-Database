/* Author: Gloria Ngan
 * 
 * This class regulates students borrowing books. Restrictions
 * include a two book limit and a two week limit on borrowed
 * material.
 */ 

public class StudentBorrower extends Borrower{
  //Fields for each borrower's info.
  private String OSIS;
  private String name;
  private int grade;
  private String offCLass;
  private int borrowTime = 14;
  private int borrowLimit = 2;
}
