package ru.pschsch.pschschapps.vkdemoclient;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentWithRecycler extends Fragment {
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState){
        super.onCreateView(inflater, vg, savedInstanceState);
        return inflater.inflate(R.layout.fragmentrecycler, null);

    }
}
