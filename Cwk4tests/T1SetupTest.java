/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
package Cwk4tests;

import cwk4.SpaceWars;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cwk4.WIN;

/**
 * @author aam
 */
public class T1SetupTest {
    WIN game;

    public T1SetupTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new SpaceWars("David");
    }

    @After
    public void tearDown() {
    }

    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }

    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void gameCorrectlyInitialised() {
        String result = game.toString();
        String[] details = {
                "David", "1000", ""
        };
        boolean actual = containsText(result, details);
        assertTrue(actual);
    }

    @Test
    public void warChestWhenNoBattle() {
        int expected = 1000;
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }

    @Test
    public void battleAtSetup() {
        boolean result = game.isBattle(3);
        assertTrue(result);
    }

    @Test
    public void allBattleLoadedAtSetup() {
        boolean result = true;
        for (int i = 1; i <= 8; i++) {
            result = result && game.isBattle(i);
        }
        assertTrue(result);
    }

    // Test a battle that doesn't exist in Appendix A
    @Test
    public void nonExistingBattleAtSetup() {
        boolean result = game.isBattle(9);
        assertFalse(result);
    }

    @Test
    public void forceInUFFAtSetup() {
        boolean result = game.isInUFFDock("IW1");
        assertTrue(result);
    }

    @Test
    public void UFFleetLoadedAtTheBeginning() {
        boolean result = true;
        List<String> forces = new ArrayList<>(
                Arrays.asList("IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"));
        for (String force : forces) {
            result = result && game.isInUFFDock(force);
        }
        assertTrue(result);
    }

    @Test
    public void ASFleetEmptyAtTheBeginning() {
        boolean result = true;
        List<String> forces = new ArrayList<>(
                Arrays.asList("IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"));
        for (String force : forces) {
            result = result && !game.isInASFleet(force);
        }
        assertTrue(result);
    }

    // Test to make sure recallForce has no effect on docked/setup forces
    @Test
    public void recallForceFromSetup() {
        int initialFunds = game.getWarchest();
        game.recallForce("IW1");
        int resultFunds = game.getWarchest();
        boolean result = initialFunds == resultFunds;
        assertTrue(result);
    }

    @Test
    public void detailsOfWB3() {
        String str = game.getForceDetails("WB3");
        String[] target = {
                "WB3", "Droop", "100", "300", "In dock", "false"
        };
        boolean result = containsText(str, target);
        assertTrue(result);
    }

    // Test a WarBird with cloak
    @Test
    public void detailsOfWB5() {
        String str = game.getForceDetails("WB5");
        String[] target = {
                "WB5", "Hang", "300", "400", "In dock", "true"
        };
        boolean result = containsText(str, target);
        assertTrue(result);
    }

    @Test
    public void detailsOfSS2() {
        String str = game.getForceDetails("SS2");
        String[] target = {
                "SS2", "Enterprise", "200", "300", "In dock", "20", "10"
        };
        boolean result = containsText(str, target);
        assertTrue(result);
    }

    @Test
    public void detailsOfIW1() {
        String str = game.getForceDetails("IW1");
        String[] target = {
                "IW1", "Twister", "200", "200", "In dock", "10"
        };
        boolean result = containsText(str, target);
        assertTrue(result);
    }

    @Test
    public void detailsOfNonExistantForce() {
        String str = game.getForceDetails("XX3");
        String[] target = {
                "No such force"
        };
        boolean result = containsText(str, target);
        assertTrue(result);
    }

    @Test
    public void detailsOfBattle() {
        String str = game.getBattle(2);
        String[] details = {
                "2", "Skirmish", "Kardassians", "700", "200", "120"
        };
        boolean result = containsText(str, details);
        assertTrue(result);
    }

    // Test to make sure game does not use a non existing battle
    @Test
    public void detailsOfNonExistingBattle() {
        String str = game.getBattle(-1);
        String[] details = {
                "No such Battle"
        };
        boolean result = containsText(str, details);
        assertTrue(result);
    }
}
