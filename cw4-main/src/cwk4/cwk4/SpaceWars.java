package cwk4;

import java.util.*;
import java.io.*;

/**
 * This class implements the behaviour expected from a WIN
 * system as required for 5COM2007 - March 2023
 * 
 * @author Team 9
 * @version March 2023
 */

public class SpaceWars implements WIN {

    // **************** WIN **************************
    /**
     * Constructor requires the name of the admiral
     * 
     * @param admiral the name of the admiral
     */
    private String admiralName;
    Warchest warchest;

    ArrayList<Force> curForces = new ArrayList<Force>();
    ArrayList<Force> activeForces = new ArrayList<Force>();
    ArrayList<Battle> curBattles = new ArrayList<Battle>();

    public SpaceWars(String admiral) {

        warchest = new Warchest();

        admiralName = admiral;

        setupForces();
        setupBattles();
    }

    /**
     * Second constructor - task 3.5
     * To be added for task 3.5
     */

    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     * 
     * @return a String representation of the state of the game,
     *         including the name of the admiral, state of the war chest,
     *         whether defeated or not, and the forces currently in the
     *         Star Fleet,(or, "No forces" if Active Star Fleet is empty)
     **/
    public String toString() {

        return "\nAdmiral`s Name: "+admiralName+"\nWarchest: "+getWarchest()+"\nIs defeated? "+isDefeated()+"\nActive forces: "+getASFleet();
    }

