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

    public Instance(String departure, String checkInDate, String checkOutDate, String adultsCount,
                    String childrenCount, String roomsCount, String minPricePerNight, String maxPricePerNight) {
        this.departure = departure;
        this.checkInDate = LocalDate.parse(checkInDate);
        this.checkOutDate = LocalDate.parse(checkOutDate);
        this.adultsCount = Integer.parseInt(adultsCount);
        this.childrenCount = Integer.parseInt(childrenCount);
        this.roomsCount = Integer.parseInt(roomsCount);
        this.minPricePerNight = Integer.parseInt(minPricePerNight);
        this.maxPricePerNight = Integer.parseInt(maxPricePerNight);
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getMinPricePerNight() {
        return minPricePerNight;
    }

    public void setMinPricePerNight(int minPricePerNight) {
        this.minPricePerNight = minPricePerNight;
    }

    public int getMaxPricePerNight() {
        return maxPricePerNight;
    }

    public void setMaxPricePerNight(int maxPricePerNight) {
        this.maxPricePerNight = maxPricePerNight;
    }
}
