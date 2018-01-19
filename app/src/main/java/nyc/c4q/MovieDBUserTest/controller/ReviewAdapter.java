package nyc.c4q.MovieDBUserTest.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import nyc.c4q.MovieDBUserTest.Models.MovieReviewDisplay;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.viewHolder.ReviewHolder;

/**
 * Created by c4q on 1/19/18.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewHolder> {

  private List<MovieReviewDisplay> resultsLists = new ArrayList<>();

  public ReviewAdapter(List<MovieReviewDisplay> resultsLists) {
    this.resultsLists = resultsLists;
  }

  @Override public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);

    return new ReviewHolder(view);
  }

  @Override public void onBindViewHolder(ReviewHolder holder, int position) {
      holder.onBind(resultsLists.get(position));
  }

  @Override public int getItemCount() {
    return resultsLists.size();
  }
}
