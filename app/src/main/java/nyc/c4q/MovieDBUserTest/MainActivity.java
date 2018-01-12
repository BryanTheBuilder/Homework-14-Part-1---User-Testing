package nyc.c4q.MovieDBUserTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import nyc.c4q.MovieDBUserTest.API.MovieDBApi;
import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.Service.MovieDatabaseServiceGenerator;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import retrofit2.*;

public class MainActivity extends AppCompatActivity {

  MovieDBApi tvCallback = MovieDatabaseServiceGenerator.createService(MovieDBApi.class);

  private static final String TAG = "JSON?";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Call<Movie> movieCall =
        tvCallback.getMovieDiscover(getResources().getString(R.string.movie_db_api_key), "en-US",
            "popularity.desc", 1, Genres.ACTION.getId());

    movieCall.enqueue(new Callback<Movie>() {
      @Override public void onResponse(Call<Movie> call, Response<Movie> response) {
        Log.d(TAG, "onResponse:    #of Pages "
            + response.body().getTotal_pages()
            + " movies per page "
            + response.body().getResults().size());
      }

      @Override public void onFailure(Call<Movie> call, Throwable t) {

      }
    });

  }
/** Once we have another fragment or activity we can run this call otherwise retrofit is asynchronous so they will both initiate conflict and youll get a NULLPOINTEREXCEPTION
  private void getTvData() {
    Call<TV> tvCall =
        tvCallback.getTvDiscover(getResources().getString(R.string.movie_db_api_key), "en-US",
            "popularity.desc", 1, "America%2FNew_York", Genres.COMEDY.getId());

    tvCall.enqueue(new Callback<TV>() {
      @Override public void onResponse(Call<TV> call, Response<TV> response) {
        Log.d(TAG, "onResponse:    #of Pages "
            + response.body().getTotal_pages()
            + " movies per page "
        );

        Log.d(TAG, "onResponse" + response.body().getResults().get(2));
      }

      @Override public void onFailure(Call<TV> call, Throwable t) {

      }
    });
  }
 **/
}
