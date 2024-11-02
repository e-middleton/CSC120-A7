import java.util.ArrayList;
/**
 * This is the House class which inherits from Building and has an ArrayList of residents, boolean for Dining Room, and methods for moving in and out
 */
public class House extends Building{ //inherits from Building class (subclass)
  private ArrayList<String> residents; //who lives in this house?
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for the House class
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors how many floors the house has
   * @param hasDiningRoom whether or not the house contains a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); //set up house using building constructor
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * method for checking whether or not the house has a dining room
   * @return boolean true/false the house has or doesn't have a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public boolean hasElevator(){
    return this.hasElevator;
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
    if(!(this.isResident(name))){ //checks to see if a perosn is not a resident already
      residents.add(name);
      //System.out.println("Welcome to " this.name + ", " + name + "!");
    } else {
      throw new RuntimeException("This person is already resident"); //technically makes it so that people of the same name cannot live in the same house
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
        return name;
    } else{
      throw new RuntimeException(name + " is not a resident in " + this.name + " they are unable to move out.");
    }
  }

  //moves out all residents
  public void moveOut(){
    int originalResidents = this.nResidents(); //index variable to prevent indexing problems with .size shrinking when people move out
    if(originalResidents!= 0){
      for(int i = 0; i < originalResidents; i++){
        System.out.println(this.residents.get(0) + " has moved out of " + this.name + ".");
        this.residents.remove(0);
      } System.out.println(this.name + " is empty.");
    } else{
      System.out.println(this.name + " has no residents to move out.");
    }
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

  public void goToFloor(int floorNum) {
    if (this.hasElevator){ //if there is an elevator in the house, you can pop around as u please
      super.goToFloor(floorNum);
    } else{
      if((floorNum - this.activeFloor) == 1 || (floorNum - this.activeFloor) == -1){
        super.goToFloor(floorNum);
      } else{
        throw new RuntimeException("You cannot go directly from floor " + this.activeFloor + " to floor " + floorNum + ". There is no elevator.");
      }
    }
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(name) \n + moveOut(name) \n + isResident(person)");
  }

  /**
   * Main method for the house function, used for testing methods
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    House morrow = new House ("Morrow", "Paradise Road", 5, false, true);
    String student = "Jenny";
    morrow.moveIn(student);
    String student2 = "Jeremy";
    String student3 = "Maeve";
    String student4 = "Huiying";
    morrow.moveIn(student2);
    morrow.moveIn(student3);
    morrow.moveIn(student4);
    morrow.moveOut();
    

  }
}