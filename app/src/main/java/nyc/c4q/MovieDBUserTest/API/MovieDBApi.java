package nyc.c4q.MovieDBUserTest.API;

/**
 * Created by c4q on 1/8/18.
 */

import android.content.res.Resources;
import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBApi {
  @GET("3/discover/movie?") Call<Movie> getMovieDiscover(@Query("api_key") String key,
      @Query("language") String language, @Query("sort_by") String sort, @Query("page") int pageNum,
      @Query("with_genres") String genre);

  @GET("3/discover/tv?") Call<TV> getTvDiscover(@Query("api_key") String key,
      @Query("language") String language, @Query("sort_by") String sort, @Query("page") int pageNum,
      @Query("timezone") String timeZone, @Query("with_genres") String genre);
}