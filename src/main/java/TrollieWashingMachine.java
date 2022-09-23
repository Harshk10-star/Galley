import java.util.ArrayList;

/**
 * This class is responsible for defining a cleaning Trolleys
 * @author Harsh Kuddu
 */
public class TrollieWashingMachine {
    private ArrayList<Trollie> cleanTrollies=new ArrayList<>();
    private int width=1800;
    //in cm;
    private int length=5000;
    //in cm;
    private int height=1900;
    //in cm;
    private ArrayList<Trollie> trolliesDirty=new ArrayList<>();
    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public TrollieWashingMachine(){

    }

    /**
     * Adding a trolley
     * @param trollie The trolley Object
     * @author Harsh Kuddu
     */
    public void addTrollies(Trollie trollie){
            trolliesDirty.add(trollie);
    }

    /**
     * Getting all the clean trolleys
     * @return An array of trolleys
     */
    public ArrayList<Trollie> getCleanTrollies() {
        return cleanTrollies;
    }

    /**
     * For cleaning the trolleys
     * @author Harsh Kuddu
     */
    public void cleanTrollies() {
        if (trolliesDirty.size() == 0) throw new RuntimeException();
        for (int i = 0; i < trolliesDirty.size(); i++) {
            trolliesDirty.get(i).setClean();
            cleanTrollies.add(trolliesDirty.get(i));
        }

        trolliesDirty.clear();
    }







}
