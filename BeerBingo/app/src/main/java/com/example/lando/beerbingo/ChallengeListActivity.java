package com.example.lando.beerbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChallengeListActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "HEJ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);
    }

    public void goToChallengeActivity(View view) {
        Intent intent = new Intent(this, ChallengeActivity.class);
        String message = view.getTag().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
