package com.tpourjalali.farmsafe;

import android.support.v4.app.Fragment;
/**
 * Created by micah on 1/13/18.
 */

public class LanguageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return LanguageFragment.newInstance();
    }
}
