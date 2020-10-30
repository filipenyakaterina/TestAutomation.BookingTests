package formatter;

public class ValueFormatter {
    private static final String SEPARATOR = " ";
    private static final int PRICE_VALUE_INDEX = 1;

    public static Integer getValueFromPrice(String price) {
        return Integer.valueOf(price.split(SEPARATOR)[PRICE_VALUE_INDEX]);
    }
}
