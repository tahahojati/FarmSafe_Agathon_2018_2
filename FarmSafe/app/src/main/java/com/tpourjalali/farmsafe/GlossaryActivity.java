package com.tpourjalali.farmsafe;

import android.support.v4.app.Fragment;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class GlossaryActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return GlossaryFragment.newInstance();
    }
}
