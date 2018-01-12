package nyc.c4q.MovieDBUserTest.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.TvResults;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.viewHolder.TVViewHolder;

public class TVAdapter extends RecyclerView.Adapter<TVViewHolder> {

    private List<TvResults> resultsList;
    private Context context;

    public TVAdapter(Context context) {
        resultsList = new ArrayList<>();
        this.context = context;
    }

    public void listResults(List<TvResults> movieResults) {
        resultsList.addAll(movieResults);
        notifyDataSetChanged();
    }

    @Override
    public TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_itemview, parent, false);
        return new TVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TVViewHolder holder, int position) {
        ((TVViewHolder) holder).onBind(resultsList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
