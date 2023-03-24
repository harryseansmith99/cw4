package cwk4;

public class Wing extends Force{
	
	int strikers;
	
	public Wing(String ref, String nme, int strk) {
        super(ref, nme);
        strikers = strk;
        
        setFee(200);
        setStrength(strk*20);
    }
	
	public static void main(String[] args) {
		Wing w = new Wing("IW1", "Child", 20);
		
		int x = w.getStrength();
		
		System.out.println(x);
	}
}
