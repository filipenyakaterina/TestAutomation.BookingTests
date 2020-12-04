package model;

import java.time.LocalDate;

public class Instance {
    private String departure;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int adultsCount;
    private int childrenCount;
    private int roomsCount;
    private int minPricePerNight;
    private int maxPricePerNight;
    private int reviewScore;

    public Instance(String departure, String checkInDate, String checkOutDate, String adultsCount,
                    String childrenCount, String roomsCount, String minPricePerNight, String maxPricePerNight, String reviewScore) {
        this.departure = departure;
        this.checkInDate = LocalDate.parse(checkInDate);
        this.checkOutDate = LocalDate.parse(checkOutDate);
        this.adultsCount = Integer.parseInt(adultsCount);
        this.childrenCount = Integer.parseInt(childrenCount);
        this.roomsCount = Integer.parseInt(roomsCount);
        this.minPricePerNight = Integer.parseInt(minPricePerNight);
        this.maxPricePerNight = Integer.parseInt(maxPricePerNight);
        this.reviewScore = Integer.parseInt(reviewScore);
    }

    public String getDeparture() {
        return departure;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public int getMinPricePerNight() {
        return minPricePerNight;
    }

    public int getMaxPricePerNight() {
        return maxPricePerNight;
    }

    public int getReviewScore() {
        return reviewScore;
    }
}
