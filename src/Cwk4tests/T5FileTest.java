package Cwk4tests;

import cwk4.SpaceWars;
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
public class T5FileTest {
    WIN game;

    public T5FileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new SpaceWars("Group9");
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

    @Test
    public void saveGameWithForceThenLoadSameGame() {
        game.activateForce("IW1");
        String[] SaveExpected = {
                "Group9", "800", "IW1"
        };
        String preSaveResult = game.toString();
        boolean preSaveActual = containsText(preSaveResult, SaveExpected);
        game.saveGame("Group9");

        game = game.restoreGame("Group9");

        String postSaveResult = game.toString();
        boolean postSaveActual = containsText(postSaveResult, SaveExpected);

        boolean compareActual = preSaveActual && postSaveActual;
        assertTrue(compareActual);
    }

    @Test
    public void loadGameWithUnsavedChanges() {
        game.activateForce("IW4");
        String[] preSaveExpected = {
                "Group9", "800", "IW4"
        };
        String preSaveResult = game.toString();
        boolean preSaveActual = containsText(preSaveResult, preSaveExpected);
        game.saveGame("Group9");
        game.activateForce("WB3");
        game.doBattle(2);

        game = game.restoreGame("Group9");
        String[] postSaveExpected = {
                "Group9", "800", "IW4"
        };
        String postSaveResult = game.toString();
        boolean postSaveActual = containsText(postSaveResult, postSaveExpected);

        boolean compareActual = preSaveActual && postSaveActual;
        assertTrue(compareActual);
    }
}
