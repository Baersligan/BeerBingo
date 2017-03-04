package com.example.lando.beerbingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class ChallengeActivity extends AppCompatActivity {

    FirebaseDatabase firebase = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        final TextView tv = new TextView(this);
        String s = getIntent().getExtras().getString("key");

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snap) {
                Toast.makeText(ChallengeActivity.this, snap.child("users/katja").getValue().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        LinearLayout l = (LinearLayout) findViewById(R.id.activityChallengeContainer);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        l.addView(tv, lp);
    }
}
