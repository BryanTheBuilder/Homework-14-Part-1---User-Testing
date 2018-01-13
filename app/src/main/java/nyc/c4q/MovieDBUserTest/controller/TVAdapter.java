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


    private static final int TVITEM = 0;
    private static final int TVLOADING = 1;

    private List<TvResults> resultsList = new ArrayList<>();
    private Context context;

    public TVAdapter(Context context, List<TvResults> tvResults) {
        this.resultsList = tvResults;
        this.context = context;
    }

    public void listResults(List<TvResults> movieResults) {
        resultsList.addAll(movieResults);
        notifyDataSetChanged();
    }

    @Override
    public TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_tv, parent, false);
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
