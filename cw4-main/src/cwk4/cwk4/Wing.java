package cwk4;

public class Wing extends Force{
	
	int strikers;
	
	public Wing(String ref, String nme, int strk) {
        super(ref, nme);
        strikers = strk;
        
        activationFee = 200;
        strength = strikers * 20;
    }
}
