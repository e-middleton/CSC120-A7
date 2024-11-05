import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);
        House morrow = new House("Morrow", "Paradise Road", 4, false, false);
        myMap.addBuilding(morrow);
        Cafe compass = new Cafe("Compass Cafe", "Campus Center", 1);
        myMap.addBuilding(compass);
        Building sabinReed = new Building("Sabin Reed", "Campus Road", 5);
        myMap.addBuilding(sabinReed);
        House tyler = new House("Tyler", "Near Sabin Reed", 12, true, false);
        myMap.addBuilding(tyler);
        Cafe familiars = new Cafe("Familiars", "Somewhere in Northampton", 1);
        myMap.addBuilding(familiars);
        Library nielson = new Library("Nielson", "Nielson rd", 4);
        myMap.addBuilding(nielson);
        House chapin = new House("Chapin", "Some address?", 4, true, true);
        myMap.addBuilding(chapin);
        Library tinyLibrary = new Library("Tiny Library", "Middle of the Quad", 13);
        myMap.addBuilding(tinyLibrary);
        Building wrightHall = new Building("Wright Hall", "near Nielson Library", 3);
        myMap.addBuilding(wrightHall);

        System.out.println(myMap.buildings.size());
    }
    
}
