/* Author: Gloria Ngan
 * 
 * This is an interface with abstract methods
 * that will be defined by client classes MainLibrary
 * and SmallLibrary.
 */

public Interface Library{
  
  addNewBook();
  removeOldBook();
  borrowBook();
  returnBook();
}
