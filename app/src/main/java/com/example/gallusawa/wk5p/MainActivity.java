package com.example.gallusawa.wk5p;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.flurry.android.FlurryAgent;


import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String FLURRY_API_KEY = "2DF4Q45VFPCYQDWXP5B2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Flurry
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, FLURRY_API_KEY);
        //Answers & Crashlytics
        Fabric.with(this, new Answers(), new Crashlytics());
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("Tweet")
                .putContentType("Video")
                .putContentId("1234")
                .putCustomAttribute("Favorites Count", 20)
                .putCustomAttribute("Screen Orientation", "Landscape"));

    }



    public void clickResponse(View view) {
        switch (view.getId()) {
            case R.id.btnexoplayer:
                Intent intent = new Intent(this, ExoplayerActivity.class);
                intent.putExtra("exo", "player");
                startActivity(intent);
                break;

            case R.id.btnWeather:

                break;

            case R.id.btnFlurry:
                Answers.getInstance().logCustom(new CustomEvent("Flurry test")
                        .putCustomAttribute("Category", "Comedy")
                        .putCustomAttribute("Length", 350));
                Map<String, String> eventParams = new HashMap<String, String>();
                eventParams.put("event", "click");
                eventParams.put("value", "Flurry test");
                FlurryAgent.logEvent("Button clicked for Flurry test", eventParams);
                Toast.makeText(this, "Flurry Event Tracked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCrash:
                throw new RuntimeException("It has crashed");

        }
    }

}
