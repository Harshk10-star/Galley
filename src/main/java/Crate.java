import java.util.ArrayList;
/**
 * This class is responsible for defining a crate object
 * @author Harsh Kuddu
 */
public class Crate {
    final private double length=25;
    // 25 centimeters;
    final private double width=12.5;
    // 12.5 centimeters;
    final private double height=14;
    // 14 centimeters;
    private int capacity=6300;
    // 10500 volume of items;
    private ArrayList<WaterBottle> waterBottles=new ArrayList<>();
    private ArrayList<HibalGlass> hibalGlasses=new ArrayList<>();
    private ArrayList<Hotspot> hotspots=new ArrayList<>();
    private ArrayList<coffeeCup> coffeeCups=new ArrayList<>();
    private ArrayList<Basket> baskets=new ArrayList<>();

    String ID;
    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public Crate(Crate crate,String ID){
        this.ID=ID;
        waterBottles=crate.getWaterBottles();
        hibalGlasses=crate.getHibalGlasses();
        hotspots=crate.getHotspots();
        coffeeCups=crate.getCoffeeCups();
        baskets=crate.getBaskets();
        this.ID=crate.getID();
    }

    /**
     * Geting ID of crate
     * @param ID The ID
     * @author Harsh Kuddu
     */
    public Crate(String ID){
        this.ID=ID;
    }

    /**
     * Getting ID of crate
     * @return the ID
     * @author Harsh Kuddu
     */
    public String getID() {
        return ID;
    }

    /**
     * Adding HibalGlass to the crate
     * @param item HibalGlass
     * @author Harsh Kuddu
     */
    public void add(HibalGlass item) {
        if(this.capacity-item.capacity<0) throw new RuntimeException();
        hibalGlasses.add(item);
        this.capacity-=item.getCapacity();
    }
    /**
     * Adding Water Bottle to the crate
     * @param item Water Bottle
     * @author Harsh Kuddu
     */
    public void add(WaterBottle item) {
        if(this.capacity-item.getVolume()<0) throw new RuntimeException();
        waterBottles.add(item);
        this.capacity-=item.getVolume();
    }
    /**
     * Adding Hotspot to the crate
     * @param item Hotspot item
     * @author Harsh Kuddu
     */
    public void add(Hotspot item) {
        if(this.capacity-item.capacity<0) throw new RuntimeException();
        hotspots.add(item);
        this.capacity-=item.getCapacity();
    }
    /**
     * Adding Cofee Cup to the crate
     * @param item Coffe Cup item
     * @author Harsh Kuddu
     */
    public void add(coffeeCup item) {
        if(this.capacity-item.capacity<0) throw new RuntimeException();
        coffeeCups.add(item);
        this.capacity-= item.getCapacity();
    }
    /**
     * Adding Basket to the crate
     * @param item Basket item
     * @author Harsh Kuddu
     */
    public void add(Basket item) {
        if(this.capacity-item.capacity<0) throw new RuntimeException();
        baskets.add(item);
        this.capacity-=item.getCapacity();
    }

    /**
     * Removing HibalGlass from the crate
     * @param item Hibal Glass item
     * @author Harsh Kuddu
     */
    public void remove(HibalGlass item){
        hibalGlasses.remove(item);
        this.capacity+=capacity;
    }
    /**
     * Removing basket from the crate
     * @param item basket item
     * @author Harsh Kuddu
     */
    public void remove(Basket item){
        baskets.remove(item);
        this.capacity+=capacity;
    }
    /**
     * Removing Water Bottle from the crate
     * @param item Water bottle item
     * @author Harsh Kuddu
     */
    public void remove(WaterBottle item){
        waterBottles.remove(item);
        this.capacity+=capacity;
    }
    /**
     * Removing Hotpot from the crate
     * @param item Hotspot item
     * @author Harsh Kuddu
     */
    public void remove(Hotspot item){
        hotspots.remove(item);
        this.capacity+=capacity;
    }
    /**
     * Removing coffe Cup from the crate
     * @param item Hibal Glass item
     * @author Harsh Kuddu
     */
    public void remove(coffeeCup item){
        coffeeCups.remove(item);
        this.capacity+=capacity;
    }

    /**
     * Checking if the crate is empty
     * @return True or False
     * @author Harsh Kuddu
     */
    public boolean checkIfEmpty(){
        if(coffeeCups.size()==0 && hibalGlasses.size()==0 && waterBottles.size()==0 && baskets.size()==0 && hotspots.size()==0) return true;
        return false;
    }

    /**
     * Getting all the CoffeCups
     * @return An array of coffeCups
     * @author Harsh Kuddu
     */
    public ArrayList<coffeeCup> getCoffeeCups() {
        return coffeeCups;
    }
    /**
     * Getting all the HibalGlass
     * @return An array of HibalGlass
     * @author Harsh Kuddu
     */
    public ArrayList<HibalGlass> getHibalGlasses() {
        return hibalGlasses;
    }
    /**
     * Getting all the Baskets
     * @return An array of Baskets
     * @author Harsh Kuddu
     */
    public ArrayList<Basket> getBaskets() {
        return baskets;
    }
    /**
     * Getting all the Hotspots
     * @return An array of Hotspots
     * @author Harsh Kuddu
     */
    public ArrayList<Hotspot> getHotspots() {
        return hotspots;
    }
    /**
     * Getting all the WaterBottles
     * @return An array of water bottles
     * @author Harsh Kuddu
     */
    public ArrayList<WaterBottle> getWaterBottles() {
        return waterBottles;
    }

    /**
     * Getting a list of the amount of objects in the crate
     * @return the list of objects
     * @author Harsh Kuddu
     */
    public String getFullInfo(){
        return "There are "+ hibalGlasses.size()+" HibalGlasses, "+baskets.size()+" Baskets, "+ coffeeCups.size()+" Coffe Cups, " +waterBottles.size()+" WaterBottles,and "+ hotspots.size()+" Hotspots";
    }

    /**
     * Getting the capacity of the crate
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

}
