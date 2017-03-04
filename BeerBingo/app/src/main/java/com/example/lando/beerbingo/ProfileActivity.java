package com.example.lando.beerbingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.example.lando.beerbingo.R.id.avatar;
import static com.example.lando.beerbingo.R.id.image;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        load_image();
        load_user_name();
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
        TextView textView = (TextView) findViewById(R.id.user_name);
        //TODO get username from somewhere
        textView.setText("Katja");

    }
}
