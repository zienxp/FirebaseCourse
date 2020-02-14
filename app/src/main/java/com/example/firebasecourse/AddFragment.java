package com.example.firebasecourse;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    private EditText userName,userPhone,userEmail;
    private Button buttonSave;
    private Member member;
    private DatabaseReference reff;
    private long maxId =0;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        userName = view.findViewById(R.id.text_name);
        userPhone= view.findViewById(R.id.text_phone);
        userEmail = view.findViewById(R.id.text_email);
        buttonSave = view.findViewById(R.id.button_save_user);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxId = (dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                member.setName(userName.getText().toString().trim());
                member.setPhone(userPhone.getText().toString().trim());
                member.setEmail(userEmail.getText().toString().trim());
                reff.child(String.valueOf(maxId +1)).setValue(member);

                Toast.makeText(getActivity(), "Data Inset Successful", Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

}
