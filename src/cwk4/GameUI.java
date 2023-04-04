package cwk4;

import java.io.*;
import java.util.*;

/**
 * Provide a command line user interface
 *
 * @author A.A.Marczyk
 * @version 06/10/23
 */
public class GameUI {

  private Scanner myIn = new Scanner(System.in);

  private void playGame() {
    int choice;

    String admiralName = "";

    int result = -1;

    System.out.println("Enter admiral's name");

    String s = myIn.nextLine();
    admiralName = s;

    WIN gp = new SpaceWars(s, "battles");
    choice = 100;

    while (choice != 0) {
      choice = getMenuItem();
      if (choice == 1) { // All forces
        System.out.println(gp.getAllForces());
      }
      else if (choice == 2) { // List all battles
        System.out.println(gp.getAllBattles());
      }
      else if (choice == 3) { // get Force
        System.out.println("Enter Force reference");
        myIn.nextLine();
        String ref = (myIn.nextLine().trim());
        System.out.println(gp.getForceDetails(ref));
      }
      else if (choice == 4) { // activate Force
        System.out.println("Enter Force reference");
        myIn.nextLine();
        String fcc = (myIn.nextLine().trim());
        System.out.println(activation(gp.activateForce(fcc)));

      }
      else if (choice == 5) {
        System.out.print(gp.getASFleet());
      }
      else if (choice == 6) {

        System.out.println("Enter Battle Number");
        int ref = (myIn.nextInt());

        myIn.nextLine();

        int contr = gp.doBattle(ref);
        if (contr == 0) {
          System.out.println("Congratulations. \nBattle won!");
        }
        else if (contr == 1) {
          System.out.println("Battle lost as no suitable force available.");
        }
        else if (contr == 2) {
          System.out.println("Battle lost. Force wasn`t strong enough.");
        }
        else if (contr == 3) {
          System.out.println("Battle lost. You have been defeated.");
        }
        else if (contr == -1) {
          System.out.println("Selected battle doesn`t exist. Please select an appropriate number.");
        }
        else {
          System.out.println("Unexpected exception.");
        }

        System.out.println("\nWarchest: " + gp.getWarchest());
      }
      else if (choice == 7) {
        System.out.println("Enter Force reference");
        myIn.nextLine();
        String ref = (myIn.nextLine().trim());
        gp.recallForce(ref);
      }
      else if (choice == 8) {
        System.out.println(gp.toString());
      }
      // Uncomment after task 3.5
      else if (choice == 9) // Task 3.5 only
      {
        System.out.println("Write to file");
        gp.saveGame(admiralName);
      }
      else if (choice == 10) // Task 3.5 only
      {
        System.out.println("Restore from file");

        System.out.println("Enter Admiral`s name");
        myIn.nextLine();
        String name = (myIn.nextLine().trim());

        gp = gp.restoreGame(name.toLowerCase());
        System.out.println(gp.toString());
      }
    }
    System.out.println("Thank-you");
  }

  private int getMenuItem() {
    int choice = 100;
    System.out.println("Main Menu");
    System.out.println("0. Quit");
    System.out.println("1. List all forces");
    System.out.println("2. List all battles");
    System.out.println("3. View details of a force");
    System.out.println("4. Activate a force into the Active Star  fleet");
    System.out.println("5. List forces in Active Star Fleet");
    System.out.println("6. Engage in a battle");
    System.out.println("7. Recall a force");
    System.out.println("8. View the state of the game");
    // For Task 3.5 only
    System.out.println("9. Save this game");
    System.out.println("10. Restore a game");

    while (choice < 0 || choice > 10) {
      System.out.println("Enter the number of your choice");
      choice = myIn.nextInt();
    }
    return choice;
  }

  private String activation(int code) {
    switch (code) {
    case 0:
      return "force is activated";
    case 1:
      return "force is not in the UFFDock";
    case 2:
      return "not enough money";
    case 3:
      return "no such force";
    default:
      return "Error";
    }
  }

  public static void main(String[] args) {

    GameUI myGame = new GameUI();
    myGame.playGame();

  }
}
