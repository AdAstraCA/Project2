public class BenchPlayer extends CurrentPlayer {
	// Declaring the instance variables.
	// BenchPlayer is a CurrentPlayer.
	// BenchPlayer has a ortg(int).
	// BenchPlayer has a drtg(int).
	// BenchPlayer is a CurrentPlayer.
	
	private int ortg;
	private int drtg;

	// Constructor for BenchPlayer with all CurrentPlayer and rating parameters
	public BenchPlayer(String player, int gamesPlayed, int gamesStarted, double trb, double ast, double pts, int ortg, int drtg) {
		// All parameters passed to CurrentPlayer with super() except ortg and drtg, which are passed to the instance variables.
		super(player, gamesPlayed, gamesStarted, trb, ast, pts);
		this.ortg = ortg;
		this.drtg = drtg;
	}
    
	/**
	* Returns the ortg instance variable
	* 
	* @return the ortg instance variable
	*/
    public int getOrtg() {
    	// We simply return ortg.
        return ortg;
    }
    
    /**
	* Returns the drtg instance variable
	* 
	* @return the drtg instance variable
	*/
    public int getDrtg() {
    	// We simply return drtg.
        return drtg;
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
                "\n\tPPG: " + getPPG() +
                "\n\tORTG: " + getOrtg() +
                "\n\tDRTG: " + getDrtg();
    }

}
