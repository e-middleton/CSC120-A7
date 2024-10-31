/**
 * Cafe class, with attributes for inventory of coffee, sugar, cream (splashes), and cups with methods for sale and restock
 */
public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for the Cafe class
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     * @param nCoffeeOunces number of ounces of coffee in the inventory
     * @param nSugarPackets number of sugar packets in the inventory
     * @param nCreams number of (splashes) of cream in the inventory
     * @param nCups number of cups in the inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method for selling coffee, restocks the inventory if it is too low for a certain sale
     * @param size number of ounces of coffee are in the order
     * @param nSugarPackets number of sugar packets in the order
     * @param nCreams number of (splashes) of cream in the order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces - size >= 0){
            this.nCoffeeOunces -= size;
        } else {
            this.restock(20, 0, 0, 0);
        }
        if(this.nSugarPackets - nSugarPackets >= 0){
            this.nSugarPackets -= nSugarPackets;
        } else {
            this.restock(0, 10, 0, 0);
        } 
        if(this.nCreams - nCreams >= 0){
            this.nCreams -= nCreams;
        } else{
            this.restock(0, 0, 10, 0);
        }
        if(this.nCups > 0){
            this.nCups -= 1;
        } else{
            this.restock(0, 0, 0, 5);
        }
        System.out.println("Enjoy your coffee!");
    }

    /**
     * Method for restocking the inventory, called if the available amount of an item is too low to make a sale
     * @param nCoffeeOunces number of coffee ounces being added
     * @param nSugarPackets number of sugar packets being added
     * @param nCreams number of (splashes) of cream being added
     * @param nCups number of cups being added
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        //is there a way to set it back to the original values from when the instance was initialized?
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Don't worry, we just restocked!");
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(size, sugar, cream)");
    }

    /**
     * Main method for the Cafe class, used for testing
     * @param args command line prompts
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "Location", 1, 100, 100, 100, 100);
        //myCafe.sellCoffee(24, 10, 14);
        //myCafe.sellCoffee(200, 0, 0);
        myCafe.showOptions();

    }
    
}