package cwk4;

/**
 * A child class of Force called Starship which contains a reference, force
 * name, number of photon torpedoes, number of laser cannons and also its
 * activation cost.
 */
public class Starship extends Force {

    // fields
    private int photonTorpedoes;
    private int laserCannons;

    /**
     * Constructor which creates a Starship force with a reference, name, number of
     * photon torpedoes, and number of laser cannons.
     * 
     * @param ref             is the force reference
     * @param name            is the force name
     * @param photonTorpedoes is the number of photon torpedoes.
     * @param laserCannons    is the number of laser cannons.
     */
    public Starship(String ref, String name, int photonTorpedoes, int laserCannons) {
        super(ref, name);
        this.photonTorpedoes = photonTorpedoes;
        this.laserCannons = laserCannons;
        setFee(laserCannons * 30);
        setStrength((5 * photonTorpedoes) + (10 * laserCannons));
        setForceType("Starship");
    }

    /**
     * Getter method to return the number of photon torpedoes.
     * 
     * @return number of photon torpedoes.
     */
    public int getPhotonTorpedoes() {
        return photonTorpedoes;
    }

    /**
     * Getter method to return the number of laser cannons.
     * 
     * @return number of laser cannons.
     */
    public int getLaserCannons() {
        return laserCannons;
    }

    /**
     * Getter method to return all information relevant to this starship force.
     * 
     * @return a string containing all information relevant to this starship force.
     */
    public String toString() {
        String s = "\nRef: " + getReference() +
                "\nName: " + getName() +
                "\nState: " + getStateString() +
                "\nStrength: " + getStrength() +
                "\nActivation Fee: " + getActivationFee() +
                "\nPhoton Torpedoes: " + getPhotonTorpedoes() +
                "\nLaser Cannons: " + getLaserCannons();
        return s;
    }
}
