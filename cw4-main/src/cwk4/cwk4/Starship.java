package cwk4;

/**
 * A child class of Force called Starship which contains a reference, force name, number of photon torpedos, number of laser cannons and also its activation cost.
 */
public class Starship extends Force {

    //fields
    private String ref;
    private String name;
    private int photonTorpedos;
    private int laserCannons;

    /**
     * Constructor which creates a Starship force with a reference, name, number of photon torpedos, and number of laser cannons.
     * @param ref is the force reference
     * @param name is the force name
     * @param photonTorpedos is the number of photon torpedos.
     * @param laserCannons is the number of laser cannons.
     */
    public Starship(String ref, String name, int photonTorpedos, int laserCannons) {
        super(ref, name);
        this.ref = ref;
        this.name = name;
        this.photonTorpedos = photonTorpedos;
        this.laserCannons = laserCannons;
        setFee(laserCannons*30);
        setStrength((5*photonTorpedos)+(10*laserCannons));
    }
    /**
     * Getter method to return the number of photon torpedos.
     * @return number of photon torpedos.
     */
    public int getPhotonTorpedos() {
        return photonTorpedos;
    }
    /**
     * Getter method to return the number of laser cannons.
     * @return number of laser cannons.
     */
    public int getLaserCannons() {
        return laserCannons;
    }
    /**
     * Getter method to return all information relevant to this starship force.
     * @return a string containing all information relevant to this starship force.
     */
    public String toString() {
        String s =  "Ref: " +ref+
                    "\nName: " +name+
                    "\nnActivation Fee: " +getActivationFee()+
                    "\nPhoton Torpedos: " +photonTorpedos+
                    "\nLaser Cannons: " +laserCannons;
        return s;
    }
}