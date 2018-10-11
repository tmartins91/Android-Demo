package com.tmartins.demo.tmandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Country {

    @SerializedName("Name")
    @Expose
    private String name = null;

    @SerializedName("Region")
    @Expose
    private String region = null;

    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode = null;

    @SerializedName("Area")
    @Expose
    private Integer area = null;

    @SerializedName("FlagPng")
    @Expose
    private String flagPng = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getFlagPng() {
        return flagPng;
    }

    public void setFlagPng(String flagPng) {
        this.flagPng = flagPng;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name).append("region", region)
                .append("currencyCode", currencyCode).append("area", area)
                .append("flagPng", flagPng).append("flagPng", flagPng)
                .toString();
    }

}
