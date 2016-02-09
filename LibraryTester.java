import java.util.Scanner;

/* Author: Gloria Ngan (all right but what about me, Crystal Lee)
 * 
 * This is the main class for the library database. Requires
 * Book, Borrower, Library, StudentBorrower, and TeacherBorrower.
 */ 

public class LibraryTester{
  
  static String fileName = null;
  static Library lib = new Library();
  static Scanner scan = new Scanner(System.in);
  static Boolean isRunning = true;
  
  public static void main(String[] args){
    while (isRunning) {
      System.out.println("\nEnter 1 to load library." + "\nEnter 0 to quit.");
      
      int ans = scan.nextInt();
      
      switch(ans){ //I'm not sure if this is how you use switch statements
      case 0:
      
      case 1:
        System.out.println("Enter your file"); 
        loadFile(scan.next());
        break;
        }
    }
  }
  
  private static void loadFile(String name){
        //do we need fileinputstream and objectinput stream bc i have no idea how to use those
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        File file = new File(name);
        if (file.exists()){
        try {
          fis = new FileInputStream(file);
          ois = new ObjectInputStream(fis);
          lib = (Library) ois.readObject();
          fis.close();
          ois.close();
          
          } else {
            System.out.println("\nThe file doesn't exist.");
        }
        break;
      }
  }

  private static void quit(){
    System.out.println("Enter file name: ");
    fileName = scan.next() + ".txt";
    isRunning = false;
    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream(fileName);
      out = new ObjectOutputStream(fos);
      out.writeObject(lib);
      fos.close();
      out.close();
}
