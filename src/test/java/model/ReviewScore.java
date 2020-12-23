package model;

public enum ReviewScore implements DataValueProviding {
    WONDERFUL(9), VERY_GOOD(8), GOOD(7), PLEASANT(6);

    private int dataValue;

    ReviewScore(int dataValue) {
        this.dataValue = dataValue;
    }

    public int getDataValue() {
        return dataValue;
    }

    @Override
    public String toString() {
        return this.name() + ": " + dataValue + "+";
    }
}
