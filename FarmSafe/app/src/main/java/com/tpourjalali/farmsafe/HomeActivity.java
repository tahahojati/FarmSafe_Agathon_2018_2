package com.tpourjalali.farmsafe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return FramentHome.newInstance();
    }
}
