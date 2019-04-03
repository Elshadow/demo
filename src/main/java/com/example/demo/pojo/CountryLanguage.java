package com.example.demo.pojo;

import com.example.demo.pojo.enums.Official;

public class CountryLanguage {

    private String countryCode;

    private String language;

    private Official offical;

    private Float percentage;

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the offical
     */
    public Official getOffical() {
        return offical;
    }

    /**
     * @param offical the offical to set
     */
    public void setOffical(Official offical) {
        this.offical = offical;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the percentage
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

}