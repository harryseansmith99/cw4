package cwk4;

public class Warbird extends Force {

    boolean cloaked;

    public Warbird(String reference, String name, int strength, int activationFee, boolean cloaked) {
        super(reference, name, strength, activationFee);
        this.cloaked = cloaked;
    }

    public boolean checkCloak() {
        return this.cloaked;
    }

}
