package cwk4;

/**
 * Enumeration class ForceState
 * 
 * @author A.Marczyk
 * @version 02/11/2019
 */
public enum ForceState {
    DOCKED(" In dock"), ACTIVE(" Active"), DESTROYED(" destroyed");

    private String state;

    private ForceState(String st) { state = st; }

    public String toString() { return state; }
}
