package com.example.li_fiarts;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.li_fiarts.Module.Room;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Room room;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artsInfoDisplay();


    }
    private void artsInfoDisplay() {

        DatabaseReference arts = FirebaseDatabase.getInstance().getReference().child("Arts");

        arts.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){


                    if(dataSnapshot.child("Rooms").exists()){

                        int roomcol=Integer.parseInt(Objects.requireNonNull(dataSnapshot.child("Rooms").child("columns").getValue()).toString());
                        int roomrow = Integer.parseInt(Objects.requireNonNull(dataSnapshot.child("Rooms").child("rows").getValue()).toString());

                        if(dataSnapshot.child("Current").exists()){

                            int currentid = Integer.parseInt(Objects.requireNonNull(dataSnapshot.child("Current").child("id").getValue()).toString());


                            String[] arts ={"arts01","arts02","arts03"};
                            ArrayList<Integer> IDs = new ArrayList<>();
                            ArrayList<Integer> rows = new ArrayList<>();
                            ArrayList<Integer> columns = new ArrayList<>();
                            ArrayList<String> labels = new ArrayList<>();


                            for(int i=0; i<arts.length;i++) {

                                if (dataSnapshot.child(arts[i]).exists()) {

                                    columns.add(Integer.parseInt(Objects.requireNonNull(dataSnapshot.child(arts[i]).child("columns").getValue()).toString()));
                                    rows.add(Integer.parseInt(Objects.requireNonNull(dataSnapshot.child(arts[i]).child("rows").getValue()).toString()));
                                    IDs.add(Integer.parseInt(Objects.requireNonNull(dataSnapshot.child(arts[i]).child("id").getValue()).toString()));
                                    labels.add(dataSnapshot.child(arts[i]).child("lables").getValue().toString());

                                }

                            }
                                setup(roomrow,roomcol,IDs,rows,columns,labels);
                                set_active_art(currentid);


                        }

                    }

                }




            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MainActivity.this, "database error", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setup(int max_row, int max_col,
                      ArrayList<Integer> IDs, ArrayList<Integer> rows,
                      ArrayList<Integer> columns,ArrayList<String> labels){

        ConstraintLayout cl = new ConstraintLayout(this);
        cl.setId(View.generateViewId());

        room = new Room(max_row,max_col,cl,this,this);

        for (int i=0; i<IDs.size(); i++){
            room.addPicture(IDs.get(i),rows.get(i), columns.get(i),labels.get(i));
        }

        setContentView(cl);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void set_active_art(int id){
        room.setActivatedPicture(id);

    }

}