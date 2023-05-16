import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HallOfFame {
	// Declaring the instance variables.
	// HallOfFame has an inducteedPlayers(Array of HallofFamePlayers).
	// HallOfFame has an inducteedCoaches(Array of HallofFameCoaches).
	// HallOfFame has a rings(int).
	// HallOfFame has a playerFile(File).
	// HallOfFame has a coachFile(File).
	private int rings;
	private HallOfFamePlayer[] inducteedPlayers;
	private HallOfFameCoach[] inducteedCoaches;
	private File playerFile;
	private File coachFile;
	
	// Constructor for HallOfFame with games and rings parameters(FileNotFoundException thrown if file not found).
	public HallOfFame(int games, int rings) throws FileNotFoundException {
		// If any number is negative, it's impossible for a player/coach, so an exception is thrown.
    	// Otherwise, the instance variables are set to the parameters, and the rest of the variables are initialized.
        if (games <= 0 || rings < 0) {
            throw new IllegalArgumentException("Games must be positive and rings must be non-negative");
        }
		this.rings = rings;
		inducteedPlayers = new HallOfFamePlayer[20];
		inducteedCoaches = new HallOfFameCoach[4];
		playerFile = new File("HoFPlayers.csv");
		coachFile = new File("HofCoaches.csv");
		// addInductees() is called to set both arrays.
		addInductees();
	}
	
	/**
	* Returns the rings instance variable
	* 
	* @return the rings instance variable
	*/
	public int getRings() {
		// We simply return rings.
		return rings;
	}
	
	/**
	* Reads the HoF files and adds each player/coach.
	*/
	public void addInductees() throws FileNotFoundException {
		// ArrayLists are set up to store the values before transferring them to the instance variables.
	    ArrayList<HallOfFamePlayer> players = new ArrayList<>();
	    ArrayList<HallOfFameCoach> coaches = new ArrayList<>();
	    // Scanners are set up to open the playerFile and the coachFile.
	    Scanner playerScanner = new Scanner(playerFile);
		Scanner coachScanner = new Scanner(coachFile);
	    // While the scanner checks for new lines with values, variables are set for each value listed on the file and applicable for players.
		// These values are separated by commas(csv), so a string array is created that organizes by comma splits.
		// The variables are set for each index.
	    while (playerScanner.hasNextLine()) {
	        String[] playerData = playerScanner.nextLine().split(",");
	        // If playerData isn't 7 values long, then the file isn't applicable, so an exception is thrown.
	        if (playerData.length != 7) {
                throw new IllegalArgumentException("Invalid player data format");
            }
	        String name = playerData[0];
	        int championships = Integer.parseInt(playerData[1]);
	        double ppg = Double.parseDouble(playerData[2]);
	        double rpg = Double.parseDouble(playerData[3]);
	        double apg = Double.parseDouble(playerData[4]);
	        double spg = Double.parseDouble(playerData[5]);
	        int rings = Integer.parseInt(playerData[6]);
	        
	        players.add(new HallOfFamePlayer(name, championships, ppg, rpg, apg, spg, rings));
	    }
	    
	    // The same thing occurs for the HoFCoaches.csv file with a length of 4.
	    while (coachScanner.hasNextLine()) {
	        String[] coachData = coachScanner.nextLine().split(",");
            if (coachData.length != 4) {
                throw new IllegalArgumentException("Invalid coach data format");
            }
	        String name = coachData[0];
	        int championships = Integer.parseInt(coachData[1]);
	        int wins = Integer.parseInt(coachData[2]);
	        double winPercentage = Double.parseDouble(coachData[3]);
	        
	        coaches.add(new HallOfFameCoach(name, championships, wins, winPercentage));
	    }
	    
	    // Convert the ArrayLists to arrays and set the inducteedPlayers and inducteedCoaches fields
	    inducteedPlayers = players.toArray(new HallOfFamePlayer[0]);
	    inducteedCoaches = coaches.toArray(new HallOfFameCoach[0]);
	    // Close the Scanners.
	    playerScanner.close();
	    coachScanner.close();
	}

	/**
	* Returns the inducteed players/coaches as an object
	* 
	* @return the inducteed players/coaches
	*/
	public Object[] getInductees() {
		// We simply return a new Object array holding the inducteed players and coaches.
		return new Object[] {inducteedPlayers, inducteedCoaches};
	}
	
	/**
   	* Prints out all of the players organized by values.
   	*/
	public void testGetters() {
		// A for loop is utilized to loop through all coaches and players, and all the getter methods are called/organized for each of them.
	    System.out.println("Hall of Fame Coaches:");
	    for (HallOfFameCoach coach : inducteedCoaches) {
	        System.out.println("Name: " + coach.getCoach());
	        System.out.println("Games: " + coach.getGames());
	        System.out.println("Rings: " + coach.getRings());
	        System.out.println("Wins Over Half: " + coach.getWinsOverHalf());
	        System.out.println();
	    }
	    
	    System.out.println("Hall of Fame Players:");
	    for (HallOfFamePlayer player : inducteedPlayers) {
	    	System.out.println("Name: " + player.getName());
	    	System.out.println("Games: " + player.getGames());
	    	System.out.println("Ppg: " + player.getPpg());
	    	System.out.println("Rpg: " + player.getRpg());
	    	System.out.println("Apg: " + player.getApg());
	    	System.out.println("Win Share: " + player.getWs());
	    	System.out.println("Rings: " + player.getRings());
	        System.out.println();
	    }
	}
}

