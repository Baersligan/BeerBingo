package com.example.lando.beerbingo;

import android.media.audiofx.AudioEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ChallengeActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    String description;
    String beer;
    String bar;
    String imgURL;
    String location;
    HashMap challengeMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);


        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snap) {
                String s = "challenges/" + getIntent().getExtras().getString("key");
                challengeMap = (HashMap) snap.child(s).getValue();
                fillContent();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void fillContent(){
        final TextView descView = new TextView(this);
        descView.setText(challengeMap.get("Description").toString());
        final TextView barView = new TextView(this);
        barView.setText(challengeMap.get("Bar").toString());
        final TextView beerView = new TextView(this);
        beerView.setText(challengeMap.get("Beer").toString());
        ImageView imgView = (ImageView)findViewById(R.id.imageView1);

        Picasso.with(this).load(challengeMap.get("imgURL").toString()).into(imgView);

        LinearLayout l = (LinearLayout) findViewById(R.id.activityChallengeContainer);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        l.addView(descView, lp);
        l.addView(barView, lp);
        l.addView(beerView, lp);
    }
}
