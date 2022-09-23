import java.util.ArrayList;
/**
 * This class is responsible for defining a Galley object
 * @author Harsh Kuddu
 */
public class Galley {
    private ArrayList<WaterStation> waterStations=new ArrayList<>();
    private ArrayList<TrollieStation> trollieStations= new ArrayList<>();
    private ArrayList<TrollieWashingMachine> trollieWashingMachines=new ArrayList<>();
    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public Galley(){

    }

    /**
     * Adding a waterStation
     * @param waterStation WaterStation object
     * @author Harsh Kuddu
     */
    public void addWaterStation(WaterStation waterStation){
        if(waterStations.size()!=0) throw new RuntimeException();
        waterStations.add(waterStation);
    }
    /**
     * Adding a trolley Station
     * @param trollieStation trolley Station object
     * @author Harsh Kuddu
     */
    public void addTrollieStations(TrollieStation trollieStation){
        if(trollieStations.size()>2) throw  new RuntimeException();
        trollieStations.add(trollieStation);
    }

    /**
     * Adding a trolley washing Machine
     * @param trollieWashingMachine
     * @author Harsh Kuddu
     */
    public void addTrollieWashingMachine(TrollieWashingMachine trollieWashingMachine){
        if(trollieWashingMachines.size()>=2) throw new RuntimeException();
        trollieWashingMachines.add(trollieWashingMachine);
    }
}