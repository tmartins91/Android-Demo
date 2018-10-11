package com.tmartins.demo.tmandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class CountriesResult {

    @SerializedName("IsSuccess")
    @Expose
    private Boolean success = null;

    @SerializedName("UserMessage")
    @Expose
    private String userMessage = null;

    @SerializedName("TechnicalMessage")
    @Expose
    private String technicalMessage = null;

    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount = null;

    @SerializedName("Response")
    @Expose
    private List<Country> countryList = null;

    public boolean getSuccess() {
        return success != null && success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = technicalMessage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("success", success).append("userMessage", userMessage)
                .append("technicalMessage", technicalMessage).append("totalCount", totalCount)
                .append("countryList", countryList)
                .toString();
    }

}
