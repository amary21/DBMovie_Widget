package com.amary.app.data.moviecat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.database.datasource.MovieRepository;
import com.amary.app.data.moviecat.database.local.LocalDatabase;
import com.amary.app.data.moviecat.database.local.MovieDataSource;
import com.amary.app.data.moviecat.database.model_db.Movie;
import com.amary.app.data.moviecat.networking.ApiServer;
import com.amary.app.data.moviecat.utils.LocalData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory{
    private final List<Movie> movieList = new ArrayList<>();
    private final Context mContext;

    StackRemoteViewsFactory(Context context) {
        this.mContext = context;
    }



    @SuppressLint("CheckResult")
    public void getMovie() {
        LocalData.localDatabase = LocalDatabase.getInstance(mContext);
        LocalData.movieRepository = MovieRepository.getInstance(MovieDataSource.getInstance(LocalData.localDatabase.movieDAO()));
        LocalData.movieRepository.getMovieItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> movies) {
                        movieList.addAll(movies);
                    }
                });
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {
        getMovie();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Log.e("DATA", "WKWKWKW");
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.favorite_film_app_widget);
        try{
            Bitmap bitmap = Glide.with(mContext)
                    .asBitmap()
                    .load(ApiServer.COVER_IMAGE + movieList.get(position).backdropsMovie)
                    .submit(512, 512)
                    .get();

            views.setImageViewBitmap(R.id.imageView, bitmap);

            Log.e("DATA", movieList.get(position).backdropsMovie);
        }catch (Exception e){
            e.printStackTrace();
        }

        views.setTextViewText(R.id.tv_title_widget, movieList.get(position).getTitleMovie());

        Bundle extras = new Bundle();
        extras.putInt(FavoriteFilmAppWidget.EXTRA_ITEM, position);

        Intent fillInIntent =new Intent();
        fillInIntent.putExtras(extras);

        views.setOnClickFillInIntent(R.id.imageView, fillInIntent);

        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