    /**
     * returns true if war chest <=0 AND the active Star Fleet(ASF) has no
     * forces which can be recalled.
     * 
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     *          forces which can be recalled.
     */
    public boolean isDefeated() {
        if (warchest.getFunds() <= 0 && !activeForces.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * returns the number of bit coins in the war chest
     * 
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest() {

        return warchest.getFunds();
    }

    /*
     * Returns a list of all forces in the system by listing :
     * All forces in the Active Star Fleet(ASF), or "No forces in ASF")
     * All forces remaining in the UFF dock, or "No forces in UFF dock
     * All forces destroyed as a result of losing a battle, or "No destroyed forces"
     */
    public String getAllForces() {

        String s = "\nList of all Forces\n";

        if (curForces.isEmpty()) {
            s += "\nNo forces found";
        } else
            for (Force temp_force : curForces) {
                s += "\n" + temp_force.toString();

            }
        return s;
    }

    /**
     * Returns true if force is in the United Forces Fleet(UFF), else false
     * 
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public boolean isInUFFDock(String ref) {
        if (findForce(ref, curForces) != null) {
            if (findForce(ref, curForces).getState() == ForceState.DOCKED) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of all forces in the United Forces Fleet(UFF)
     * dock.
     * Does not include destroyed forces
     * 
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     *         dock.
     **/
    public String getForcesInDock() {
        String s = "\n\n************ Forces available in UFFleet Dock********\n";

        if (curForces.isEmpty()) {
            s += "\nNo forces found";
        } else
            for (Force temp_force : curForces) {
                if (isInUFFDock(temp_force.getReference())) {
                    s += "\n" + temp_force.toString();
                }

            }
        return s;
    }

    /**
     * Returns a list of all destroyed forces in the system
     * 
     * @return all destroyed forces
     */
    public String getDestroyedForces() {
        String s = "\n***** Destroyed Forces ****\n";
        if (curForces.isEmpty()) {
            s += "\nNo forces found";
        } else
            for (Force temp_force : curForces) {
                if (temp_force.getState() == ForceState.DESTROYED) {
                    s += "\n" + temp_force.toString();
                }

            }
        return s;
    }

    /**
     * Returns details of the force with the given reference code, or "No such
     * force"
     * 
     * @param ref the reference of the force
     * @return details of the force with the given reference code
     **/
    public String getForceDetails(String ref) {
        String s = "";
        if (findForce(ref, curForces) == null) {
            s += "\nNo such force";
        } else
            s += findForce(ref, curForces).toString();
        return s;
    }

    // ***************** Active Star Fleet Forces ************************
    /**
     * Allows a force to be activated into the Active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     * 
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF dock or is
     *         destroyed
     *         2 if not enough money, -1 if no such force
     **/
    public int activateForce(String ref) {
        if (findForce(ref, curForces) != null) {
            if (!isInUFFDock(ref)) {
                return 1;
            } else if (isInUFFDock(ref) && warchest.getFunds() >= findForce(ref, curForces).getActivationFee()) {
                warchest.deductFunds(findForce(ref, curForces).getActivationFee());
                findForce(ref, curForces).changeState(ForceState.ACTIVE);
                activeForces.add(findForce(ref, curForces));
                return 0;
            } else if (isInUFFDock(ref) && warchest.getFunds() < findForce(ref, curForces).getActivationFee()) {

                return 2;
            }

        }
        return -1;

    }

    /**
     * Returns true if the force with the reference code is in
     * the Active Star Fleet(ASF), false otherwise.
     * 
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     *         is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref) {
        if (findForce(ref, activeForces) != null) {

            return true;
        }

        return false;
    }

    /**
     * Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     * 
     * @return a String representation of the forces in the active
     *         Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet() {
        String s = "\n****** Forces in the Active Star Fleet******\n";

        if (activeForces.isEmpty()) {
            s += "\nNo forces found";
        } else
            for (Force temp_force : activeForces) {
                if (isInASFleet(temp_force.getReference())) {
                    s += "\n" + temp_force.toString();
                }

            }
        return s;

    }

    /**
     * Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if it is in the Active Star Fleet(ASF)
     * 
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref) {
        Force temp_force = findForce(ref, activeForces);
        if (temp_force != null) {
                temp_force.changeState(ForceState.DOCKED);
                activeForces.remove(temp_force);
                warchest.addFunds((temp_force.getActivationFee() / 2));
            }
    

    }

    public void destroyForce(String ref) {
        Force temp_force = findForce(ref, activeForces);
        if (temp_force != null) {
                temp_force.changeState(ForceState.DESTROYED);
                activeForces.remove(temp_force);
            }
    

    }

    // **********************Battles*************************
    /**
     * returns true if the number represents a battle
     * 
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
    public boolean isBattle(int num) {
        if (findBattle(num) != null) {
            return true;
        }

        return false;
    }

    /**
     * Provides a String representation of a battle given by
     * the battle number
     * 
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     *         the battle number
     **/
    public String getBattle(int num) {
        String s = "";

        if (!isBattle(num)) {
            s += "\nNo such Battle.";
        }

        else {
            s += findBattle(num).toString();
        }
        return s;

    }

    /**
     * Provides a String representation of all battles
     * 
     * @return returns a String representation of all battles
     **/
    public String getAllBattles() {
        String s = "\n************ All Battles ************\n";

        if (curBattles.isEmpty()) {
            s += "\nNo battles found";
        } else
            for (Battle temp_battle : curBattles) {
                s += "\n" + temp_battle.toString();

            }
        return s;
    }

    /**
     * Retrieves the battle represented by the battle number.Finds
     * a force from the Active Star Fleet which can engage in the battle.The
     * results of battle will be one of the following:
     * 0 - Battle won, battle gains added to the war chest,
     * 1 - Battle lost as no suitable force available, battle losses
     * deducted from war chest
     * 2 - Battle lost on battle strength , battle losses
     * deducted from war chest and force destroyed
     * 3 - If a battle is lost and admiral completely defeated (no resources and
     * no forces to recall)
     * -1 - no such battle
     * 
     * @param battleNo is the number of the battle
     * @return an int showing the result of the battle (see above)
     */
    public int doBattle(int battleNo) {
        if (isBattle(battleNo) && !isDefeated()) {
            if (!activeForces.isEmpty()) {
                for (Force temp_force : activeForces) {
                    if (isSuitableType(temp_force, findBattle(battleNo).getType())) {
                        if (temp_force.getStrength() >= findBattle(battleNo).getEnemyStrength()) {
                            return 0;
                        } else if (isDefeated()){
                            return 3;
                        }
                        else{return 2;}

                    }
                    else {return 1;}
                }
            } else {
                return 1;
            }

        } else if (!isBattle(battleNo)) {
            return -1;}


        return 999;
    }

    // *******************************************************************************
    private void setupForces() {
        Wing wing1 = new Wing("IW1", "Twister", 10);
        Starship starship1 = new Starship("SS2", "Enterprise", 20, 10);
        Warbird warbird1 = new Warbird("WB3", "Droop", 300, false);
        Wing wing2 = new Wing("IW4", "Winger", 20);
        Warbird warbird2 = new Warbird("WB5", "Hang", 300, true);
        Starship starship2 = new Starship("SS6", "Voyager", 10, 15);
        Starship starship3 = new Starship("SS7", "Explorer", 5, 4);
        Warbird warbird3 = new Warbird("WB9", "Hover", 400, false);
        Wing wing3 = new Wing("IW10", "Flyer", 5);

        curForces.add(wing1);
        curForces.add(wing2);
        curForces.add(wing3);
        curForces.add(starship1);
        curForces.add(starship2);
        curForces.add(starship3);
        curForces.add(warbird1);
        curForces.add(warbird2);
        curForces.add(warbird3);
    }

    private void setupBattles() {

        Battle battle1 = new Battle(1, BattleType.FIGHT, "Borg", 200, 300, 100);
        Battle battle2 = new Battle(2, BattleType.SKIRMISH, "Kardassians", 700, 200, 120);
        Battle battle3 = new Battle(3, BattleType.AMBUSH, "Ferengi", 100, 400, 150);
        Battle battle4 = new Battle(4, BattleType.FIGHT, "Ewoks", 600, 600, 200);
        Battle battle5 = new Battle(5, BattleType.AMBUSH, "Borg", 500, 400, 90);
        Battle battle6 = new Battle(6, BattleType.SKIRMISH, "Groaners", 150, 100, 100);
        Battle battle7 = new Battle(7, BattleType.FIGHT, "Borg", 150, 500, 300);
        Battle battle8 = new Battle(8, BattleType.AMBUSH, "Wailers", 300, 300, 300);

        curBattles.add(battle1);
        curBattles.add(battle2);
        curBattles.add(battle3);
        curBattles.add(battle4);
        curBattles.add(battle5);
        curBattles.add(battle6);
        curBattles.add(battle7);
        curBattles.add(battle8);
    }

    private Force findForce(String ref, ArrayList<Force> arr) {
        for (Force temp_force : arr) {
            if (temp_force.getReference().equals(ref.toUpperCase())) {
                return temp_force;
            }
        }

        return null;
    }

    private Battle findBattle(int num) {
        for (Battle temp_battle : curBattles) {
            if (temp_battle.getId() == num) {
                return temp_battle;
            }
        }
        return null;
    }

    private boolean isSuitableType(Force force, BattleType bt) {

        if ((force.getForceType() == "Wing" && bt == BattleType.SKIRMISH)
                || (force.getForceType() == "Wing" && bt == BattleType.AMBUSH)) {
            return true;
        }

        if ((force.getForceType() == "Starship" && bt == BattleType.SKIRMISH)
                || (force.getForceType() == "Starship" && bt == BattleType.FIGHT)) {
            return true;
        }

        if ((force.getForceType() == "Warbird" && ((Warbird) force).isCloaked() && bt == BattleType.AMBUSH)
                || (force.getForceType() == "Starship" && bt == BattleType.FIGHT)) {
            return true;
        }

        return false;
    }

    // **************************Add your own private methos here
    // ***********************

    // *******************************************************************************

    // These methods are not needed until Task 3.5. Uncomment thmemto complete task
    // 3.5
    // *************** file write/read *********************

    // /** Writes whole game to the specified file
    // * @param fname name of file storing requests
    // */
    // public void saveGame(String fname)
    // { // uses object serialisation
    //
    // }
    //
    // /** reads all information about the game from the specified file
    // * and returns a SpaceWars object
    // * @param fname name of file storing the game
    // * @return the game (as a SpaceWars object)
    // */
    // public SpaceWars restoreGame(String fname)
    // {
    //
    // }
    //
    // /** Reads information about battles from the specified file into the
    // appropriate collection
    // * @param the name of the file
    // */
    // private void readBattles(String fname)
    // {
    //
    // }

}
