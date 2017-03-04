package com.example.lando.beerbingo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import com.google.firebase.database.*;



public class ProfileActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private static final String TAG = "ProfileActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        load_image();
        load_user_name();
        //TODO User information generator
    }
    private void load_image(){
        Toast.makeText(getApplicationContext(), "Loading your avatar.",
                Toast.LENGTH_SHORT).show();
        //Initialize ImageView
        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        ImageView ivBasicImage = (ImageView) findViewById(R.id.avatar);
        Picasso.with(this).load(imageUri).into(ivBasicImage);

    }
    private void load_user_name(){
        final TextView textView = (TextView) findViewById(R.id.user_name);
        //TODO get username from somewhere
        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();

        //myRef.setValue("hej");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //Toast.makeText(ProfileActivity.this, dataSnapshot.child("users/katja").getValue().toString(),
                  //      Toast.LENGTH_SHORT).show();
                textView.setText(dataSnapshot.child("users/katja").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



    }
}
