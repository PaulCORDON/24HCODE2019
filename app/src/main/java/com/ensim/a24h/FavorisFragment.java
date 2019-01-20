package com.ensim.a24h;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FavorisFragment extends Fragment {

    public FavorisFragment() {
        // Required empty public constructor
        Log.d("Entrée", "entrée");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_favoris_fragment, container, false);
    }
}
