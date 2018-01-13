package nyc.c4q.MovieDBUserTest.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.Movie;
import nyc.c4q.MovieDBUserTest.Models.MovieResults;
import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.controller.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.MovieDBUserTest.MainActivity.DBCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private View rootView;
    private RecyclerView movieRecycler;
    private GridLayoutManager gridLayoutManager;
    private MovieAdapter movieAdapter;
    private Spinner sortBy;

    private static final String API_KEY = "";

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        sortBy = rootView.findViewById(R.id.spinner_sort_by);
        sortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        getMovieDataSort("original_title.asc");
                        break;
                    case 1:
                        getMovieDataSort("original_title.desc");
                        break;
                    case 2:
                        getMovieDataSort("popularity.asc");
                        break;
                    case 3:
                        getMovieDataSort("popularity.desc");
                        break;
                    case 4:
                        getMovieDataSort("release_date.asc");
                        break;
                    case 5:
                        getMovieDataSort("release_date.desc");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    getMovieData();
            }
        });
        ArrayAdapter<CharSequence> sortByAdapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.spinner_sort_by, android.R.layout.simple_spinner_item);
        sortByAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBy.setAdapter(sortByAdapter);

        getMovieData();
        return rootView;
    }

    public void getMovieData() {

        Call<Movie> movieCall =
                DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", "original_title.asc",
                        1, null);
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    List<MovieResults> resultsList = movie.getResults();
                    Log.d("MOVIE", "onResponse: " + resultsList.size());

                    movieRecycler = rootView.findViewById(R.id.movie_rv);
                    movieAdapter = new MovieAdapter(getContext(), resultsList);
                    gridLayoutManager =
                            new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                    movieRecycler.setAdapter(movieAdapter);
                    movieRecycler.setLayoutManager(gridLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d("MOVIE", "onFailure: " + call.request());
                t.printStackTrace();
            }
        });
    }

    public void getMovieDataSort(String sortBy) {

        Call<Movie> movieCall =
                DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sortBy,
                        1, null);
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    List<MovieResults> resultsList = movie.getResults();
                    Log.d("MOVIE", "onResponse: " + resultsList.size());

                    movieRecycler = rootView.findViewById(R.id.movie_rv);
                    movieAdapter = new MovieAdapter(getContext(), resultsList);
                    gridLayoutManager =
                            new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                    movieRecycler.setAdapter(movieAdapter);
                    movieRecycler.setLayoutManager(gridLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d("MOVIE", "onFailure: " + call.request());
                t.printStackTrace();
            }
        });
    }
}
