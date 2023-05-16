public class HallOfFameCoach {
	// Declaring the instance variables.
	// HallOfFameCoach has a coach(String).
	// HallOfFameCoach has a games(int).
	// HallOfFameCoach has a rings(int).
	// HallOfFameCoach has a winsOverHalf(double).
    private String coach;
    private int games;
    private int rings;
    private double winsOverHalf;

    // Constructor for HallOfFameCoach with all parameters
    public HallOfFameCoach(String coach, int games, int rings, double wins) {
    	// If any number is negative, it's impossible for a coach, so an exception is thrown.
    	// Otherwise, the instance variables are set to the parameters.
    	if (games < 0 || rings < 0 || wins < 0) {
            throw new IllegalArgumentException("Invalid input values");
        }
        this.coach = coach;
        this.games = games;
        this.rings = rings;
        this.winsOverHalf = wins;
    }

    /**
   	* Returns the coach instance variable
   	* 
   	* @return the coach instance variable
   	*/
    public String getCoach() {
    	// We simply return coach.
        return coach;
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
   	* Returns the rings instance variable
   	* 
   	* @return the rings instance variable
   	*/
    public int getRings() {
    	// We simply return rings.
        return rings;
    }

    /**
   	* Returns the winsOverHalf instance variable
   	* 
   	* @return the winsOverHalf instance variable
   	*/
    public double getWinsOverHalf() {
    	// We simply return winsOverHalf.
        return winsOverHalf;
    }

    /**
	* Returns the string representation of this class, calling all getters.
	* 
	* @return toString
	*/
    public String toString() {
    	// With indenting and new lines, all the getters are called and returned.
        return "\n\tCoach: " + coach +
                "\n\tGames: " + games +
                "\n\tRings: " + rings +
                "\n\tWins Over Half: " + winsOverHalf;
    }

    
}
