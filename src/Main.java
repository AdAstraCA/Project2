import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	// Try/catch is used to check for FileNotFoundException and IOException.
        try {
        	// A Scanner is set up to take user input.
            Scanner inputScanner = new Scanner(System.in);
            // Both the Hall of Fame and Current Team are initialized and set, including the leaderboard.
            int games = 82;
            HallOfFame hallOfFame = new HallOfFame(games, 16);
            CurrentTeam currentTeam = new CurrentTeam(games);
            currentTeam.addCurrentPlayers();
            currentTeam.setLeaderboard();
            // A menu is implemented and running as long as the user doesn't exit with option 6.
            boolean running = true;
            while (running) {
            	// Each option is then printed out and waiting for the user's choice, stored in an int variable.
                System.out.println("\nWelcome to the Basketball Stats App! Please choose an option:");
                System.out.println("1. Show Hall of Fame Players");
                System.out.println("2. Show Hall of Fame Coaches");
                System.out.println("3. Show Current Players");
                System.out.println("4. Show Leaderboard");
                System.out.println("5. Write Leaderboard");
                System.out.println("6. Quit");

                int choice = inputScanner.nextInt();
                switch (choice) {
                    case 1:
                    	// The HoF Players are created with an array, iterated, and printed out with their toString methods called in tandem.
                        System.out.println("Hall of Fame Players:");
                        HallOfFamePlayer[] players = (HallOfFamePlayer[]) hallOfFame.getInductees()[0];
                        for (HallOfFamePlayer player : players) {
                            System.out.println(player);
                        }
                        break;
                    case 2:
                    	// The HoF Coaches are created with an array, iterated, and printed out with their toString methods called in tandem.
                        System.out.println("Hall of Fame Coaches:");
                        HallOfFameCoach[] coaches = (HallOfFameCoach[]) hallOfFame.getInductees()[1];
                        for (HallOfFameCoach coach : coaches) {
                            System.out.println(coach);
                        }
                        break;
                    case 3:
                    	// testGetters() is called for the currentTeam to print out the current players.
                        System.out.println("Current Players:");
                        currentTeam.testGetters();
                        break;
                    case 4:
                    	// The Current players are created with an array, iterated, and printed out with their toString methods called. 
                	    for (CurrentPlayer sortedPlayer : currentTeam.getLeaderboard()) {
                	    	System.out.println(sortedPlayer.toString());
                	    }
                	    break;
                    case 5:
                    	// writeLeaderboard() is called to write to the leaderboard file.
                    	currentTeam.writeLeaderboard();
                    	System.out.println("The leaderboard file has been written.");
                    	break;
                    case 6:
                    	// Running is set to false to end the menu.
                        running = false;
                        System.out.println("Thank you for using the Basketball Stats App. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid number between 1 and 6.");
                        break;
                }
            }
            // The Scanner is then closed.
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
    	catch (IOException e) {
    		System.err.println("Error: Failed to output code.");
    	}
    }
}
