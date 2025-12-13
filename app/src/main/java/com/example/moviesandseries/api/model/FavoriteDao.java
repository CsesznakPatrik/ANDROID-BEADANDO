package com.example.moviesandseries.api.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert
    void insert(Favorite favorite);

    @Query("SELECT * FROM favorites")
    List<Favorite> getAllFavorites();

    @Query("DELETE FROM favorites WHERE id = :id")
    void deleteById(int id);
}
