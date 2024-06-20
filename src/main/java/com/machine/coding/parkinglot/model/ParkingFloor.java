package com.machine.coding.parkinglot.model;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }



}
