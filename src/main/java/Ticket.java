import java.util.ArrayList;
/**
 * This class is responsible for defining a ticket object
 * @author Harsh Kuddu
 */
public class Ticket {
    // A ticked it a piece of paper with items listed on it
    //Note each index of "ticket" has to filled into a single crate, so if the length is 5 taht 5 creates are to be made
    ArrayList<String> items;
    int length=6;
    // 8 centimeters
    int width=8;
    // 8 centimeters
    String material="paper";
    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public Ticket(){
        items=new ArrayList<>();
    }

    /**
     * Getting the items listed on the ticket
     * @return An array of items
     * @author Harsh Kuddu
     */
    public ArrayList<String> getItems() {
        return items;
    }

    /**
     * Getting the length of the ticket
     * @return The length of the ticket
     * @author Harsh Kuddu
     */
    public int getLength() {
        return length;
    }
    /**
     * Getting the width of the ticket
     * @return The width of the ticket
     * @author Harsh Kuddu
     */
    public int getWidth() {
        return width;
    }

    /**
     * adding an item to the ticket
     * @param item String name
     * @author Harsh Kuddu
     */
    public void addItem(String item){
        items.add(item);
    }
    /**
     * removing an item to the ticket
     * @param item String name
     * @author Harsh Kuddu
     */
    public void removeItem(String item){
        items.remove(item);
    }
}
