package com.vvc.partnersapp.presentation.home.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vvc.partnersapp.R;

public class EarningsFragment extends Fragment {

    public EarningsFragment() {
        // Required empty public constructor
    }

    public static EarningsFragment newInstance() {
        return new EarningsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earnings, container, false);
        initGui(view);
        return view;
    }

    private void initGui(View view) {

    }
}
