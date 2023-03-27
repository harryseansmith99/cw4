package cwk4;

public class Warbird extends Force {

    boolean cloaked;

    public Warbird(String reference, String name, boolean cloaked) {
        super(reference, name);
        this.cloaked = cloaked;

        if (isCloaked()) {
            super.setFee(400);
        }
        else {
            super.setFee(300);
        }
    }
    
    /**
    * @return the status of cloaked, which will be true or false
    *
    */
    public boolean isCloaked() {
        return this.cloaked;
    }
    
    @Override
    public String toString() {
    String s =  "\nRef: " +reference+
                "\nName: " +name+
                "\nState: " +getStateString()+
                "\nStrength: " +strength+
                "\nActivation Fee: " +activationFee +
                "\nCloaked: " + cloaked;
        
    return s;
    }

}
