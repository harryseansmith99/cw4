package cwk4;

public class Wing extends Force{
	
	int strikers;
	
	public Wing(String ref, String nme, int strk) {
        super(ref, nme);
        strikers = strk;
        
        setFee(200);
        setStrength(strk*20);
    }
	
	public int getStrikers() {
		return strikers;
	}
	
	public String toString() {
        String s =  "\nRef: " + getReference()+
                    "\nName: " + getName()+
                    "\nState: " +getStateString()+
                    "\nStrength: " + getStrength()+
                    "\nActivation Fee: " + getActivationFee()+
                    "\nStrikers: " + getStrikers();
        return s;
    }
}

