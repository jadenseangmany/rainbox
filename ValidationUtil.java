package rainbox;

/**
 * Utility class for input validations.
 */
public class ValidationUtil {

    private ValidationUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Validates if a string is not null or empty.
     *
     * @param str The string to validate.
     * @return true if the string is not null and not empty.
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Validates if a number is within a specified range.
     *
     * @param number The number to validate.
     * @param min    The minimum value (inclusive).
     * @param max    The maximum value (inclusive).
     * @return true if the number is within the range.
     */
    public static boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    // You can add more validation methods as needed
}
