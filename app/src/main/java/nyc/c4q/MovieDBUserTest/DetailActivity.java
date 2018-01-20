package nyc.c4q.MovieDBUserTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;
import nyc.c4q.MovieDBUserTest.Models.MovieReview;
import nyc.c4q.MovieDBUserTest.Models.MovieReviewDisplay;
import nyc.c4q.MovieDBUserTest.controller.ReviewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

/**
 * Created by Shant on 1/13/2018.
 */

public class DetailActivity extends AppCompatActivity {

  private TextView voteCount;
  private TextView title;
  private TextView release;
  private TextView rating;
  private TextView language;
  private TextView desc;
  private TextView country;
  private ImageView poster;
  private RatingBar ratingBar;
  private RecyclerView reviewRecycler;
  private ReviewAdapter reviewAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_activity);
    setVariables();
  }

  public void setVariables() {
    title = findViewById(R.id.detail_title);
    release = findViewById(R.id.detail_release);
    rating = findViewById(R.id.detail_rating);
    poster = findViewById(R.id.detail_image);
    desc = findViewById(R.id.detail_desc);
    desc.setMovementMethod(new ScrollingMovementMethod());
    ratingBar = findViewById(R.id.detail_rating_bar);
    voteCount = findViewById(R.id.detail_votes);
    language = findViewById(R.id.detail_language);
    country = findViewById(R.id.detail_country);

    reviewRecycler = findViewById(R.id.movie_reviews_rv);
    getIntents();
  }

  public void getIntents() {
    Bundle extras = getIntent().getExtras();
    release.setText(extras.getString("release"));
    title.setText(extras.getString("title"));
    rating.setText(Double.toString(extras.getDouble("rating")) + "/10");
    desc.setText(extras.getString("desc"));
    ratingBar.setRating((float) extras.getDouble("rating") / 2);
    voteCount.setText("(" + extras.get("votes") + ")");
    language.setText(extras.getString("lang").toUpperCase());
    country.setText(extras.getString("country"));
    Picasso.with(getBaseContext()).load(extras.getString("poster")).into(poster);
    if (extras.getString("Tv") == "isTV") {
      loadReviews(extras.getInt("movie_id"));
    }
  }

  private void loadReviews(int movie_id) {
    Call<MovieReview> movieReviewCall =
        DBCallback.getMovieReviews(movie_id, getResources().getString(R.string.movie_db_api_key),
            "en-US", 1);
    movieReviewCall.enqueue(new Callback<MovieReview>() {
      @Override public void onResponse(Call<MovieReview> call, Response<MovieReview> response) {

        List<MovieReviewDisplay> movieReviewDisplays = response.body().getResults();
        reviewRecycler = findViewById(R.id.movie_reviews_rv);
        reviewAdapter = new ReviewAdapter(movieReviewDisplays);
        LinearLayoutManager linearLayoutManager =
            new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        reviewRecycler.setAdapter(reviewAdapter);
        reviewRecycler.setLayoutManager(linearLayoutManager);
      }

      @Override public void onFailure(Call<MovieReview> call, Throwable t) {

      }
    });
  }
}
