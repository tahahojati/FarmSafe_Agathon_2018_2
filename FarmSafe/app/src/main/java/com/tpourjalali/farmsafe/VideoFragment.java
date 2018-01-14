package com.tpourjalali.farmsafe;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

/**
 * Created by micah on 1/14/18.
 */

public class VideoFragment extends Fragment {
    public static VideoFragment newInstance() {
        //Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        //fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_video, container, false);

        VideoView vid = V.findViewById(R.id.videoView);
        String vidPath = "android.resource://com.tpourjalali.farmsafe"+R.raw.gap_chinese;
        Uri uri = Uri.parse(vidPath);
        vid.setVideoURI(uri);
        vid.start();

        return V;
    }
}
