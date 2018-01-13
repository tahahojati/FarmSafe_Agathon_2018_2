package com.tpourjalali.farmsafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ProfessorTaha on 12/26/2017.
 */

abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.fragment) == null) {
            fm.beginTransaction().add(R.id.fragment, createFragment())
                    .commit();
        }

    }

    abstract protected Fragment createFragment();

}
