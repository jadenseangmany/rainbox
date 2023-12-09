package rainbox;

/**
 * Utility class for data conversions.
 */
public class ConversionUtil {

    private ConversionUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Converts a string to an integer. Returns a default value if the conversion fails.
     *
     * @param str           The string to convert.
     * @param defaultValue  The default value to return if conversion fails.
     * @return The converted integer or the default value.
     */
    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // Add more conversion methods as needed, like for parsing doubles, dates, etc.
}
