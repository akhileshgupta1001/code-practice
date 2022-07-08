package com.system.design.FOODKART.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private Long item;
    private List<String> serviceablePincodes;
    private List<Review> reviews = new ArrayList<>();
    private Float rating;
    private int qauntity;
    private Integer createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public List<String> getServiceablePincodes() {
        return serviceablePincodes;
    }

    public void setServiceablePincodes(List<String> serviceablePincodes) {
        this.serviceablePincodes = serviceablePincodes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
}
