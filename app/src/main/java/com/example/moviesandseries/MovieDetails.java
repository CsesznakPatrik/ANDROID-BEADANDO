package com.example.moviesandseries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.moviesandseries.api.model.AppDatabase;
import com.example.moviesandseries.api.model.Favorite;
import com.example.moviesandseries.api.model.Movie;

public class MovieDetails extends Fragment {
    private Button favoritesBtn;
    private ImageView poster;
    private TextView title, overview;

    private Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        favoritesBtn = view.findViewById(R.id.addToFavoritesButton);
        poster = view.findViewById(R.id.detailsPoster);
        title = view.findViewById(R.id.detailsTitle);
        overview = view.findViewById(R.id.detailsOverview);

        if (getArguments() != null) {
            movie = (Movie) getArguments().getSerializable("movie");
        }

        if (movie != null) {
            title.setText(movie.getTitle());
            overview.setText(movie.getOverview());

            Glide.with(getContext())
                    .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                    .into(poster);
        }

        favoritesBtn.setOnClickListener(v -> {
            // Itt fogjuk elmenteni kedvencekbe
            Favorite fav = new Favorite();
            fav.title = movie.getTitle();
            fav.posterPath = movie.getPosterPath();
            fav.movie = movie.getOverview();
            fav.movie = "movie";

            new Thread(() -> {
                AppDatabase
                        .getDatabase(requireContext())
                        .favoriteDao()
                        .insert(fav);
            }).start();
            Toast.makeText(getContext(), movie.getTitle() + " Hozzáadva a kedvencekhez!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
