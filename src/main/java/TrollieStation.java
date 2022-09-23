import java.util.ArrayList;

/**
 * This class is responsible for the setting up of trolleys
 * @author Harsh Kuddu
 */
public class TrollieStation {
    ArrayList<Trollie> trollies;
    private ArrayList<GCart> smallStack;
    private ArrayList<GCart> mediumStack;
    private ArrayList<GCart> largeStack;


    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public TrollieStation(){
        trollies=new ArrayList<>();
        smallStack=new ArrayList<>();
        mediumStack=new ArrayList<>();
        largeStack=new ArrayList<>();
    }

    /**
     * For getting all the Trolleys
     * @return An array of Trolleys
     * @author Harsh Kuddu
     */
    public ArrayList<Trollie> getTrollies() {
        return trollies;
    }

    /**
     * Getting clean Trolleys
     * @param trollieWashingMachine the trollieWashingMachine has clean trolleys that need to be moved
     * @author Harsh Kuddu
     */
    public void getCleanTrollies(TrollieWashingMachine trollieWashingMachine){
        for(int i=0;i<trollieWashingMachine.getCleanTrollies().size();i++){
            trollies.add(trollieWashingMachine.getCleanTrollies().get(i));

        }
        trollieWashingMachine.getCleanTrollies().clear();
    }

    /**
     * Fills a trolley depending on the ticket
     * @param crates An array of crates
     * @param trollieID The ID of the trolley
     * @author Harsh Kuddu
     */
    public  void addToTrollieStation(Crate[] crates , String trollieID){
        if(trollies.size()==0) throw new RuntimeException();
        int trollieInd=0;
        int k=0;
        Boolean cont=true;
        while(cont){
            if(trollies.get(k).getID().equals(trollieID)){
                trollieInd=k;
                cont=false;
            }
        }
        if(trollies.get(trollieInd).getTicket().getItems().size()!=crates.length) throw new RuntimeException();
        //Using the ticket of the trollie to see waht to put inside;
        for(int i=0;i<trollies.get(trollieInd).getTicket().getItems().size();i++){
            String item=trollies.get(trollieInd).getTicket().getItems().get(i);
            if(item.equals("HibalGlass")){
                crates[i]=fillCrateHelper("HibalGlass",262,crates[i]);
            }else if(item.equals("Basket")){
                crates[i]=fillCrateHelper("Basket",6300,crates[i]);
            }else if(item.equals("coffeeCup")){
                crates[i]=fillCrateHelper("coffeeCup",262,crates[i]);
            }else if(item.equals("waterSmall")){
                crates[i]=fillHelperWater("waterSmall");
            }else if(item.equals("waterMedium")){
                crates[i]=fillHelperWater("waterMedium");
            }else if(item.equals("waterLarge")){
                crates[i]=fillHelperWater("waterLarge");
            }else{
                throw new RuntimeException();
            }

        }
        addToTrollieHelper(trollies.get(trollieInd),crates);
    }

    /**
     * This is a helper method that fills a crate with a ceartain object
     * @param type The name of the object
     * @param capacity the amount of space the object takes
     * @param crate the crate that needs to be filled
     * @return the filled crate otherwise throw new runtimeException
     */
    public Crate fillCrateHelper(String type,int capacity, Crate crate){
        int amount=crate.getCapacity()/capacity;
        for(int i=0;i<amount;i++){
            if(type.equals("HibalGlass")){
                crate.add(new HibalGlass());
            }else if(type.equals("coffeeCup")){
                crate.add(new coffeeCup());
            }else if(type.equals("Hotspot")){
                crate.add(new Hotspot());
            }else if(type.equals("Basket")){
                crate.add(new Basket());
            }else{
                throw new RuntimeException();
            }
        }
        return crate;
    }

    /**
     * This is a helper method to get crate filled with a certain water bottle
     * @param type the type of water; "waterLarge","waterMedium", and "waterSmall"
     * @return the type of water crate otherwise throw new runtimeException
     */
    public Crate fillHelperWater(String type){
        int i=0;


        if(type.equals("waterSmall")){
            while(i< smallStack.size()){
                if(smallStack.get(i).hasItems()){
                    return smallStack.get(i).takeOutCrate();
                }
            }
        }else if(type.equals("waterMedium")){
            while(i< mediumStack.size()){
                if(mediumStack.get(i).hasItems()){
                    return mediumStack.get(i).takeOutCrate();
                }
            }
        }else if(type.equals("largeMedium")){
            while( i< largeStack.size()){
                if(largeStack.get(i).hasItems()){
                    return largeStack.get(i).takeOutCrate();
                }
            }
        }
        throw new RuntimeException();
    }

    /**
     * Fills the trolley with crates
     * @param trollie The trolley object
     * @param crate An array of crates
     * @return the trollie
     */
    public Trollie addToTrollieHelper(Trollie trollie,Crate[] crate){
        if(crate.length>14) throw new RuntimeException();
        int i=1;
        int j=0;
        for(int k=0;k<crate.length;k++){
            trollie.getCrates()[j][i]=crate[k];
            if(j>=6){
                j=0;
                i=1;
            }
            j++;
        }
        return trollie;
    }

    /**
     * Getting GCarts from a waterStation
     * @param waterStation A waterStation object
     * @author Harsh Kuddu
     */
    public void getWaterCart(WaterStation waterStation){
        ArrayList<Integer> index=new ArrayList<>();
        for(int i=0;i<waterStation.getGcart().size();i++){
            String item=waterStation.getGcart().get(i).getCrates()[0][0].getWaterBottles().get(0).getType();
            if(waterStation.getGcart().get(i).isFull()){
                if(item=="waterSmall"){
                    smallStack.add(waterStation.getGcart().get(i));

                }else if(item=="waterMedium"){
                    mediumStack.add(waterStation.getGcart().get(i));
                }else{
                    largeStack.add(waterStation.getGcart().get(i));
                }
                index.add(i);
            }
        }
        if(index.size()>0){
            int k=0;
            for(int i=0;i<index.size();i++){
                waterStation.getGcart().remove(waterStation.getGcart().get(index.get(i)-k));
                k++;
            }
        }

    }

    /**
     * Getting all the GCarts that contain large waterBottles
     * @return GCart array
     * @author Harsh Kuddu
     */
    public ArrayList<GCart> getLargeStack() {
        return largeStack;
    }
    /**
     * Getting all the GCarts that contain medium waterBottles
     * @return GCart array
     * @author Harsh Kuddu
     */
    public ArrayList<GCart> getMediumStack() {
        return mediumStack;
    }
    /**
     * Getting all the GCarts that contain small waterBottles
     * @return GCart array
     * @author Harsh Kuddu
     */
    public ArrayList<GCart> getSmallStack() {
        return smallStack;
    }
}
