package com.ikayz.irate_rest;// Created by ikayz on 16/11/2020

import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class RestaurantHelperClass {
    String restaurantName;
    String dateTime;
    String mealPrice;
    String reporterName;
    String notes;
    int timeDate;
    Float  serviceRating, cleanlinessRating, foodQualityRating;
    Spinner restaurantType;

    public RestaurantHelperClass() {
    }

    public RestaurantHelperClass(String restaurant, String date, String price, String reporter,
                                 Float service, Float cleanliness, Float food, int time, String notes) {
        this.restaurantName = restaurant;
        this.dateTime = date;
        this.mealPrice = price;
        this.reporterName = reporter;
        this.serviceRating = service;
        this.cleanlinessRating = cleanliness;
        this.foodQualityRating = food;
        this.timeDate = time;
        this.notes = notes;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public Float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Float serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Float getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(Float cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public Float getFoodQualityRating() {
        return foodQualityRating;
    }

    public void setFoodQualityRating(Float foodQualityRating) {
        this.foodQualityRating = foodQualityRating;
    }

    public int getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(int timeDate) {
        this.timeDate = timeDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
