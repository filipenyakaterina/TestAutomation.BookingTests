package model;

public enum Distance implements DataValueProviding {
    LESS_THAN_ONE_KM(1000), LESS_THAN_THREE_KM(3000), LESS_THAN_FIVE_KM(5000);

    private static final int METERS_PER_KILOMETER = 1000;
    private int dataValue;

    Distance(int dataValue) {
        this.dataValue = dataValue;
    }

    public int getDataValue() {
        return dataValue;
    }

    @Override
    public String toString() {
        return "less than " + (dataValue / METERS_PER_KILOMETER) + " km";
    }
}
