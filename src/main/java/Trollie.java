/**
 * This class is responsible for defining a trolley object
 * @author Harsh Kuddu
 */
public class Trollie {
    Crate[][] crates;
    Ticket ticket;
    int length=50;
    //50 centimeters
    int hight=80;
    //80 centimeters
    boolean isClean;
    String ID;

    /**
     * Getting the ID of the Trolley
     * @return the ID
     * @author Harsh Kuddu
     */
    public String getID() {
        return ID;
    }

    /**
     * Getting the crates of the trolley
     * @return 2D array of crates
     * @author Harsh Kuddu
     */
    public Crate[][] getCrates() {
        return crates;
    }

    /**
     * Adding ticket to the trolley
     * @param ticket The ticket
     * @author Harsh Kuddu
     */
    public void addTicket(Ticket ticket){
        this.ticket=ticket;
    }

    /**
     * This method checks if the trolley is not empty
     * @return True or False
     * @author Harsh Kuddu
     */
    public Boolean hasItems(){
        for(int i=0;i<crates.length;i++){
            for(int k=0;k<crates[i].length;k++){
                if(crates[i][k]!=null) return true;
            }
        }
        return false;
    }

    /**
     * Constructor with two parameters
     * @author Harsh Kuddu
     */
    public Trollie(Ticket ticket,String ID){
        this.ticket=ticket;
        this.isClean=false;
        this.ID=ID;
        crates=new Crate[7][2];
    }
    /**
     * Constructor with one parameter
     * @author Harsh Kuddu
     */
    public Trollie(String ID){
        this.ID=ID;
        this.isClean=false;
        crates=new Crate[7][2];
    }

    /**
     * Setting the trolley to clean
     * @author Harsh Kuddu
     */
    public void setClean(){
        isClean=true;
    }

    /**
     * getting the ticket
     * @return ticket object
     * @author Harsh Kuddu
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Checking if the trolley is Clean
     * @return True or False
     * @author Harsh Kuddu
     */
    public boolean isClean() {
        return isClean;
    }
}
