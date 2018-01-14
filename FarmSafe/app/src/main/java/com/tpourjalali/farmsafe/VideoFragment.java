package com.tpourjalali.farmsafe;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by micah on 1/14/18.
 */

public class VideoFragment extends Fragment {
    private static final String TAG = "VideoFragment";
    private static final String VIDEO_FOLDER = "videos";
    private static final String ARG_VIDEO_ID = "arg_video_id";
    private VideoView mVideoView;
    private AssetManager mAssetManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAssetManager = getActivity().getAssets();
    }

    public static VideoFragment newInstance(int videoResourceId) {
        Bundle args = new Bundle();
        args.putInt(ARG_VIDEO_ID, videoResourceId);
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_video, container, false);

        mVideoView = V.findViewById(R.id.videoView);
        MediaController mc = new MediaController(getActivity());
        mc.setAnchorView(mVideoView);
        mc.setMediaPlayer(mVideoView);

        mVideoView.setVideoPath("assets/"+VIDEO_FOLDER+"/gap_chinese.mp4");
        mVideoView.start();

        return V;
    }
}
