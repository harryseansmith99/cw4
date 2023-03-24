package cwk4;

public class Force {

    // Fields
    public String reference;
    public String name;
    public ForceState state;
    public int strength;
    public int activationFee;

    /**
     * Constructor which creates a force with a reference, name, strength, and activation fee.
     */
    public Force(String reference, String name, int strength, int activationFee) {
        reference = this.reference;
        name = this.name;
        strength = this.strength;
        activationFee = this.activationFee;
        ForceState state = ForceState.DOCKED;
    }
    /**
     * Getter method which returns force's reference
     * @return force reference
     */
    public String getReference() {
        return reference;
    }
    /**
     * Getter method which returns force's name
     * @return force name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter method which returns force's state
     * @return force state
     */
    //public int getState() {

    //}
    /**
     * Mutator method which updates force's state
     * @param st is the state which the force will be updated to.
     */
    //public void changeState(String st) {

    //}
    /**
     * Getter method which returns force's strength
     * @return force strength
     */
    public int getStrength() {
        return strength;
    }
    /**
     * Getter method which returns force's activation fee
     * @return force activation fee
     */
    public int getActivationFee() {
        return activationFee;
    }
    /**
     * Getter method which returns all relevant information related to this force.
     * @return all relevant information related to this force
     */
    public String toString() {
        String s =  "\nRef: " +reference+
                    "\nName: " +name+
                    "\nState: " +state+
                    "\nStrength: " +strength+
                    "\nActivation Fee: " +activationFee;
        return s;
    }
}
