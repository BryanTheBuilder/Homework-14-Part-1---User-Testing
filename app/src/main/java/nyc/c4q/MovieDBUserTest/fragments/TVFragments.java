package nyc.c4q.MovieDBUserTest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.MovieDBUserTest.R;
import nyc.c4q.MovieDBUserTest.controller.TVAdapter;

public class TVFragments extends Fragment {
    private View rootView;
    private RecyclerView tvRecycler;
    private LinearLayoutManager linearLayoutManager;
    private TVAdapter tvAdapter;

    public TVFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tv, container, false);
        tvRecycler = rootView.findViewById(R.id.tv_recyclerview);
        tvAdapter = new TVAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        tvRecycler.setAdapter(tvAdapter);
        tvRecycler.setLayoutManager(linearLayoutManager);
        return rootView;
    }

}
