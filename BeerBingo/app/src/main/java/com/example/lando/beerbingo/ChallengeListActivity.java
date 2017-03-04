package com.example.lando.beerbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.lang.reflect.Array;

public class ChallengeListActivity extends AppCompatActivity {

    private String[] challengeList = {"CH 1, drink 10 beers", "CH 2, do something funny", "CH 3, HAJ!!"};
    private Button[] buttonList = new Button[challengeList.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);
        String s;
        for (int i = 0; i < challengeList.length; i++) {
            buttonList[i] = new Button(this);
            buttonList[i].setText(challengeList[i]);
            s = "challenge";
            s = s + (i+1);
            s += "_info";
            buttonList[i].setTag(s);
            final String finalS = s;
            buttonList[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    Intent intent = new Intent(ChallengeListActivity.this, ChallengeActivity.class);
                    intent.putExtra("key", finalS);
                    ChallengeListActivity.this.startActivity(intent);
                }
            });
            LinearLayout l = (LinearLayout) findViewById(R.id.challengeListContainer);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            l.addView(buttonList[i], lp);
        }
    }
}
