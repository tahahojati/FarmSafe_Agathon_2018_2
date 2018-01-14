package com.tpourjalali.farmsafe;

import android.support.v4.app.Fragment;

/**
 * Created by micah on 1/14/18.
 */

public class VideoActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return VideoFragment.newInstance(0);
    }

}
