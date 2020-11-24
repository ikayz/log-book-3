package com.ikayz.irate_rest;// Created by ikayz on 16/11/2020

import android.widget.RatingBar;

public class RestaurantHelperClass {
    String restaurantName, dateTime, mealPrice, reporterName;

    public RestaurantHelperClass() {
    }

    public RestaurantHelperClass(String restaurant, String date, String price, String reporter) {
        this.restaurantName = restaurant;
        this.dateTime = date;
        this.mealPrice = price;
        this.reporterName = reporter;
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
}
