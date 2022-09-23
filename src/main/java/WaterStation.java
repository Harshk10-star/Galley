import java.util.ArrayList;

/**
 * This class is responsible for manipulating water bottles
 *
 * @author Harsh Kuddu
 */
public class WaterStation {
    private ArrayList<GCart> GCarts;
    private ArrayList<WaterBottle> smallStack;
    private ArrayList<WaterBottle> mediumStack;
    private ArrayList<WaterBottle> largeStack;
    private ArrayList<Crate> crates;

    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public WaterStation(){
        GCarts=new ArrayList<>();
        crates=new ArrayList<>();
        smallStack=new ArrayList<>();
        mediumStack=new ArrayList<>();
        largeStack=new ArrayList<>();
        for(int i=0;i<360;i++){
            smallStack.add(new WaterBottle(350,"waterSmall"));
            mediumStack.add(new WaterBottle(550,"waterMedium"));
            largeStack.add(new WaterBottle(1500,"waterLarge"));

        }

    }
    //filling a crate with a ceartain type of water
    //refill stack back to 30

    /**
     *This method refills the water Stacks
     *
     * @author Harsh Kuddu
     */
    public void refillStacks(){
        int small=360-smallStack.size();
        int medium=360-mediumStack.size();
        int large=360-largeStack.size();
        for(int i=0;i<small;i++){
            smallStack.add(new WaterBottle(350,"waterSmall"));
        }
        for(int i=0;i<medium;i++){
            mediumStack.add(new WaterBottle(550,"waterMedium"));
        }
        for(int i=0;i<large;i++){
            largeStack.add(new WaterBottle(1500,"waterLarge"));
        }

    }

    /**
     * Adds a crate
     *
     * @param crate A crate object
     *
     * @author Harsh Kuddu
     */
    public void addCrate(Crate crate){
        crates.add(crate);
    }
    //filling up crate wit ha crertain type of water;

    /**
     * Fills a crate with a certain type of water
     * @param typeW the type of water; "waterSmall","waterMedium", and "waterLarge"
     * @author Harsh Kuddu
     */
    public void makeWater(String typeW){
        int volume;
        if(typeW.equals("waterSmall") && smallStack.size()>=18){
            volume=350;
        }else if(typeW.equals("waterMedium") && mediumStack.size()>=11){
            volume=550;
        }else if(typeW.equals("waterLarge") && largeStack.size()>=4){
            volume=1500;
        }else{
            throw new RuntimeException();
        }
        //making from an empty crate
        int i=0;
        int crateInd=0;
        boolean getCrate=false;
        while(getCrate==false && i<crates.size()){
            if(crates.get(i).checkIfEmpty()){
                crateInd=i;
                getCrate=true;
            }
            i++;
        }
        if(!getCrate) throw new RuntimeException();
        //no empty crates left need more
        int amount=crates.get(crateInd).getCapacity()/volume;
        int temp=amount;
        for(int k=0;k<amount;k++){
            if(volume==350){
                crates.get(crateInd).add(smallStack.get(0));
                smallStack.remove(0);

            }else if(volume==550){
                crates.get(crateInd).add(mediumStack.get(0));
                mediumStack.remove(0);
            }else if(volume==1500) {
                crates.get(crateInd).add(largeStack.get(0));
                largeStack.remove(0);
            }else{
                throw new RuntimeException();
            }

        }
        //adding water into crate


    }


    /**
     * Taking out a crate from a GCart
     * @param row The row where the crate is at
     * @param col The col where the crate is at
     * @param GCartID ID of GCArt
     * @param crateID ID of Crate
     * @return if the crate is not at the top throw new RuntimeException otherwise return the desired crate
     */
    public Crate getCrate(int row,int col, String GCartID,String crateID){
        //taking out crate from G-Cart you can only take out the top of it at a time
        int GCartInd=0;
        for(int i=0;i<GCarts.size();i++){
            if(GCarts.get(i).getID().equals(GCartID)){
                GCartInd=i;
            }
        }
        int crateInd=0;
        for(int k=0;k<crates.size();k++){
            if(crates.get(k).getID().equals(crateID)){
                crateInd=k;
            }
        }
        Crate crate=new Crate(GCarts.get(GCartInd).getCrates()[row][col],crateID);
        //we cant take the crate at the bottom if there are crates above it
        for(int i=row;i>=0;i--){
            if(GCarts.get(GCartInd).getCrates()[i][col]!=null && i>row){
                throw new RuntimeException();
            }
        }
        GCarts.get(GCartInd).getCrates()[row][col]=null;

        return crate;
    }

    /**
     * Filling up a GCart with crates
     * @param GCartID
     * @author Harsh Kuddu
     */
    public void fillCart(String GCartID){
        //if(GCarts.size()==0 || crates.size()==0 || crates.size()>=20) throw new RuntimeException();
        int GCartInd=0;
        for(int i=0;i<GCarts.size();i++){
            if(GCarts.get(i).getID().equals(GCartID)){
                GCartInd=i;
            }

        }
        if(GCarts.get(GCartInd).isFull()) throw new RuntimeException();
        for(int i=0;i<5;i++){
            for(int k=0;k<4;k++){
                GCarts.get(GCartInd).getCrates()[i][k]=crates.get(0);
                crates.remove(0);
            }

        }
    }

    /**
     * This is for adding a crate to a GCart
     * @param CartID The ID of the GCart
     * @param crateID The ID of the crate
     * @param col The col where you want to put the crate
     * @author Harsh Kuddu
     */
    public void addWater(String CartID,String crateID,int col){
        int GCartInd=0;
        for(int i=0;i<GCarts.size();i++){
            if(GCarts.get(i).getID().equals(CartID)){
                GCartInd=i;
            }
        }
        int crateInd=0;
        for(int k=0;k<crates.size();k++){
            if(crates.get(k).getID().equals(crateID)){
                crateInd=k;
            }
        }
        for(int i=0;i<5;i++){
            if(GCarts.get(GCartInd).getCrates()[i][col]!=null && GCarts.get(GCartInd).getCrates()[i-1][col]==null ){
                GCarts.get(GCartInd).getCrates()[i-1][col]=crates.get(crateInd);
                return;
            }

        }
        throw new RuntimeException();
    }

    /**
     * Adding a GCart
     * @param Gcart
     * @author Harsh Kuddu
     */
    public void addGCart(GCart Gcart){
        GCarts.add(Gcart);
    }

    /**
     * Getting all the GCarts
     * @author Harsh Kuddu
     * @return An array of GCarts
     */
    public ArrayList<GCart> getGcart(){
        return GCarts;
    }

    /**
     * Getting all the crates
     * @author Harsh Kuddu
     * @return An array of crates
     */
    public ArrayList<Crate> getCrates(){return crates;}

    /**
     * Getting the stack of small water Bottles
     * @author Harsh Kuddu
     * @return An array of water bottles
     */
    public ArrayList<WaterBottle> getSmallStack() {
        return smallStack;
    }
    /**
     * Getting the stack of medium water Bottles
     * @author Harsh Kuddu
     * @return An array of water bottles
     */
    public ArrayList<WaterBottle> getMediumStack() {
        return mediumStack;
    }
    /**
     * Getting the stack of large water Bottles
     * @author Harsh Kuddu
     * @return An array of water bottles
     */
    public ArrayList<WaterBottle> getLargeStack() {
        return largeStack;
    }
}
