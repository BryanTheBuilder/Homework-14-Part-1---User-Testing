package nyc.c4q.MovieDBUserTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import nyc.c4q.MovieDBUserTest.API.MovieDBApi;
import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Service.MovieDatabaseServiceGenerator;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import retrofit2.*;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "JSON?";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //
    //MovieDBApi movieDBApi = MovieDatabaseServiceGenerator.createService(MovieDBApi.class);
    //retrofit2.Call<Popular> call =
    //    movieDBApi.getPopular(getResources().getString(R.string.movie_db_api_key), "en-US", 1);
    ////
    //call.enqueue(new Callback<Popular>() {
    //  @Override public void onResponse(retrofit2.Call<Popular> call, Response<Popular> response) {
    //
    //  }
    //
    //  @Override public void onFailure(retrofit2.Call<Popular> call, Throwable t) {
    //    Log.d(TAG, "onResponse: " + t.getMessage());
    //  }
    //});

    MovieDBApi moviecallback = MovieDatabaseServiceGenerator.createService(MovieDBApi.class);
    Call<Movie> movieCall =
        moviecallback.getDiscover(getResources().getString(R.string.movie_db_api_key), "en-US",
            "popularity.desc", 1, "28");
    //Sort Movies Shows different Lists
    //options = popularity.desc
    //release_date.desc
    //vote_average.desc  == user Ratings
    //getting genre lists add String genre number





    movieCall.enqueue(new Callback<Movie>() {
      @Override public void onResponse(Call<Movie> call, Response<Movie> response) {

      }

      @Override public void onFailure(Call<Movie> call, Throwable t) {

      }
    });
  }
}
