public class CurrentPlayer {
	// Declaring the instance variables.
	// CurrentPlayer has a name(string).
	// CurrentPlayer has a gamesPlayed(int).
	// CurrentPlayer has a gamesStarted(int).
	// CurrentPlayer has a rpg(double).
	// CurrentPlayer has a apg(double).
	// CurrentPlayer has a ppg(double).
    private String name;
    private int gamesPlayed;
    private int gamesStarted;
    private double rpg;
    private double apg;
    private double ppg;

    // Constructor for CurrentPlayer with all parameters
    public CurrentPlayer(String name, int gamesPlayed, int gamesStarted, double rpg, double apg, double pts) {
    	// If any number is negative, it's impossible for a player, so an exception is thrown.
    	// Otherwise, the instance variables are set to the parameters.
    	if (gamesPlayed < 0 || gamesStarted < 0 || rpg < 0 || apg < 0 || pts < 0) {
            throw new IllegalArgumentException("All stats must be non-negative");
        }
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.gamesStarted = gamesStarted;
        this.rpg = rpg;
        this.apg = apg;
        this.ppg = pts;
    }

    /**
	* Returns the name instance variable
	* 
	* @return the name instance variable
	*/
    public String getName() {
    	// We simply return name.
        return name;
    }

    /**
	* Returns the gamesPlayed instance variable
	* 
	* @return the gamesPlayed instance variable
	*/
    public int getGamesPlayed() {
    	// We simply return gamesPlayed.
        return gamesPlayed;
    }

    /**
   	* Returns the gamesStarted instance variable
   	* 
   	* @return the gamesStarted instance variable
   	*/
    public int getGamesStarted() {
    	// We simply return gamesStarted.
        return gamesStarted;
    }

    /**
   	* Returns the rpg instance variable
   	* 
   	* @return the rpg instance variable
   	*/
    public double getRPG() {
    	// We simply return rpg.
        return rpg;
    }

    /**
   	* Returns the apg instance variable
   	* 
   	* @return the apg instance variable
   	*/
    public double getAPG() {
    	// We simply return apg.
        return apg;
    }

    /**
   	* Returns the ppg instance variable
   	* 
   	* @return the ppg instance variable
   	*/
    public double getPPG() {
    	// We simply return ppg.
        return ppg;
    }
    
    /**
	* Returns the string representation of this class, calling all getters.
	* 
	* @return toString
	*/
    public String toString() {
    	// With indenting and new lines, all the getters are called and returned.
        return 
                "\n\tName: " + getName() +
                "\n\tGames Played: " + getGamesPlayed() +
                "\n\tGames Started: " + getGamesStarted() +
                "\n\tRPG: " + getRPG() +
                "\n\tAPG: " + getAPG() +
                "\n\tPPG: " + getPPG();
    }
}
