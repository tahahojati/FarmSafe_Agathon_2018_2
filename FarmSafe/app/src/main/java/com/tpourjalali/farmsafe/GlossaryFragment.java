package com.tpourjalali.farmsafe;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class GlossaryFragment extends Fragment {
    private static String TAG = "GlossaryFragment";
    RecyclerView mRecyclerView;
    public static GlossaryFragment newInstance() {
        GlossaryFragment fragment = new GlossaryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V  = inflater.inflate(R.layout.fragment_glossary, container, false);
        mRecyclerView = V.findViewById(R.id.glossary_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new GlossaryTermAdapter(Language.English));

        return V;
    }
    private class GlossaryTermHolder extends RecyclerView.ViewHolder{
        private Term mTerm;
        private TextView mTermTextView;
        private ImageView mThumbNailImageView;
        public GlossaryTermHolder(View itemView) {
            super(itemView);
            mThumbNailImageView = itemView.findViewById(R.id.thumbnail_image);
            mTermTextView = itemView.findViewById(R.id.term);
        }
        public void bindTerm(Term term){
            mTerm = term;
            mTermTextView.setText(mTerm.getTerm());
            int imageId = mTerm.getImageResourceId();
            Drawable image = null ;
            try {
                if (imageId > 0)
                    image = getResources().getDrawable(imageId);
            } catch (Resources.NotFoundException e){
                Log.e(TAG, "image resource id was positive but image was not found "
                        + mTerm.getImageResourceId(), e);
                image = null;
            }
            mThumbNailImageView.setImageDrawable(image);
        }
    }

    private class GlossaryTermAdapter extends RecyclerView.Adapter<GlossaryTermHolder> {
        private ArrayList<Term> mTerms;
        public GlossaryTermAdapter(Language language){
            mTerms = new ArrayList<>();
            mTerms.add(new Term(1, Language.English, "Life", "Life is complicated", 1));
            mTerms.add(new Term(2, Language.English, "life2", "Life is complicated", 1));
            mTerms.add(new Term(3, Language.English, "Lifffe", "Life is complicated", 1));
        }
        @Override
        public GlossaryTermHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            View V = li.inflate(R.layout.term_row_item_view, parent, false);
            return  new GlossaryTermHolder(V);
        }

        @Override
        public void onBindViewHolder(GlossaryTermHolder holder, int position) {
            holder.bindTerm(mTerms.get(position));
        }

        @Override
        public int getItemCount() {
            return mTerms.size();
        }
    }
}
