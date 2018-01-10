package nyc.c4q.MovieDBUserTest.API;

/**
 * Created by c4q on 1/8/18.
 */

import android.content.res.Resources;
import nyc.c4q.MovieDBUserTest.Models.Popular;
import nyc.c4q.MovieDBUserTest.R;
import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBApi {

  @GET("3/movie/popular?") Call<Popular> getPopular(@Query("api_key") String key,
      @Query("language") String language, @Query("page") int num);
}
