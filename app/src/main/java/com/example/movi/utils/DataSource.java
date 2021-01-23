package com.example.movi.utils;

import com.example.movi.Models.Movie;
import com.example.movi.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies() {
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("High School Musical:The Musical:The Holiday Special",R.drawable.high,R.drawable.cover1, "The cast of “High School Musical: The Musical: The Series” delivers an abundance of feel-good holiday cheer as they perform their favorite Christmas, Hanukkah and New Year’s songs and share their fondest holiday memories."));
        lstMovies.add(new Movie("Safety", R.drawable.safety,R.drawable.c2, "The story of Ray-Ray McElrathbey, a freshman football player for Clemson University, who secretly raised his younger brother on campus after his home life became too unsteady."));
        lstMovies.add(new Movie("Insert Coin",R.drawable.insert, R.drawable.c3, "The oral history of a team of geeks and misfits in the back of a Chicago factory creating the biggest video games (Mortal Kombat, NBA JAM, and others) of all time."));

        return lstMovies;
    }

    public static List<Movie> getPopularWeeks() {
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Enola Holmes", R.drawable.enola,R.drawable.slide1, "While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord"));
        lstMovies.add(new Movie("Insert Coin",R.drawable.insert, R.drawable.c3, "The oral history of a team of geeks and misfits in the back of a Chicago factory creating the biggest video games (Mortal Kombat, NBA JAM, and others) of all time."));
        lstMovies.add(new Movie("High School Musical:The Musical:The Holiday Special",R.drawable.high,R.drawable.cover1, "The cast of “High School Musical: The Musical: The Series” delivers an abundance of feel-good holiday cheer as they perform their favorite Christmas, Hanukkah and New Year’s songs and share their fondest holiday memories."));
        lstMovies.add(new Movie("Safety", R.drawable.safety,R.drawable.c2, "The story of Ray-Ray McElrathbey, a freshman football player for Clemson University, who secretly raised his younger brother on campus after his home life became too unsteady."));
        lstMovies.add(new Movie("Tenet",R.drawable.tenet,R.drawable.c4, "Armed with only one word – Tenet – and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time."));

        return lstMovies;
    }
}
