package com.tpourjalali.farmsafe;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class HomeFragment extends Fragment{
    private ImageButton mGlossaryButton;
    private ImageButton mCoursesButton;
    public static HomeFragment newInstance() {
        //Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        //fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(V);


        return V;
    }

    private void initViews(View V) {
        mGlossaryButton = V.findViewById(R.id.glossary_button);
        mCoursesButton = V.findViewById(R.id.courses_button);
        mGlossaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), GlossaryActivity.class);
                startActivity(i);
            }
        });
        mCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CoursesActivity.class);
                startActivity(i);
            }
        });
    }
}
