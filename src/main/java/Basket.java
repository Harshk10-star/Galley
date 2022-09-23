/**
 * This class is responsible for defining a basket object
 * @author Harsh Kuddu
 */

public class Basket {
    String color="light brown";
    int capacity=6300;
    int lenght=25;
    int width=12;

    /**
     * Constructor
     * @author Harsh Kuddu
     */
    public Basket(){

    }

    /**
     * Getting the color of the basket
     * @return Name of the color
     * @author Harsh Kuddu
     */
    public String getColor() {
        return color;
    }

    /**
     * Getting the capacity
     * @return The amount of capacity
     * @author Harsh Kuddu
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Getting the width of the basket
     * @return The width of the basket
     * @author Harsh Kuddu
     */
    public int getWidth() {
        return width;
    }
    /**
     * Getting the length of the basket
     * @return The length of the basket
     * @author Harsh Kuddu
     */
    public int getLenght() {
        return lenght;
    }
}
