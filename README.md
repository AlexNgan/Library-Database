# Library-Database
This is a Java project designed to act as a library's database system.
The program takes input in the form of a .txt file to hold a database 
of books with their titles, status, quality, and ISBN. Students and 
teachers can borrow books with different parameters, such as the number
of books which a certain person can borrow or the time which a book may
be checked out.

The program includes text files to be read by the program and certain classes:
- Class Book
- Class Library with methods (addNewBook(), removeOldBook(), borrow(), return() etc.)
- Abstract class Borrower
- Class Student extends abstract class Borrower
- Class Teacher extends abstract class Borrower
- Class Runner to read .txt files and interact with the user.
