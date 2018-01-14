package com.tpourjalali.farmsafe;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class HomeActivity extends SingleFragmentActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected Fragment createFragment() {
        return HomeFragment.newInstance();
    }


}
