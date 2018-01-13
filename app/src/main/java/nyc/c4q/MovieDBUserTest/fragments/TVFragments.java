package nyc.c4q.MovieDBUserTest.fragments;

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


    public TVFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tv, container, false);
        sortBy = rootView.findViewById(R.id.spinner_sort_by);
        sortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        getTVDataSort("original_title.asc");
                        break;
                    case 1:
                        getTVDataSort("original_title.desc");
                        break;
                    case 2:
                        getTVDataSort("popularity.asc");
                        break;
                    case 3:
                        getTVDataSort("popularity.desc");
                        break;
                    case 4:
                        getTVDataSort("release_date.asc");
                        break;
                    case 5:
                        getTVDataSort("release_date.desc");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getTVData();
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
        Call<TV> tvCall = DBCallback.getTvDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", "popularity.desc", 1,
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
    private void getTVDataSort(String sort) {
        Call<TV> tvCall = DBCallback.getTvDiscover("1c04b2b1399d2443d6f781d6c5fd6119", "en-US", sort, 1,
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

}
