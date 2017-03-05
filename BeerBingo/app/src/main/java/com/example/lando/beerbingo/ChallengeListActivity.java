package com.example.lando.beerbingo;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;

import uk.co.barbuzz.beerprogressview.BeerProgressView;

public class ChallengeListActivity extends AppCompatActivity {

    private Button[] buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);
        setBackground();
        Challenge challenge = new Challenge();

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();
        myRef.child("challenges").setValue(challenge.challengeMap);
        addListenerToProfileButton();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snap) {
                buttonList = new Button[(int)snap.child("challenges").getChildrenCount()];
                int i = 0;
                for(final DataSnapshot tmpSnap: snap.child("challenges").getChildren()){
                    buttonList[i] = new Button(ChallengeListActivity.this);
                   // buttonList[i].setBackgroundColor(getResources().getColor(R.color.buttonColor));
                    buttonList[i].setText(tmpSnap.child("Title").getValue().toString());
                    buttonList[i].setTag(tmpSnap.getKey());

                    buttonList[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v){
                            Intent intent = new Intent(ChallengeListActivity.this, ChallengeActivity.class);
                            intent.putExtra("key", tmpSnap.getKey());
                            ChallengeListActivity.this.startActivity(intent);
                        }
                    });

                    LinearLayout l = (LinearLayout) findViewById(R.id.challengeListContainer);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    l.addView(buttonList[i], lp);


                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //Toast.makeText(ChallengeListActivity.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT);

        //for(DataSnapshot snap : snapshot.child("challenges").getChildren()){
          //  Toast.makeText(ChallengeListActivity.this, snap.getValue().toString(), Toast.LENGTH_SHORT);
      //  }




    }

    public void addListenerToProfileButton(){
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton1);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(ChallengeListActivity.this, ProfileActivity.class);
                ChallengeListActivity.this.startActivity(intent);
                //Toast.makeText(ChallengeListActivity.this, "profile clicked", Toast.LENGTH_SHORT).show();
            }

        });

    }
    public void setBackground(){
        View view = findViewById(R.id.challengeListContainer);
        view.setBackground(this.getResources().getDrawable(R.drawable.beerbackground));
    }
}
