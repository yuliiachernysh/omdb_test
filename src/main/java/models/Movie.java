package models;

public class Movie {
    private String id;
    private String title;
    private String year;
    private String plotType;
    private String plot;

    public Movie(String id, String title, String year, String plotType, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plotType = plotType;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPlotType() {
        return plotType;
    }

    public String getId() {
        return id;
    }

    public String getPlot() {
        return plot;
    }
}
