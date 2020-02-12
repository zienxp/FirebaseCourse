package com.example.firebasecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText userName,userPhone,userEmail;
    private Button buttonSave;
    private DatabaseReference reff;
    private Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.text_name);
        userPhone=findViewById(R.id.text_phone);
        userEmail =findViewById(R.id.text_email);
        buttonSave=findViewById(R.id.button_save_user);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                member.setName(userName.getText().toString().trim());
                member.setPhone(userPhone.getText().toString().trim());
                member.setEmail(userEmail.getText().toString().trim());
                reff.push().setValue(member);

                Toast.makeText(MainActivity.this, "Data Inset Successful", Toast.LENGTH_LONG).show();

            }
        });

    }
}
