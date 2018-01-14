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
    private OnItemClickListener listener;

    public LanguageAdapter(List<LanguageRow> languageList, OnItemClickListener listener) {
        this.listener = listener;
        this.languageList = languageList;

    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder {
        public TextView lang;

        public LanguageViewHolder(View view) {
            super(view);
            lang = (TextView) view.findViewById(R.id.lang);

        }

        public void bind(final LanguageRow row, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(row);
                }
            });
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
        holder.bind(row, listener);

    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }
}
