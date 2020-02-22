package com.example.firebasecourse;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button buttonAddUser,buttonReadUser;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        buttonAddUser = view.findViewById(R.id.button_add_user);
        buttonAddUser.setOnClickListener(this);
        buttonReadUser = view.findViewById(R.id.button_view_users);
        buttonReadUser.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_add_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddFragment()).addToBackStack(null).commit();
                break;

            case R.id.button_view_users:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadFragment()).addToBackStack(null).commit();
        }
    }
}
