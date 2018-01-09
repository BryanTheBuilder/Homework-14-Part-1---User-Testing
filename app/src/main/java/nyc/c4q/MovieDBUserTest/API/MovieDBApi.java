package nyc.c4q.MovieDBUserTest.API;

/**
 * Created by c4q on 1/8/18.
 */

import nyc.c4q.MovieDBUserTest.Models.Popular;
import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDBApi {

  @GET("3/movie/popular?api_key=1c04b2b1399d2443d6f781d6c5fd6119&language=en-US&page=1")
  Call<Popular> getPopular();

}
