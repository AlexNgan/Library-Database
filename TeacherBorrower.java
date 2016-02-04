/* Author: Gloria Ngan
 * 
 * This class regulates teachers borrowing books. Restrictions
 * include a one book limit and a three week limit on borrowed
 * material.
 */ 

public class TeacherBorrower extends Borrower{
  //Fields for teacher info.
  private String name;
  private String teacherID;
  private int borrowTime = 21;
  private borrowLimit = 1;
}
