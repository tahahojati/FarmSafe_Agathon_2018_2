package com.tpourjalali.farmsafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

/**
 * Created by micah on 1/13/18.
 */

public class LanguageFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private LanguageAdapter mAdapter;

    public static LanguageFragment newInstance() {
        //Bundle args = new Bundle();
        LanguageFragment fragment = new LanguageFragment();
        //fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_language, container, false);

        List<LanguageRow> languageList = new ArrayList<>();
        languageList.add(new LanguageRow("English","en"));
        languageList.add(new LanguageRow("Español","es"));
        languageList.add(new LanguageRow("ไทย (Thai)","th"));
        languageList.add(new LanguageRow("中文 (Chinese)","zh"));
        languageList.add(new LanguageRow("Hawaiian","hi"));
        languageList.add(new LanguageRow("日本 (Japanese)","jp"));

        mRecyclerView = V.findViewById(R.id.language_recycler);
        mAdapter = new LanguageAdapter(languageList, new LanguageAdapter.OnItemClickListener() );
        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

        return V;
    }
}
