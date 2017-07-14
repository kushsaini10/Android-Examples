package com.ks.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ks.fragments.R;

public class FragTwo extends android.app.Fragment {
    OnTextChangedListenerFragTwo mListner;
    public interface OnTextChangedListenerFragTwo {
        void TextChanged(String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mListner = (OnTextChangedListenerFragTwo) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnTextChangedListenerFragTwo");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_two, container, false);
        final String textActivity = getArguments().getString("text_from_activity");
        EditText et = view.findViewById(R.id.et_f2);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
                if (text.length() != 0) {
                    if (text != textActivity) {
                        mListner.TextChanged(text);
                    }
                }
            }
        });
        return view;
    }
}
