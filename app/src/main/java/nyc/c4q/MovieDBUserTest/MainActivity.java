package nyc.c4q.MovieDBUserTest;

import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import nyc.c4q.MovieDBUserTest.API.MovieDBApi;
import nyc.c4q.MovieDBUserTest.Models.Popular;
import nyc.c4q.MovieDBUserTest.Service.MovieDatabaseServiceGenerator;
import retrofit2.*;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "JSON?";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MovieDBApi movieDBApi = MovieDatabaseServiceGenerator.createService(MovieDBApi.class);
    retrofit2.Call<Popular> call = movieDBApi.getPopular();

    call.enqueue(new Callback<Popular>() {
      @Override public void onResponse(retrofit2.Call<Popular> call, Response<Popular> response) {
        Log.d(TAG, "onResponse: " + response.body().getResults().get(1).getOriginal_title());
      }

      @Override public void onFailure(retrofit2.Call<Popular> call, Throwable t) {
        Log.d(TAG, "onResponse: " + t.getMessage());
      }
    });
  }
}
