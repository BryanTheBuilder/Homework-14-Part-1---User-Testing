package nyc.c4q.MovieDBUserTest.fragments;

import android.content.res.Configuration;
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
import nyc.c4q.MovieDBUserTest.constants.Genres;
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
    private Spinner genre;
    private String sortSelection = null;
    private String genreSelection = null;


    private static final String API_KEY = "";

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        sortBy = rootView.findViewById(R.id.spinner_sort_by);
        genre = rootView.findViewById(R.id.spinner_filter_genre);
        genre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        genreSelection = Genres.ACTION.getId();
                        break;
                    case 1:
                        genreSelection = Genres.ADVENTURE.getId();
                        break;
                    case 2:
                        genreSelection = Genres.COMEDY.getId();
                        break;
                    case 3:
                        genreSelection = Genres.CRIME.getId();
                        break;
                    case 4:
                        genreSelection = Genres.DOCUMENTARY.getId();
                        break;
                    case 5:
                        genreSelection = Genres.DRAMA.getId();
                        break;
                    case 6:
                        genreSelection = Genres.FAMILY.getId();
                        break;
                    case 7:
                        genreSelection = Genres.FANTASY.getId();
                        break;
                    case 8:
                        genreSelection = Genres.HISTORY.getId();
                        break;
                    case 9:
                        genreSelection = Genres.HORROR.getId();
                        break;
                    case 10:
                        genreSelection = Genres.MUSIC.getId();
                        break;
                    case 11:
                        genreSelection = Genres.MYSTERY.getId();
                        break;
                    case 12:
                        genreSelection = Genres.ROMANCE.getId();
                        break;
                    case 13:
                        genreSelection = Genres.SCIENCE_FICTION.getId();
                        break;
                    case 14:
                        genreSelection = Genres.TV_MOVIE.getId();
                        break;
                    case 15:
                        genreSelection = Genres.THRILLER.getId();
                        break;
                    case 16:
                        genreSelection = Genres.WAR.getId();
                        break;
                    case 17:
                        genreSelection = Genres.WESTERN.getId();
                        break;
                }
                getMovieDataSortGenre(sortSelection, genreSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getMovieDataSortGenre(sortSelection, genreSelection);

            }
        });

        sortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        sortSelection = "original_title.asc";
                        break;
                    case 1:
                        sortSelection = "original_title.desc";
                        break;
                    case 2:
                        sortSelection = "popularity.asc";
                        break;
                    case 3:
                        sortSelection = "popularity.desc";
                        break;
                    case 4:
                        sortSelection = "release_date.asc";
                        break;
                    case 5:
                        sortSelection = "release_date.desc";
                        break;
                }
                getMovieDataSortGenre(sortSelection, genreSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getMovieDataSortGenre(sortSelection, genreSelection);
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
                DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", "original_title.asc", false,
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

    public void getMovieDataSortGenre(String sortBy, String genre) {

        Call<Movie> movieCall =
                DBCallback.getMovieDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sortBy, false,
                        1, genre);
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

                    if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        movieRecycler.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
                    } else {
                        movieRecycler.setLayoutManager(new GridLayoutManager(rootView.getContext(), 4));
                    }
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
