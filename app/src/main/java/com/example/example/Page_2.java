package com.example.example;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Page_2 extends AppCompatActivity {
    String value;
    TextView text,Msg;

    FirebaseDatabase database;
    DatabaseReference myRef;
    String msg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);
        text=(TextView)findViewById(R.id.textView);
        Msg=(TextView)findViewById(R.id.txtMsg);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        text.setText("Welcome "+value);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference().child("Messages");
        myRef.setValue("Welcome to my Project").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(!task.isSuccessful())
                    Toast.makeText(getApplicationContext(),task.getException().getCause().toString(),Toast.LENGTH_LONG).show();
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                msg1=dataSnapshot.getValue().toString();
                Msg.setText(msg1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
