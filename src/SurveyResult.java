import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class SurveyResult {
    // Filter Info
    private int[] targetBudget;
    private laptopType targetType;
    private double[] targetScreenSize;
    private brand targetBrand;

    // Enums for Options
    // (Enums: https://www.w3schools.com/java/java_enums.asp)
    public enum laptopType {
        STUDENT, 
        GAMING, 
        PROFESSIONAL
    }
    public enum brand {
        HP, 
        DELL,
        APPLE,
        FRAMEWORK
    }

    /**
     * Create a SurveyResult Item Using Answers From the SurveyFrame
     * @param answers Answers from the SurveyFrame
     */
    public SurveyResult(String[] answers) {
        // Rule Switch to Set Budget
        // (Rule Switch: https://stackoverflow.com/questions/77889555/what-is-the-difference-between-a-rule-switch-and-a-regular-switch-in-java)
        targetBudget = switch (answers[0]) {
            case "Under $1000" -> new int[] {0, 1000};
            case "$1000 - $2000" -> new int[] {1000, 2000};
            case "$2000 - $2500" -> new int[] {2000, 2500};
            case "Over $2500" -> new int[] {2500, Integer.MAX_VALUE};
            default -> null;
        };
        // Rule Switch for Laptop Type
        targetType = switch (answers[1]) {
            case "Student" -> laptopType.STUDENT;
            case "Gaming" -> laptopType.GAMING;
            case "Professional" -> laptopType.PROFESSIONAL;
            default -> null;
        };
        // Rule Switch for Screen Size
        targetScreenSize = switch (answers[2]) {
            case "13 in - 14 in" -> new double[] {13.0, 14.0};
            case "14.1 in - 15 in" -> new double[] {14.1, 15.0};
            case "15.1 in - 16 in" -> new double[] {15.1, 16.0};
            default -> null;
        };
        // Rule Switch for Brand
        targetBrand = switch (answers[3]) {
            case "HP" -> brand.HP;
            case "Dell" -> brand.DELL;
            case "Apple" -> brand.APPLE;
            case "Framework" -> brand.FRAMEWORK;
            default -> null;
        };
    }

    /**
     * Generate a Match Score base on Survey Result
     * @param laptop laptop to get score
     * @return score out of 4
     */
    public double getMatchScore(Laptops laptop) {
        double matchScore = 0;
        // Match Score for Budgets
        if (laptop.getPrice() <= targetBudget[1])
            matchScore += 0.8;
        if (laptop.getPrice() >= targetBudget[0])
            matchScore += 0.2;
        // Match Score for Laptop Type
        if (laptop.getType().equalsIgnoreCase(targetType.toString())) 
            matchScore += 1;
        else if (laptop.getType().equals("Professional"))
            matchScore += 0.6;
        else if (laptop.getType().equals("Gaming"))
            matchScore += 0.3;
        // Match Score for Screen Size;
        if (laptop.getDisplaySize() >= targetScreenSize[0])
            matchScore += 0.6;
        if (laptop.getDisplaySize() <= targetScreenSize[1])
            matchScore += 0.4;
        // Match Score for Brand
        if (targetBrand == null)
            matchScore += 1;
        else if (laptop.getBrand().equalsIgnoreCase(targetBrand.toString()))
            matchScore += 1;
        return matchScore;
    }

    // toString
    @Override
    public String toString() {
        return "SurveyResult [targetBudget=" + Arrays.toString(targetBudget) + ", targetType=" + targetType
                + ", targetScreenSize=" + Arrays.toString(targetScreenSize) + ", targetBrand=" + targetBrand + "]";
    }
}
