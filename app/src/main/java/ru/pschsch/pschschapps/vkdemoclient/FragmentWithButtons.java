package ru.pschsch.pschschapps.vkdemoclient;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentWithButtons extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState) {
        super.onCreateView(inflater, vg, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragmentbuttons, vg);
        Button mAuthBtn = rootView.findViewById(R.id.button2);
        Button mFriendsListBtn = rootView.findViewById(R.id.button);
        mAuthBtn.setOnClickListener(listener);
        mFriendsListBtn.setOnClickListener(listener);
        return rootView;
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Toast.makeText(getContext(), "Нажато", Toast.LENGTH_SHORT).show();
                case R.id.button2:
                    Toast.makeText(getContext(), "Нажато2", Toast.LENGTH_SHORT).show();
            }
        }
    };
}

