package com.example.li_fiarts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ArtActivity extends AppCompatActivity {

//    private Physicaloid mPhysicaloid;
    private Button mapbtn,scanmebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        scanmebtn = findViewById(R.id.scanme_btn);
        mapbtn = findViewById(R.id.map_btn);
//        mPhysicaloid = new Physicaloid(this);

        scanmebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanmearts();
            }
        });

        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArtActivity.this,MainActivity.class));
            }
        });
    }

    private void scanmearts() {

//        mPhysicaloid.setBaudrate(9600);
//
//        if(mPhysicaloid.open()) {
//            mPhysicaloid.addReadListener(new ReadLisener() {
//                @Override
//                public void onRead(int size) {
//                    byte[] buf = new byte[size];
//                    mPhysicaloid.read(buf, size);
////                    tvAppend(tvRead, Html.fromHtml("<font color=blue>" + new String(buf) + "</font>"));
//
//                }
//            });
//        }
//        else {
//            Toast.makeText(this, "Cannot open", Toast.LENGTH_LONG).show();
//        }
    }
}