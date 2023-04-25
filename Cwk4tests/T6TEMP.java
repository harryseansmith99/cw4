package Cwk4tests;

import cwk4.SpaceWars;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cwk4.WIN;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author aam
 */
public class T6TEMP {
    WIN game;

    String savePath = ("src/cwk4/battles.txt");

    public T6TEMP() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        game = new SpaceWars("Angela");
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
    public void testSaveGame() throws IOException {

        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        game.saveGame("angela");

        // Check that the save file exists

        File saveFile = new File(savePath);
        File currentDir = new File("");
        assertTrue(currentDir.exists());
    }

    @Test
    public void testRestoreGame() throws IOException {
        // Create a SpaceWars instance

        // Save the game
        game.saveGame("angela");

        // Change some game state
        game.activateForce("IW1");

        // Restore the game from the save file
        WIN restoredGame = new SpaceWars("Test Admiral");
        restoredGame.restoreGame(savePath);

        // Check that the game state has been restored
        assertEquals(game.toString(), restoredGame.toString());
    }

    public void saveGameWithForceThenLoadSameGame() {
        game.activateForce("IW1");
        String[] SaveExpected = {
                "Angela", "800", "IW1"
        };
        String preSaveResult = game.toString();
        boolean preSaveActual = containsText(preSaveResult, SaveExpected);
        game.saveGame("Angela");

        game = game.restoreGame("Angela");

        String postSaveResult = game.toString();
        boolean postSaveActual = containsText(postSaveResult, SaveExpected);

        boolean compareActual = preSaveActual && postSaveActual;
        assertTrue(compareActual);
    }

}
