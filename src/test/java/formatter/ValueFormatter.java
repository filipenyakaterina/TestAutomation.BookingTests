package formatter;

public class ValueFormatter {
    private static final String SEPARATOR = " ";
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final String KILOMETER_SIGN = "km";
    private static final Integer METERS_IN_KILOMETER = 1000;

    public static Integer getValueFromPrice(String price) {
        return Integer.valueOf(price.split(SEPARATOR)[FIRST_INDEX]);
    }

    public static Integer getValueFromRating(String rating) {
        return Integer.valueOf(rating.split(SEPARATOR)[ZERO_INDEX]);
    }

    public static Integer getValueInMetersFromDistance(String distance) {
        String[] distanceParts = distance.split(SEPARATOR);
        Double numericalValueOfDistance = Double.valueOf(distanceParts[ZERO_INDEX]);
        double valueInMeters = distanceParts[FIRST_INDEX].equals(KILOMETER_SIGN) ?
                (numericalValueOfDistance * METERS_IN_KILOMETER) : numericalValueOfDistance;
        return (int) valueInMeters;
    }
}
