public class Starter extends CurrentPlayer implements WinImpacter {
	// Declaring the instance variables.
	// Starter is a CurrentPlayer.
	// Starter implements WinImpacter.
	// Starter has a spg(double).
	// Starter has a bpg(double).
	// Starter has a ws(double).
    private double spg;
    private double bpg;
    private double ws;

 // Constructor for Starter with all CurrentPlayer and rating parameters
    public Starter(String name, int gamesPlayed, int gamesStarted, double rpg, double apg, double pts, double stl, double blk, double ws) {
    	// All parameters passed to CurrentPlayer with super() except stl, blk, and ws, which are passed to the instance variables.
        super(name, gamesPlayed, gamesStarted, rpg, apg, pts);
        this.spg = stl;
        this.bpg = blk;
        this.ws = ws;
    }

    /**
	* Returns the spg instance variable
	* 
	* @return the spg instance variable
	*/
    public double getSPG() {
    	// We simply return spg.
        return spg;
    }

    /**
	* Returns the bpg instance variable
	* 
	* @return the bpg instance variable
	*/
    public double getBPG() {
    	// We simply return bpg.
        return bpg;
    }

    /**
	* Returns the ws instance variable
	* 
	* @return the ws instance variable
	*/
    public double getWs() {
    	// We simply return ws.
        return ws;
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
                "\n\tSPG: " + getSPG() +
                "\n\tBPG: " + getBPG() +
                "\n\tWS: " + getWs();
    }

}
