package com.tpourjalali.farmsafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class FramentHome extends Fragment{
    public static FramentHome newInstance() {
        //Bundle args = new Bundle();
        FramentHome fragment = new FramentHome();
        //fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_main, container, false);

        return V;
    }
}
