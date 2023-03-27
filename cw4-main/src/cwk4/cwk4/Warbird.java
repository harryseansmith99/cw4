package cwk4;

public class Warbird extends Force {

    boolean cloaked;

    public Warbird(String reference, String name, boolean cloaked) {
        super(reference, name);
        this.cloaked = cloaked;

        if (checkCloak()) {
            super.setFee(400);
        }
        else {
            super.setFee(300);
        }
    }

    public boolean checkCloak() {
        return this.cloaked;
    }

}
