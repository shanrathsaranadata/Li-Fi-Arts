package com.example.li_fiarts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.li_fiarts.Module.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText ticketid,ticketpw;
    private Button  loginbtn;
    private ProgressDialog lodingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ticketid = findViewById(R.id.ticked_id);
        ticketpw = findViewById(R.id.password_id);
        loginbtn = findViewById(R.id.login_btn);
        lodingbar = new ProgressDialog(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });



    }

    private void loginuser() {
        String ticketids = ticketid.getText().toString();
        String ticketpws = ticketpw.getText().toString();

        if(TextUtils.isEmpty(ticketids)){
            Toast.makeText(this, "Please Write your ticket id", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(ticketpws)){
            Toast.makeText(this, "Please Write your ticket id password", Toast.LENGTH_SHORT).show();
        }
        else{
            lodingbar.setTitle("Login Art Shop");
            lodingbar.setMessage("please wait,while we are checking");
            lodingbar.setCanceledOnTouchOutside(false);
            lodingbar.show();

            AllowAcess(ticketids,ticketpws);

        }
    }
    private void AllowAcess(final String tid, final String tpw) {

        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();

        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("Users").child(tid).exists()) {

                    Users usersdata = dataSnapshot.child("Users").child(tid).getValue(Users.class);

                    if (usersdata.getId().equals(tid)) {
                        if (usersdata.getPassword().equals(tpw)) {
                            Toast.makeText(LoginActivity.this, "Logged in Successfull", Toast.LENGTH_SHORT).show();
                            lodingbar.dismiss();

                            Intent intent = new Intent(LoginActivity.this, ArtActivity.class);
                            startActivity(intent);

                        } else {
                            lodingbar.dismiss();
                            Toast.makeText(LoginActivity.this, "Incorrect Password....", Toast.LENGTH_SHORT).show();
                        }

                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Account with this " + tid + " not exisits", Toast.LENGTH_SHORT).show();
                    lodingbar.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LoginActivity.this, "net error", Toast.LENGTH_SHORT).show();
                lodingbar.dismiss();

            }
        });
    }
}