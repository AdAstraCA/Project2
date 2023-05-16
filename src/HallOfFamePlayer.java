public class HallOfFamePlayer implements WinImpacter {
	// Declaring the instance variables.
	// HallOfFamePlayer implements WinImpacter and thus has getWs().
	// HallOfFamePlayer has a name(String).
	// HallOfFamePlayer has a games(int).
	// HallOfFamePlayer has a rings(int).
	// HallOfFamePlayer has a rpg(double).
	// HallOfFamePlayer has a ppg(double).
	// HallOfFamePlayer has a apg(double).
	// HallOfFamePlayer has a ws(double).
    private String name;
    private int games;
    private double rpg;
    private double ppg;
    private double apg;
    private double ws;
    private int rings;

    // Constructor for HallOfFamePlayer with all parameters
    public HallOfFamePlayer(String name, int games, double rpg, double apg, double ppg, double ws, int rings) throws IllegalArgumentException {
    	// If any number is negative, it's impossible for a player, so an exception is thrown.
    	// Otherwise, the instance variables are set to the parameters.
    	if (games < 0 || rpg < 0 || apg < 0 || ppg < 0 || ws < 0 || rings < 0) {
            throw new IllegalArgumentException("Invalid input values");
        }
        this.name = name;
        this.games = games;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        this.ws = ws;
        this.rings = rings;
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
   	* Returns the games instance variable
   	* 
   	* @return the games instance variable
   	*/
    public int getGames() {
        // We simply return games.
    	return games;
    }

    /**
   	* Returns the ppg instance variable
   	* 
   	* @return the ppg instance variable
   	*/
    public double getPpg() {
    	// We simply return ppg.
        return ppg;
    }

    /**
   	* Returns the rpg instance variable
   	* 
   	* @return the rpg instance variable
   	*/
    public double getRpg() {
    	// We simply return rpg.
        return rpg;
    }

    /**
   	* Returns the apg instance variable
   	* 
   	* @return the apg instance variable
   	*/
    public double getApg() {
    	// We simply return apg.
        return apg;
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
   	* Returns the rings instance variable
   	* 
   	* @return the rings instance variable
   	*/
    public int getRings() {
    	// We simply return rings.
    	return rings;
    }

    /**
	* Returns the string representation of this class, calling all getters.
	* 
	* @return toString
	*/
    public String toString() {
    	// With indenting and new lines, all the getters are called and returned.
        return "\n\tName: " + name +
                "\n\tGames: " + games +
                "\n\tRPG: " + rpg +
                "\n\tPPG: " + ppg +
                "\n\tAPG: " + apg +
                "\n\tWS: " + ws +
                "\n\tRings: " + rings;
    }
}
