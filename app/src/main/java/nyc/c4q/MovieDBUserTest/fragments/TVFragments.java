package nyc.c4q.MovieDBUserTest.fragments;

import android.content.res.Configuration;
import android.location.GnssClock;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.MovieDBUserTest.Models.TV;
import nyc.c4q.MovieDBUserTest.Models.TvResults;
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
    private Spinner sortBy;
    private Spinner genre;
    private List<TvResults> tvResults = new ArrayList<>();
    private String sortSelection = null;
    private String genreSelection = null;

    public TVFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tv, container, false);
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
                getTVDataSortGenre(sortSelection, genreSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getTVDataSortGenre(sortSelection,genreSelection);
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
                getTVDataSortGenre(sortSelection, genreSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getTVDataSortGenre(sortSelection,genreSelection);
            }
        });
        ArrayAdapter<CharSequence> sortByAdapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.spinner_sort_by, android.R.layout.simple_spinner_item);
        sortByAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBy.setAdapter(sortByAdapter);

        getTVData();
        return rootView;
    }

    public void getTVData() {
        Call<TV> tvCall = DBCallback.getTvDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", "original_title.asc", 1,
                null, null);
        tvCall.enqueue(new Callback<TV>() {
            @Override
            public void onResponse(Call<TV> call, Response<TV> response) {
                TV tv = response.body();
                List<TvResults> tvList = tv.getResults();
                tvRecycler = rootView.findViewById(R.id.tv_recyclerview);
                tvAdapter = new TVAdapter(getContext(), tvList);
                gridLayoutManager = new GridLayoutManager(getContext(), 2);
                tvRecycler.setAdapter(tvAdapter);
                tvRecycler.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void onFailure(Call<TV> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void getTVDataSortGenre(String sort, String genre) {
        Call<TV> tvCall = DBCallback.getTvDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sort, 1,
                null, genre);
        tvCall.enqueue(new Callback<TV>() {
            @Override
            public void onResponse(Call<TV> call, Response<TV> response) {
                TV tv = response.body();
                List<TvResults> tvList = tv.getResults();
                tvRecycler = rootView.findViewById(R.id.tv_recyclerview);
                tvAdapter = new TVAdapter(getContext(), tvList);
                gridLayoutManager = new GridLayoutManager(getContext(), 2);
                tvRecycler.setAdapter(tvAdapter);

                if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    tvRecycler.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
                } else {
                    tvRecycler.setLayoutManager(new GridLayoutManager(rootView.getContext(), 4));
                }
            }

            @Override
            public void onFailure(Call<TV> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
