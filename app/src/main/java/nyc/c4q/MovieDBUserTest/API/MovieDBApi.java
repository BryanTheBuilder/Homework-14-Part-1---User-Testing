package nyc.c4q.MovieDBUserTest.API;

/**
 * Created by c4q on 1/8/18.
 */

import android.content.res.Resources;
import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBApi {

  @GET("3/discover/movie?api_key=1c04b2b1399d2443d6f781d6c5fd6119&language=en-US&sort_by=popularity.desc&page=1&with_genres=28")
  Call<Movie> getDiscover(@Query("api_key") String key, @Query("language") String language,
      @Query("sort_by") String sort, @Query("page") int pageNum,
      @Query("with_genres") String genre);

}