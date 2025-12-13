package com.example.moviesandseries.api.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "favorites")
public class Favorite implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String movie; //
    public String posterPath;

    public Favorite(String title, String movie, String posterPath) {
        this.title = title;
        this.movie = movie;
        this.posterPath = posterPath;
    }

    public Favorite() {

    }
}

