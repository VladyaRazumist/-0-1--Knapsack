/**
 * A class representing an item of the loot.
 * @author nicolas et hadrien, refactoring by a.melnikov
 */
public class Item {

    /**
     * Index of the item
     */
    private int idx;

    /**
     * Weight of the item
     */
    private int weight;

    /**
     * Value of the item
     */
    private double value;

    /**
     * Builds an item of the loot.
     * @param idx: index of the item
     * @param weight: weight of the item
     * @param value: value (in dollars) in the item
     */
    public Item(int idx, int weight, double value) {
        this.idx = idx;
        this.weight = weight;
        this.value = value;
    }
    
    /**
     * @return index of the item
     */
    public int Idx() {
        return idx;
    }

    /**
     * @return weight of the item
     */
    public int Weight() {
        return weight;
    }
    
    /**
     * @return monetary value (dollars) of the item
     */
    public double Value() {
        return value;
    }

    public String ToString() {
        return "idx="+idx+"\tw="+weight+"\tv="+value;
    }
   
}
