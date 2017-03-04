package com.example.lando.beerbingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        TextView tv = new TextView(this);
        String s = getIntent().getExtras().getString("key");
        tv.setText(s);
        LinearLayout l = (LinearLayout) findViewById(R.id.activityChallengeContainer);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        l.addView(tv, lp);
    }
}
