package seedu.revision.model.quiz;

import static java.util.Objects.requireNonNull;
import static seedu.revision.commons.util.AppUtil.checkArgument;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Represents the statistics of a quiz completed in the Revision Tool.
 * Guarantees: immutable; is valid as declared in {@link #isValidStatistics (String)}
 */
public class Statistics {

    public static final String MESSAGE_CONSTRAINTS = "Statistics are made up of total scores and scores of "
            + "difficulty levels 1, 2, 3.";

    /*
     * The first character of the statistics must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     * 1 to more digits before and after the decimal point.
     */
    public static final String VALIDATION_REGEX = "(?i)\\d+\\/\\d+";

    // Initialising a dictionary
    private Dictionary<String, String> scores = new Hashtable<>();

    public Statistics(Dictionary scores) {
        requireNonNull(scores);
    }

    public Statistics(String results) {
        requireNonNull(results);
        String[] splitStr = results.split(" , ", 0);
        for (String subStr : splitStr) {
            String[] values = subStr.split(" = ", 2);
            checkArgument(isValidStatistics(values[1]), MESSAGE_CONSTRAINTS);
            this.scores.put(values[0], values[1]);
        }
    }

    /**
     * Returns true if a given string is a valid statistics.
     */
    public static boolean isValidStatistics(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    /**
     * Converting the statistics into a string to be stored later.
     * @return a fixed string format.
     */
    public String toString() {
        StringBuilder allScores = new StringBuilder();
        for (Enumeration i = scores.keys(); i.hasMoreElements();) {
            allScores.append(i.nextElement()).append(" = ").append(scores.get(i.nextElement())).append(" , ");
        }

        return allScores.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Statistics // instanceof handles nulls
                && scores == (((Statistics) other).scores)); // state check
    }

    @Override
    public int hashCode() {
        return String.format(String.valueOf(scores)).hashCode();
    }

}
