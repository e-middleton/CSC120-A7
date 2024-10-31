import java.util.ArrayList;
/**
 * This is the House class which inherits from Building and has an ArrayList of residents, boolean for Dining Room, and methods for moving in and out
 */
public class House extends Building{ //inherits from Building class (subclass)
  private ArrayList<String> residents; //who lives in this house?
  private Boolean hasDiningRoom;

  /**
   * Constructor for the House class
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors how many floors the house has
   * @param hasDiningRoom whether or not the house contains a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //set up house using building constructor
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * method for checking whether or not the house has a dining room
   * @return boolean true/false the house has or doesn't have a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * method for seeing how many residents live in a house
   * @return the number of residents currently living in the house
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * method for moving a person into the house.
   * Before moving in, it checks if the person is not already resident
   * @param name the name of the person who wants to move in
   */
  public void moveIn(String name){
    try { 
      if(!(this.isResident(name))){ //checks to see if a perosn is not a resident already
        residents.add(name);
        System.out.println("Welcome to Morrow, " + name + "!");
      } else {
        throw new RuntimeException("This person is already resident"); //technically makes it so that people of the same name cannot live in the same house
      }
    } catch (RuntimeException e){
      System.out.println(e + ", cannot move in.");
    }
  }

  /**
   * removes a person from the arraylist of residents, first checking if they were a resident at all
   * @param name the name of the person moving out
   * @return the name of the person who has moved out
   */
  public String moveOut(String name){
    if(this.isResident(name)){ //checks if a person is a resident
        residents.remove(name);
    } else{
      System.out.println(name + " is not a resident in " + this.name + " they are unable to move out.");
    }
    return name;
  }

  /**
   * Method for checking is a person is a resident in a given house
   * @param person the name of the person who you want to check if they live in the house
   * @return boolean true/false whether or not the person lives in the given house
   */
  public boolean isResident(String person){
    if (residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Main method for the house function, used for testing methods
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    House Morrow = new House ("Morrow", "Paradise Road", 5, false);
    String student = "Jenny";
    Morrow.moveIn(student);
    int ppl = Morrow.nResidents();
    System.out.println(ppl);
    System.out.println(Morrow.isResident("Jenny"));

  }

}