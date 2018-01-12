package nyc.c4q.MovieDBUserTest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.MovieDBUserTest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyMoviesFragment extends Fragment {

    View rootView;


    public MyMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        return rootView;
    }

}
