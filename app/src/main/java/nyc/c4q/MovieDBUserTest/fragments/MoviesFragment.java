package nyc.c4q.MovieDBUserTest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.MovieDBUserTest.API.MovieDBApi;
import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.constants.Genres;
import nyc.c4q.MovieDBUserTest.controller.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private View rootView;
    private RecyclerView movieRecycler;
    private LinearLayoutManager linearLayoutManager;
    private MovieAdapter movieAdapter;
    private Retrofit retrofit;
    private static final String API_KEY = "";
    private boolean loadMovieData;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        getMovieData();

        return rootView;
    }

    public void getMovieData() {

        Call<Movie> movieCall = DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119","en-US","popularity.desc",5,
            null);
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    List<MovieResults> resultsList = movie.getResults();
                    Log.d("MOVIE", "onResponse: " + resultsList.size());

                    movieRecycler = rootView.findViewById(R.id.movie_rv);
                    movieAdapter = new MovieAdapter(getContext() , resultsList);
                    linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                    movieRecycler.setAdapter(movieAdapter);
                    movieRecycler.setLayoutManager(linearLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                loadMovieData = true;
                Log.d("MOVIE", "onFailure: " + call.request());
                t.printStackTrace();
            }
        });
    }

}
