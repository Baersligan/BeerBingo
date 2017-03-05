package com.example.lando.beerbingo;

import android.media.audiofx.AudioEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
    String title;
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
                getContent();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void getContent(){

        description = challengeMap.get("Description").toString();
        title = challengeMap.get("Title").toString();
        beer = challengeMap.get("Beer").toString();
        bar = challengeMap.get("Bar").toString();
        fillContent();

    }

    public void fillContent(){
        final TextView descView = new TextView(this);
        descView.setText(description);
        descView.setPadding(20,20,20,0);

        final TextView titleView = new TextView(this);
        titleView.setText("Title: " + title);
        titleView.setTextSize(20);
        titleView.setPadding(20,20,20,40);
        ImageView imgView = (ImageView)findViewById(R.id.imageView1);

        Picasso.with(this).load(challengeMap.get("imgURL").toString()).into(imgView);

        LinearLayout l = (LinearLayout) findViewById(R.id.activityChallengeContainer);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        l.addView(titleView, lp);
        l.addView(descView, lp);

    }

    public void uploadImage(View view){
        Toast.makeText(ChallengeActivity.this, "pressed upload", Toast.LENGTH_SHORT).show();
    }
}
