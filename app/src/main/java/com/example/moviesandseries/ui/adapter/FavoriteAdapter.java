package com.example.moviesandseries.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesandseries.R;
import com.example.moviesandseries.api.model.Favorite;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private Context context;
    private List<Favorite> favorites;

    public FavoriteAdapter(Context context, List<Favorite> favorites) {
        this.context = context;
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_series, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Favorite fav = favorites.get(position);
        holder.title.setText(fav.title);

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + fav.posterPath)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.seriesPoster);
            title = itemView.findViewById(R.id.seriesTitle);
        }
    }
}
