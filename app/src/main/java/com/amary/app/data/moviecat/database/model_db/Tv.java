package com.amary.app.data.moviecat.database.model_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tv")
public class Tv {
    @PrimaryKey
    @ColumnInfo(name = "id_tv")
    public int idTv;

    @ColumnInfo(name = "title_tv")
    public String titleTv;

    @ColumnInfo(name = "date_tv")
    public String dateTv;

    @ColumnInfo(name = "rate_tv")
    public Double rateTv;

    @ColumnInfo(name = "poster_tv")
    public String posterTv;

    @ColumnInfo(name = "backdrops_tv")
    public String backdropsTv;

    public Tv(int idTv, String titleTv, String dateTv, Double rateTv, String posterTv, String backdropsTv) {
        this.idTv = idTv;
        this.titleTv = titleTv;
        this.dateTv = dateTv;
        this.rateTv = rateTv;
        this.posterTv = posterTv;
        this.backdropsTv = backdropsTv;
    }

    public int getIdTv() {
        return idTv;
    }

    public String getTitleTv() {
        return titleTv;
    }

    public String getDateTv() {
        return dateTv;
    }

    public Double getRateTv() {
        return rateTv;
    }

    public String getPosterTv() {
        return posterTv;
    }

    public String getBackdropsTv() {
        return backdropsTv;
    }
}
