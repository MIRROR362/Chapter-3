package com.example.chapter3.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecFragment extends Fragment {
    private TextView text_1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = View.inflate(getActivity(), R.layout.fragment_sec, null);
        text_1 = view.findViewById(R.id.text_view2);
       // text_1.append("爬");

        return view;
    }
}
