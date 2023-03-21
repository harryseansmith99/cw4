
/**
 * Write a description of interface WIN here.
 *
 * @author Bradley McGowan, Timofei Poremski, Aimee Silver, Harry Smith
 */
public interface WIN
{
    /**
     * @return information about all forces and all battles
     */
    public String toString();
    
    /**
     * @return information about active forces on the fleet
     */
    public String getFleet();
    
    /**
     * @return information about inactive forces in the dock
     */
    public String getDockedForces();
    
    /**
     * @return information about all forces
     */
    public String getAllForces();
    
    /**
     * @return information about all battles
     */
    public String getAllBattles();
    
    /**
     * @param forceRef - the reference id of a force
     * @return the String version of the state of a force
     */
    public String getForceState(String forceRef);
    
    /**
     * @param forceRef - the reference id of a force
     * @param battleId - the id of a selected battle
     * @return true if selected force can battle, otherwise false
     */
    public boolean canBattle(String forceRef, int battleId);
    
    /**
     * Tries to select the first appropriate force to conduct the battle from the fleet. If a force is found, does battle and displays the appropriate
     * outcome. If no force can be found registers a loss automatically and displays the result.
     * 
     * @param battleId - the id of a selected battle
     * @return result of the battle
     */
    public String doBattle(int battleId);
    
    /**
     * Tries to activate a force from the dock
     * 
     * @param forceRef - the reference id of a force
     */
    public void activateForce(String forceRef);
    
    /**
     * Tries to recall a force back into the dock
     * 
     * @param forceRef - the reference id of a force
     */
    public void recallForce(String forceRef);
    
    /**
     * @return the value of bit coins inside the war chest
     */
    public int viewChest();
}