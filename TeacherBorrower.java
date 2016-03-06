/* Author: Gloria Ngan
 * 
 * This class regulates teachers borrowing books. Restrictions
 * include a one book limit and a three week limit on borrowed
 * material.
 */ 

public class TeacherBorrower extends Borrower{
  private String teacherName;
  private String teacherID;
  private int borrowLimit = 1;    //One book limit.
  private Boolean canBorrow;
  
  public TeacherBorrower(String name, String ID){
    super(name, ID);
    teacherName = name;
    teacherID = ID;
  }
  
  public Boolean allowBorrow(int borrowTime){
    if(borrowTime > 21)
      return false;
    else
      return true;
  }
  
  public String toString(){
        return teacherName + ", " + teacherID;
    }
}
