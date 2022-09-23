/**
 * This class is responsible for defining a GCart object
 * @author Harsh Kuddu
 */
public class GCart {
    private int length=110;
    // 110 centimeters
    private int capacity=100800;
    // 100,800 volume of items;
    private int width=35;
    // 35 cm
    private int height=70;
    // 70 centimeters;
    private Crate[][] crates;
    private String ID;
    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public GCart(String ID){
        crates= new Crate[5][4];
        this.ID=ID;
        // A GCart can only hold 4 by 5 crates, so we know the fixed value and dont need an arrayList;
    }

    /**
     * Geting the capcity of the GCart
     * @return the capacity
     * @author Harsh Kuddu
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Geting the height of the GCart
     * @return the height
     * @author Harsh Kuddu
     */
    public int getHeight() {
        return height;
    }
    /**
     * Getting the length of the GCart
     * @return the length
     * @author Harsh Kuddu
     */
    public int getLength() {
        return length;
    }
    /**
     * Geting the width of the GCart
     * @return the width
     * @author Harsh Kuddu
     */
    public int getWidth() {
        return width;
    }
    /**
     * Geting the Crates of the GCart
     * @return 2D array of Crates
     * @author Harsh Kuddu
     */
    public Crate[][] getCrates() {
        return crates;
    }
    /**
     * Geting the ID of the GCart
     * @return the ID
     * @author Harsh Kuddu
     */
    public String getID() {
        return ID;
    }

    /**
     * Checking if the GCart is Full
     * @return True or False
     * @author Harsh Kuddu
     */
    public boolean isFull(){
        for(int i=0;i<5;i++){
            for(int k=0;k<4;k++){
                if(crates[i][k]==null){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Getting a crate from the GCart
     * @return A crate otherwise throw new RuntimeExcpetion
     * @author Harsh Kuddu
     */
    public Crate takeOutCrate(){
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                if(crates[i][j]!=null){
                    Crate crate=new Crate(crates[i][j],crates[i][j].getID());
                    crates[i][j]=null;
                    return crate;
                }
            }


        }
        throw new RuntimeException();
    }

    /**
     * Checking if the GCart is not empty
     * @return True or False
     * @author Harsh Kuddu
     */
    public boolean hasItems(){
        for(int i=0;i<5;i++){
            for(int k=0;k<4;k++){
                if(crates[i][k]!=null){
                    return true;
                }
            }
        }
        return false;
    }

}
