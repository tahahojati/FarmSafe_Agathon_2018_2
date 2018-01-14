package com.tpourjalali.farmsafe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by micah on 1/13/18.
 */

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {
    private List<LanguageRow> languageList;

    public LanguageAdapter(List<LanguageRow> languageList) {
        this.languageList = languageList;
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder {
        public TextView lang;

        public LanguageViewHolder(View view) {
            super(view);
            lang = (TextView) view.findViewById(R.id.lang);

        }
    }

    @Override
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.language_row, parent, false);
        return new LanguageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LanguageViewHolder holder, int position) {
        LanguageRow row = languageList.get(position);
        holder.lang.setText(row.getRowString());

    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }
}
