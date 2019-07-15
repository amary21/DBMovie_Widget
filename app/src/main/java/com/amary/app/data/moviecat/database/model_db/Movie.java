package com.amary.app.data.moviecat.database.model_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movie")
public class Movie {

    @PrimaryKey
    @ColumnInfo(name = "id_movie")
    public int idMovie;

    @ColumnInfo(name = "title_movie")
    public String titleMovie;

    @ColumnInfo(name = "date_movie")
    public String dateMovie;

    @ColumnInfo(name = "rate_movie")
    public Double rateMovie;

    @ColumnInfo(name = "poster_movie")
    public String posterMovie;

    @ColumnInfo(name = "backdrops_movie")
    public String backdropsMovie;

    public Movie(int idMovie, String titleMovie, String dateMovie, Double rateMovie, String posterMovie, String backdropsMovie) {
        this.idMovie = idMovie;
        this.titleMovie = titleMovie;
        this.dateMovie = dateMovie;
        this.rateMovie = rateMovie;
        this.posterMovie = posterMovie;
        this.backdropsMovie = backdropsMovie;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public String getDateMovie() {
        return dateMovie;
    }

    public Double getRateMovie() {
        return rateMovie;
    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public String getBackdropsMovie() {
        return backdropsMovie;
    }
}
