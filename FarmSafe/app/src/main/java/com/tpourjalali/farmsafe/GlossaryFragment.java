package com.tpourjalali.farmsafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class GlossaryFragment extends Fragment {
    RecyclerView mRecyclerView;
    public static GlossaryFragment newInstance() {
        GlossaryFragment fragment = new GlossaryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V  = inflater.inflate(R.layout.fragment_glossary, container, false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new LibraryTopicAdapter());

        return V;
    }
    private static class LibraryTopicHolder extends RecyclerView.ViewHolder{
        public LibraryTopicHolder(View itemView) {
            super(itemView);
        }
    }

    private class LibraryTopicAdapter extends RecyclerView.Adapter {
        private ArrayList<Term>

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
