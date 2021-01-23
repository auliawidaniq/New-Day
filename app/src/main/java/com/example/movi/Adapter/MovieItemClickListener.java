package com.example.movi.Adapter;

import android.widget.ImageView;

import com.example.movi.Models.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImageView);

}
