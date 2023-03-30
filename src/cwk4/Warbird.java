package cwk4;

public class Warbird extends Force {

    boolean cloaked;

    public Warbird(String reference, String name, int strength, boolean cloaked) {
        super(reference, name);
        this.cloaked = cloaked;

        if (isCloaked()) {
            super.setFee(400);
        }
        else {
            super.setFee(300);
        }
        setStrength(strength);
        setForceType("Warbird");
    }

    /**
     * @return the status of cloaked, which will be true or false
     */
    public boolean isCloaked() { return this.cloaked; }

    @Override
    public String toString() {
        String s = "\nRef: " + getReference() + "\nName: " + getName() + "\nState: " + getStateString() + "\nStrength: "
                + getStrength() + "\nActivation Fee: " + getActivationFee() + "\nCloaked: " + isCloaked();

        return s;
    }

}
