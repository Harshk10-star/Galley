/**
 * This class is responsible for defining a water bottle object
 * @author Harsh Kuddu
 */
public class WaterBottle {
    private int volume;
    private String type;
    private String material;
    /**
     * Constructor defult values
     * @author Harsh Kuddu
     */
    public WaterBottle(){
        volume=350;
        type="waterSmall";
        material="plastic";
    }
    /**
     * Constructor with two parameters
     * @author Harsh Kuddu
     */
    public WaterBottle(int volume,String type){
        this.volume=volume;
        this.type=type;
        this.material="plastic";
    }

    /**
     * getting volume of the water bottle
     * @return the volume
     * @author Harsh Kuddu
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Getting Material
     * @return the material
     * @author Harsh Kuddu
     */

    public String getMaterial() {
        return material;
    }

    /**
     * Getting the type of water bottle
     * @return the type ; "waterSmall","waterMedium", and "waterLarge"
     */
    public String getType() {
        return type;
    }
}

