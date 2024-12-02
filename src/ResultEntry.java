

public class ResultEntry {
    double matchScore;
    Laptops laptop;

    /**
     * Create Entry Used to Sort By matchScore
     * @param resultFilter SurveyResult Object used to get matchScore
     * @param laptop Laptop Object
     */
    public ResultEntry(SurveyResult resultFilter, Laptops laptop) {
        matchScore = resultFilter.getMatchScore(laptop);
        this.laptop = laptop;
    }

    /**
     * [FOR TESTING ONLY]
     * Create Entry with manually inputted data
     * @param matchScore Match Score out of 4
     * @param laptop Laptop Object
     */
    public ResultEntry(double matchScore, Laptops laptop) {
        this.matchScore = matchScore;
        this.laptop = laptop;
    }

    // Getters
    public double getMatchScore() {
        return matchScore;
    }
    public Laptops getLaptop() {
        return laptop;
    }

    // toString
    @Override
    public String toString() {
        return "ResultEntry [matchScore=" + matchScore + ", laptop=" + laptop + "]";
    }
}
