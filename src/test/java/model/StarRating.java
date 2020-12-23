package model;

public enum StarRating implements DataValueProviding {
    TWO_STARS(2), THREE_STARS(3), FOUR_STARS(4), FIVE_STARS(5), UNRATED(0);

    private int dataValue;

    StarRating(int dataValue) {
        this.dataValue = dataValue;
    }

    public int getDataValue() {
        return dataValue;
    }

    @Override
    public String toString() {
        if (this.equals(UNRATED)) {
            return "Unrated";
        } else {
            return dataValue + " stars";
        }
    }
}
