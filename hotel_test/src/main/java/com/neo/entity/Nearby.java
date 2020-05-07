package com.neo.entity;

public class Nearby {
    private String nearbyID;
    private String nearbyName;
    private String address;
    private String url;

    public String getNearbyID() {
        return nearbyID;
    }

    public void setNearbyID(String nearbyID) {
        this.nearbyID = nearbyID;
    }

    public String getNearbyName() {
        return nearbyName;
    }

    public void setNearbyName(String nearbyName) {
        this.nearbyName = nearbyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
