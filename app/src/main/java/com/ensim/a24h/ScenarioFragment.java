package com.ensim.a24h;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ensim.a24h.Model.Scenario;

public class ScenarioFragment extends Fragment {

    ListView mListView;
    Scenario listScenario;
    private Button creer;


    public ScenarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_scenario_fragment, container, false);
        creer = mListView.findViewById(R.id.creation);
        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScenarioFragment.this.getActivity(), ScenarioChoicePatternActivity.class));
            }
        });
        Scenario scenario = new Scenario();
        mListView = (ListView) view.findViewById(R.id.listview);

        return view;
    }
}
