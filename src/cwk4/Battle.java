package cwk4;
/**
 * A battle containing an id number, type, enemy name, enemy strength, losses, and gains.
 */
public class Battle {
    
    // fields
    private int battleNo;
    private String battleType;
    private String enemyName;
    private int enemyStrength;
    private int losses;
    private int gains;

    /**
     * Constructor which creates a battle with an id number, type, enemy name, enemy strength, losses, and gains.
     */
    public Battle(int id, String type, String nme, int strength, int l, int g) {
        battleNo = id;
        battleType = type;
        enemyName = nme;
        enemyStrength = strength;
        losses = l;
        gains = g;
    }
    /**
     * Getter method which returns battle ID number.
     * @return battle ID number
     */
    public int getId() {
        return battleNo;
    }
    /**
     * Getter method which returns the battle type.
     * @return battle type
     */
    public String getType() {
        return battleType;
    }
    /**
     * Getter method which returns the enemy's name.
     * @return enemy's name
     */
    public String getEnemyName() {
        return enemyName;
    }
    /**
     * Getter method which returns the enemy's strength.
     * @return enemy's strength as an integer
     */
    public int getEnemyStrength() {
        return enemyStrength;
    }
    /**
     * Getter method which returns the number of bitcoins you lose if battle is lost.
     * @return number of bitcoins the user loses
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Getter method which returns the number of bitcoins you gain if battle is won.
     * @return number of bitcoins the user wins.
     */
    public int getGains() {
        return gains;
    }
    /**
     * Getter method returns all relevant information related to the battle
     * @return all relevant information related to the battle
     */
    public String toString() {
        String s =  "\nID: "+battleNo+
                    "\nType: " +battleType+
                    "\nEnemy Name: " +enemyName+
                    "\nEnemy Strength: " +enemyStrength+
                    "\nLosses: " +losses+
                    "\nGains: " +gains;
        return s;
    }

}
