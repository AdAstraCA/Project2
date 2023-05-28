import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CurrentTeam {
	// Declaring the instance variables.
	// CurrentTeam has a players(ArrayList of CurrentPlayers).
	// CurrentTeam has a leaderboard(ArrayList of CurrentPlayers)
	// CurrentTeam has a games(int).
	// CurrentTeam has a teamFile(File).
	// CurrentTeam has a leaderboardFile(File).
    private ArrayList<CurrentPlayer> players;
    private ArrayList<CurrentPlayer> leaderboard;
    private int games;
    private File teamFile;
    private File leaderboardFile;

    // Constructor for CurrentTeam with games parameter(FileNotFoundException thrown if file not found).
    public CurrentTeam(int games) throws FileNotFoundException {
    	// Instance variable is set to the parameter, and the rest of the variables are initialized.
        this.setGames(games);
        players = new ArrayList<>();
        leaderboard = new ArrayList<>();
        teamFile = new File("currentLakers.csv");
        leaderboardFile = new File("pointLeaderboard.txt");
    }

    /**
   	* Returns the players instance variable
   	* 
   	* @return the players instance variable
   	*/
    public ArrayList<CurrentPlayer> getPlayers() {
    	// We simply return players.
        return players;
    }

    /**
   	* Returns the leaderboard instance variable
   	* 
   	* @return the leaderboard instance variable
   	*/
    public ArrayList<CurrentPlayer> getLeaderboard() {
    	// We simply return leaderboard.
    	return leaderboard;
    }

    /**
   	* Returns the games instance variable
   	* 
   	* @return the games instance variable
   	*/
    public int getGames() {
    	// We simply return games;
        return games;
    }

    /**
   	* Sets the games instance variable to a parameter
   	* 
   	* @param the games integer which will be set to the games instance variable
   	*/
    public void setGames(int games) {
    	// We simply set the instance variable to the parameter.
        this.games = games;
    }

    /**
   	* Reads the team's file and adds each starter/bench player.
   	*/
    public void addCurrentPlayers() throws FileNotFoundException {
    	// Try/Catch is utilized to check for NumberFormatException and ArrayIndexOutOfBoundsException
    	try {
    		// Scanner opens the teamFile.
    		Scanner teamScanner = new Scanner(teamFile);
    		// While the scanner checks for new lines with values, variables are set for each value listed on the file and applicable for players.
    		// These values are separated by commas(csv), so a string array is created that organizes by comma splits.
    		// The variables are set for each index.
            while (teamScanner.hasNextLine()) {
                String[] playerData = teamScanner.nextLine().split(",");
                String name = playerData[0];
                int gamesPlayed = Integer.parseInt(playerData[1]);
                int gamesStarted = Integer.parseInt(playerData[2]);
                double trb = Double.parseDouble(playerData[3]);
                double ast = Double.parseDouble(playerData[4]);
                double stl = Double.parseDouble(playerData[5]);
                double blk = Double.parseDouble(playerData[6]);
                double pts = Double.parseDouble(playerData[7]);
                int ortg = Integer.parseInt(playerData[8]);
                int drtg = Integer.parseInt(playerData[9]);
                double ws = Double.parseDouble(playerData[10]);

    
                if (gamesStarted > (gamesPlayed / 2)) {
                    // If the player started in more than half of the games, consider them a Starter and add them.
                	players.add(new Starter(name, gamesPlayed, gamesStarted, trb, ast, pts, stl, blk, ws));
                } else {
                    // Otherwise, consider them a BenchPlayer and add them.
                    players.add(new BenchPlayer(name, gamesPlayed, gamesStarted, trb, ast, pts, ortg, drtg));
                }
            }
            // Finally, the scanner is closed.
            teamScanner.close();
    	} catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in file.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Insufficient number of data elements in file.");
        }
    }

    /**
   	* Prints out all of the players organized by values.
   	*/
    public void testGetters() {
    	// A for loop is utilized to loop through all players, and the toString() method is called for each of them.
    	for (CurrentPlayer player : getPlayers()) {
	        System.out.println(player.toString());
	    }
    }
    
    /**
   	* Sets the leaderboard by point values
   	*/
    public void setLeaderboard() {
    	// First, the leaderboard list copies the player list with a for loop iterating through each player.
    	for (CurrentPlayer player: players) {
    		leaderboard.add(player);
    	}
    	// Then, a while loop is set up and runs until leaderboard is in order.
    	boolean notInOrder = true;
        while(notInOrder) {
        	notInOrder = false;
        	// Leaderboard is iterated and sorted with a bubble sort.
        	// set() is used to get each index from leaderboard, and getPPG() is used to get the player's points.
            for (int i = 0; i < leaderboard.size() - 1; i++) {
                if (leaderboard.get(i).getPPG() < leaderboard.get(i + 1).getPPG()) {
                    CurrentPlayer tempPlayer = leaderboard.get(i);
                    leaderboard.set(i, leaderboard.get(i+1));
                    leaderboard.set(i + 1, tempPlayer);
                    notInOrder = true;
                }
            }
        }
    }
    
    /**
   	* Writes the leaderboard to a file.
   	*/
    public void writeLeaderboard() throws IOException {
    	// A FileWriter and PrintWriter are set up from the leaderboardFile to open it.
        FileWriter fWriter = new FileWriter (leaderboardFile);
        PrintWriter pWriter = new PrintWriter (fWriter);
        // Before writing, the file is cleared with flush().
        pWriter.flush();
        // Then, each player from the leaderboard is printed onto the text file with a for loop iterating through them and toString().
        for (CurrentPlayer sortedPlayer : getLeaderboard()) {
	    	pWriter.println(sortedPlayer.toString());
	    }
        // Finally, the PrintWriter is closed.
        pWriter.close();
    }
}
