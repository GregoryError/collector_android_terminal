package com.databank.collector;

import com.databank.collector.pojos.Parameter;

import java.util.List;
import java.util.Map;

public class Report {


    private String userName;
    private String api_key;
    private String dateTime;
    private String lat;
    private String lon;

    private Map<Long, String> parameters;

    public Report() {
    }

    public Report(String userName, String api_key, String dateTime, String lat, String lon, Map<Long, String> parameters) {
        this.userName = userName;
        this.api_key = api_key;
        this.dateTime = dateTime;
        this.lat = lat;
        this.lon = lon;
        this.parameters = parameters;
    }


    public Map<Long, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<Long, String> parameters) {
        this.parameters = parameters;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

}
