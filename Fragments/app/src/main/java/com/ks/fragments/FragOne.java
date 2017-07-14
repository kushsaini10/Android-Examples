package com.ks.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragOne extends android.app.Fragment {
    OnTextChangedListenerFragOne mListner;
    public interface OnTextChangedListenerFragOne {
        void TextChanged(String text);
    }


    public FragOne() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mListner = (OnTextChangedListenerFragOne) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnTextChangedListenerFragOne");
        }
    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity;
//
//        if (context instanceof Activity) {
//            activity = (Activity) context;
//
//            try {
//                mListner = (OnTextChangedListenerFragOne) activity;
//            } catch (ClassCastException e) {
//                throw new ClassCastException(activity.toString() + " must implement OnTextChangedListenerFragOne");
//            }
//        }
//    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_one, container, false);

        final String textActivity = getArguments().getString("text_from_activity");
        EditText et = view.findViewById(R.id.et_f1);

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
                if (text.length()!=0) {
                    if (text != textActivity) {
                        mListner.TextChanged(text);
                    }
                }
            }
        });
        return view;
    }

}
