package models;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestParameters {
    private String title;
    private String plot;
    private String responseType;
    private Integer year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getResponseType() {
        if(responseType == null){
            return "json";
        }

        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String buildQuery() throws UnsupportedEncodingException {
        String query = "";

        if(title != null){
            query += "&t=" + URLEncoder.encode(title, "UTF-8");
        }

        if(plot != null){
            query += "&plot=" + URLEncoder.encode(plot, "UTF-8");
        }

        if(responseType != null){
            query += "&r=" + URLEncoder.encode(responseType, "UTF-8");
        }

        if(year != null){
            query += "&y=" + year;
        }

        return query;
    }
}
