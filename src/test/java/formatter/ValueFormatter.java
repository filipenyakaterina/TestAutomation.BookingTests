package formatter;

public class ValueFormatter {
    private static final String SEPARATOR = " ";
    private static final int PRICE_VALUE_INDEX = 1;
    private static final int RATING_VALUE_INDEX = 0;

    public static Integer getValueFromPrice(String price) {
        return Integer.valueOf(price.split(SEPARATOR)[PRICE_VALUE_INDEX]);
    }

    public static Integer getValueFromRating(String rating) {
        return Integer.valueOf(rating.split(SEPARATOR)[RATING_VALUE_INDEX]);
    }
}
