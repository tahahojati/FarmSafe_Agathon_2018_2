package com.tpourjalali.farmsafe;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoursesActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CoursesFragment.newInstance();
    }
}
