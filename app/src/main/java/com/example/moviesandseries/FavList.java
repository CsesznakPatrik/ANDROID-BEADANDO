package com.example.moviesandseries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesandseries.api.model.AppDatabase;
import com.example.moviesandseries.api.model.Favorite;
import com.example.moviesandseries.ui.adapter.FavoriteAdapter;

import java.util.List;

public class FavList extends Fragment {

    private RecyclerView recyclerView;
    private FavoriteAdapter adapter;
    private List<Favorite> favoriteList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav_list, container, false);

        recyclerView = view.findViewById(R.id.favoritesRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        favoriteList = AppDatabase.getDatabase(getContext()).favoriteDao().getAllFavorites();

        adapter = new FavoriteAdapter(getContext(), favoriteList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
