/* Author: Mortyyy
 * 
 * This class regulates teachers borrowing books. Restrictions
 * include a one book limit and a three week limit on borrowed
 * material.
 */ 

public class TeacherBorrower extends Borrower{
  private String teacherName;
  private String teacherID;
  private Boolean canBorrow;
  
  public TeacherBorrower(String name, String ID){
    super(name, ID);
    teacherName = name;
    teacherID = ID;
  }
  
  /*
   * Teachers can only borrow 2 books at a time, for
   * 14 days each. If either of these conditions is
   * exceeded, the teacher cannot borrow books.
   * Params: Time the book has been borrowed for and
   * the number of books borrowed.
   */ 
  public Boolean allowBorrow(int borrowTime, int bookCount){
    if(borrowTime >= 21 || bookCount >= 1)
      return false;
    else
      return true;
  }
  
  public String toString(){
        return teacherName + ", " + teacherID;
    }
}
