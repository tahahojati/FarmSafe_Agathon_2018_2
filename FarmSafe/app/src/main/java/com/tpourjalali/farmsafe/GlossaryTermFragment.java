package com.tpourjalali.farmsafe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ProfessorTaha on 1/13/2018.
 */

public class GlossaryTermFragment extends DialogFragment {
    private static final String TERM_ID_INT = "term_id";
    private TextView mTermTextView, mDefinitionTextView;
    private ImageView mTermImageView;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View myView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_single_glossary_term, null);
        mTermTextView = myView.findViewById(R.id.term_textview);
        mDefinitionTextView = myView.findViewById(R.id.definition_textview);
        mTermImageView = myView.findViewById(R.id.term_imageview);

        return new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setView(myView)
                .setTitle(R.string.glossary_term_title)
                .create();
    }

    public static GlossaryTermFragment newInstance(int termId) {
        Bundle args = new Bundle();
        args.putInt(TERM_ID_INT, termId);
        GlossaryTermFragment g = new GlossaryTermFragment();
        g.setArguments(args);
        return g;
    }
}
