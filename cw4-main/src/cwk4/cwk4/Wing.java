package cwk4;

public class Wing extends Force {

    int strikers;

    public Wing(String ref, String nme, int strikers) {
        super(ref, nme);
        this.strikers = strikers;

        setFee(200);
        setStrength(strikers * 20);
        setForceType("Wing");
    }

    public int getStrikers() {
        return strikers;
    }

    public String toString() {
        String s = "\nRef: " + getReference() +
                "\nName: " + getName() +
                "\nState: " + getStateString() +
                "\nStrength: " + getStrength() +
                "\nActivation Fee: " + getActivationFee() +
                "\nStrikers: " + getStrikers();
        return s;
    }
}
