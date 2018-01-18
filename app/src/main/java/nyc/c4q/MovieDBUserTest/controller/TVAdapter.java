package nyc.c4q.MovieDBUserTest.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.Models.TvResults;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.Utils.OnBottomReachedListner;
import nyc.c4q.MovieDBUserTest.viewHolder.TVViewHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

public class TVAdapter extends RecyclerView.Adapter<TVViewHolder> {

  private List<TvResults> resultsList = new ArrayList<>();
  private Context context;
  private int totalpages;
  String sortBy;
  String genre;
  OnBottomReachedListner onBottomReachedListner;
  int currentPage = 1;

  public void setOnBottomReachedListener(OnBottomReachedListner onBottomReachedListener) {
    this.onBottomReachedListner = onBottomReachedListener;
  }

  public TVAdapter(Context context, List<TvResults> tvResults, int totalpages, String sortBy,
      String genre) {
    this.resultsList = tvResults;
    this.context = context;
    this.totalpages = totalpages;
    this.sortBy = sortBy;
    this.genre = genre;
  }

  @Override public TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_tv, parent, false);
    return new TVViewHolder(view);
  }

  @Override public void onBindViewHolder(TVViewHolder holder, int position) {

    if (position == resultsList.size() - 1) {
      onBottomReachedListner.onBottomReached(position, totalpages);
    }

    ((TVViewHolder) holder).onBind(resultsList.get(position));
  }

  @Override public int getItemCount() {
    return resultsList.size();
  }

  public void loadMoreTvShows() {
    currentPage++;
    Call<TV> tvCall =
        DBCallback.getTvDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sortBy, currentPage,
            null, genre);
    tvCall.enqueue(new Callback<TV>() {
      @Override public void onResponse(Call<TV> call, Response<TV> response) {
        List<TvResults> newTVList = response.body().getResults();
        resultsList.addAll(newTVList);
        notifyDataSetChanged();
      }

      @Override public void onFailure(Call<TV> call, Throwable t) {

      }
    });
  }

  public int getCurrentPage() {
    return currentPage;
  }
}
