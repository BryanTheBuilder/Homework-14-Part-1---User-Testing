package nyc.c4q.MovieDBUserTest.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import nyc.c4q.MovieDBUserTest.Models.MovieReviewDisplay;
import nyc.c4q.MovieDBUserTest.R;

/**
 * Created by c4q on 1/19/18.
 */

public class ReviewHolder extends RecyclerView.ViewHolder {

  private TextView Author;
  private TextView Content;

  public ReviewHolder(View itemView) {
    super(itemView);
    Author = itemView.findViewById(R.id.author_name);
    Content = itemView.findViewById(R.id.review_text);
  }

  public void onBind(MovieReviewDisplay movieReviewDisplay) {
    String text = movieReviewDisplay.getContent();
    String name = movieReviewDisplay.getAuthor();
    Author.setText(name);
    Content.setText(text);
  }
}
