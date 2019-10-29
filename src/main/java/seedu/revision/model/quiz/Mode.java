package seedu.revision.model.quiz;

import static java.util.Objects.requireNonNull;
import static seedu.revision.commons.util.AppUtil.checkArgument;

/**
 * Represents the mode of a quiz in the Revision Tool.
 * Guarantees: immutable; is valid as declared in {@link #isValidMode(String)}
 */
public class Mode {

    public static final String MESSAGE_CONSTRAINTS = "Mode can only be normal / chaos / custom";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "(?i)\\bnormal\\b|\\bchaos\\b|^\\bcustom\\b";

    public final String mode;

    /**
     * Constructs a {@code Question}.
     *
     * @param mode A valid question.
     */
    public Mode(String mode) {
        requireNonNull(mode);
        checkArgument(isValidMode(mode), MESSAGE_CONSTRAINTS);
        this.mode = mode;
    }

    /**
     * Returns true if a given string is a valid question.
     */
    public static boolean isValidMode(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return mode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Mode // instanceof handles nulls
                && mode.equals(((Mode) other).mode)); // state check
    }

    @Override
    public int hashCode() {
        return mode.hashCode();
    }

}
