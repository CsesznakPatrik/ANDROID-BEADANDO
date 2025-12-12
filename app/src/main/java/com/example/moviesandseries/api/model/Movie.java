package com.example.moviesandseries.api.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String overview;
    private String poster_path;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return poster_path;
    }
}
