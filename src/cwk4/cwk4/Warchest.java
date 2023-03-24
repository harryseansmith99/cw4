package cwk4;
/**
 * A warchest starts with 1000 bitcoins and this number can increase or decrease.
 */
public class Warchest {
    
    //fields
    private int bitcoins;

    /**
     * Constructor which creates a warchest with a set amount of bitcoins (1000).
     */
    public Warchest(){
        bitcoins = 1000;
    }
    /**
     * Mutator method which adds funds into the warchest.
     * @param btc is the number of bitcoins to be added.
     */
    public void addFunds(int btc) {
        bitcoins += btc;
    }
    /**
     * Mutator method which reduces funds from warchest.
     * @param btc is the number of bitcoins to reduce by.
     */
    public void reduceFunds(int btc) {
        bitcoins -= btc;
    }
    /**
     * Getter method which returns a String containing all relevant information of the warchest.
     * @return a String containing all relevant information of the warchest */   
    public String toString() {
            String s = "Bitcoins: " +bitcoins+ " btc";
            return s;
        }
}
