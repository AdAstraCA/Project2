public abstract class LosAngelesLakers {
	// Declaring instance variables.
	// LosAngelesLakers has a wins(int).
	// LosAngelesLakers has a losses(int).
    private int wins;
    private int losses;

    // Constructor for LosAngelesLakers with all parameters.
    public LosAngelesLakers(int wins, int losses) {
    	// If any number is negative, it's impossible, so an exception is thrown.
    	// Otherwise, the instance variables are set to the parameters.
        if (wins < 0 || losses < 0) {
            throw new IllegalArgumentException("Wins and losses must be non-negative");
        }
        this.wins = wins;
        this.losses = losses;
    }
    
    /**
   	* Returns the games instance variable
   	* 
   	* @return the games instance variable
   	*/
    public double getGames() {
    	// We simply return games by adding wins and losses.
		return wins + losses;
	}
}
