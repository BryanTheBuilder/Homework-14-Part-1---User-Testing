package nyc.c4q.MovieDBUserTest.controller;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.viewHolder.MovieViewHolder;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<MovieResults> resultsList;
    private Context context;

    public MovieAdapter(Context context) {
        resultsList = new ArrayList<>();
        this.context = context;
    }

    public void listResults(List<MovieResults> movieResults) {
        resultsList.addAll(movieResults);
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_itemview, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        ((MovieViewHolder) holder).onBind(resultsList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
