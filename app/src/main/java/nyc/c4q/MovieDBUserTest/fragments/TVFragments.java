package nyc.c4q.MovieDBUserTest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import nyc.c4q.MovieDBUserTest.controller.TVAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

public class TVFragments extends Fragment {

  private static final String TAG = "JSON?";
  private View rootView;
  private RecyclerView tvRecycler;
  private GridLayoutManager gridLayoutManager;
  private TVAdapter tvAdapter;

  public TVFragments() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_tv, container, false);

    Call<TV> tvCall =
        DBCallback.getTvDiscover(getResources().getString(R.string.movie_db_api_key), "en-US",
            "popularity.desc", 1, "America%2FNew_York", Genres.COMEDY.getId());

    tvCall.enqueue(new Callback<TV>() {
      @Override public void onResponse(Call<TV> call, Response<TV> response) {
        Log.d(TAG,
            "onResponse:    #of Pages " + response.body().getTotal_pages() + " movies per page ");

        //tvRecycler = rootView.findViewById(R.id.tv_recyclerview);
        //tvAdapter = new TVAdapter(getContext());
        //linearLayoutManager =
        //    new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //
        //tvRecycler.setAdapter(tvAdapter);
        //tvRecycler.setLayoutManager(linearLayoutManager);

      }

      @Override public void onFailure(Call<TV> call, Throwable t) {

      }
    });

    return rootView;
  }



}
