import java.util.Hashtable;

/**
 * This is the Library class which inherits from Building, it has a hashtable for its book collection as well as methods for browsing and editing the collection
 */
public class Library extends Building{
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for the library class, initially sets the collection of books as empty
   * @param name the name of the library
   * @param address the library's address
   * @param nFloors how many floors the library has
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  /**
   * Method for adding a title to the library's collection
   * @param title the title of the book being added
   */
  public void addTitle(String title){
    //not checking if it's already a book because there may be multiple copies
    this.collection.put(title, true);
  }

  /**
   * Method for removing a title from the library, first checking that the title already exists in the collection
   * @param title the title of the book being removed
   * @return the title of the book which has been removed
   */
  public String removeTitle(String title){
    if(this.containsTitle(title)){ //checks if the title exists before trying to remove it
      this.collection.remove(title);
      System.out.println(title + " has been removed from " + this.name + " libaray.");
    } else {
      System.out.println(title + " is not a book in " + this.name + " library. It cannot be removed.");
    }
    return title;
  }

  /**
   * Method for checking out a book from the library, changes the value of the book to unavailable, or false
   * first checks to make sure the title exists at the library, and is available
   * @param title the title being checked out
   */
  public void checkOut(String title){
    if(this.containsTitle(title)){ //does the title exist in the collection
      if(this.isAvailable(title)){ //is the book currently available
        this.collection.replace(title, false); //makes the book unavailable
      } else {
        System.out.println("I'm sorry, " + title + " is currently checked out.");
      } 
    } else {
      System.out.println(title + " does not exist in the " + this.name + " library collection, it may not be checked out.");
    }
  }

  /**
   * Method for returning a book to the library, changes its status back to being available, 
   * first checks if the book belongs to the library (You shouldn't return a book that doesn't belong to the library).
   * @param title the book being returned
   */
  public void returnBook(String title){
    if(this.containsTitle(title)){ //does this book exist in the collection
      this.collection.replace(title, true); //makes the book available for other patrons
    } else {
      System.out.println(title + "is not in the " + this.name + "library collection. It cannot be returned. Please find the library it belongs to.");
    }
  }

  /**
   * Method for seeing if a certain book exists in the library collection
   * @param title the book you want to see if it is in the collection
   * @return boolean true/false the book exists in the library
   */
  public boolean containsTitle(String title){
    if(this.collection.containsKey(title)){
      return true;
    } else {
        return false;
    }
  }

  /**
   * method for checking if a given title is available in the library, 
   * first checking if it is a part of the library's collection
   * @param title the title you want to check the availability of
   * @return boolean true/false is it or is it not available
   */
  public boolean isAvailable(String title){
    if(this.containsTitle(title)){
      return this.collection.get(title);
    } else {
      return false;
    }
  }

  /**
   * Method for printing out the librarys collection, as well as the availability of the books as being true or false
   */
  public void printCollection(){
    System.out.println(this.name + " library contains:");
    System.out.println(this.collection.toString());
  }

  /**
   * The main method of Library, used for testing the methods of the class
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Library nielson = new Library("Nielson", "Nielson rd", 3);
    String book = "wuthering heights";
    nielson.containsTitle(book);
      
  }
  
}
