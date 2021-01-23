package com.example.movi.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movi.Adapter.ClipAdapter;
import com.example.movi.Models.Clip;
import com.example.movi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvClip;
    private ClipAdapter clipAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        play_fab = findViewById(R.id.play_fab);
        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MovieDetailActivity.this, MoviePlayerActivity.class);
                startActivity(intent);
            }
        });
        RvClip = findViewById(R.id.rv_clip);

        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        String movieDesc = getIntent().getExtras().getString("description");

        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);

        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);

        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);

        tv_description = findViewById(R.id.detail_movie_desc);
        tv_description.setText(movieDesc);

        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

        setupRvClip();
        }

      void setupRvClip(){
        List<Clip> mData = new ArrayList<>();
          mData.add(new Clip(R.drawable.enola1));
          mData.add(new Clip(R.drawable.enola2));
          mData.add(new Clip(R.drawable.enola3));
          mData.add(new Clip(R.drawable.enola4));

          List<Clip> mData1 = new ArrayList<>();
          mData1.add(new Clip(R.drawable.high1));
          mData1.add(new Clip(R.drawable.high2));
          mData1.add(new Clip(R.drawable.high3));
          mData1.add(new Clip(R.drawable.high4));

          clipAdapter = new ClipAdapter(this, mData1);

          clipAdapter = new ClipAdapter(this, mData);
          RvClip.setAdapter(clipAdapter);
          RvClip.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

}
