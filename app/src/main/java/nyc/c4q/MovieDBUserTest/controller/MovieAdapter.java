package nyc.c4q.MovieDBUserTest.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.Utils.OnBottomReachedListner;
import nyc.c4q.MovieDBUserTest.viewHolder.MovieViewHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
  private List<MovieResults> resultsList = new ArrayList<>();
  private Context context;
  OnBottomReachedListner onBottomReachedListner;
  int totalpages;
  String sortBy;
  String genre;
  int currentPage = 1;

  public void setOnBottomReachedListener(OnBottomReachedListner onBottomReachedListner) {
    this.onBottomReachedListner = onBottomReachedListner;
  }

  public MovieAdapter(Context context, List<MovieResults> resultsList, int totalpages,
      String sortBy, String genre) {
    this.resultsList = resultsList;
    this.context = context;
    this.totalpages = totalpages;
    this.sortBy = sortBy;
    this.genre = genre;
  }

  @Override public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_movie, parent, false);
    return new MovieViewHolder(view);
  }

  @Override public void onBindViewHolder(MovieViewHolder holder, int position) {

    if (position == resultsList.size() - 1) {
      onBottomReachedListner.onBottomReached(position, totalpages);
    }

    ((MovieViewHolder) holder).onBind(resultsList.get(position));
  }

  @Override public int getItemCount() {
    return resultsList.size();
  }

  public void loadMoreMovies() {
    currentPage++;
    Call<Movie> movieCall =
        DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sortBy, false,
            currentPage, genre);

    movieCall.enqueue(new Callback<Movie>() {
      @Override public void onResponse(Call<Movie> call, Response<Movie> response) {
        List<MovieResults> newMovieList = response.body().getResults();
        resultsList.addAll(newMovieList);
        notifyDataSetChanged();
      }

      @Override public void onFailure(Call<Movie> call, Throwable t) {

      }
    });
  }

  public int getCurrentPage() {
    return currentPage;
  }
}
