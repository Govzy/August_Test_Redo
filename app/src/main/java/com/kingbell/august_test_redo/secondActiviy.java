package com.kingbell.august_test_redo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;


public class secondActiviy extends ActionBarActivity {

    TextView tx1;
    Button next, previous, googie;
    ImageView imageViewSecond;
    int imageCounter = 0;
    WebView wv;
    ToggleButton tb;
    DataSource ds = new DataSource();
    LinearLayout butLayout, fragLayout;
    fragmentA fa;
    fragmentB fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activiy);



////        if(prefs.getInt("greenV", 0) != 0){
////            fb.tvFragB.setTextColor(Color.rgb(fa.red, fa.green, fa.blue));
////            fa.green = prefs.getInt("greenV", 0);
////        }
////        if(prefs.getInt("blueV", 0) != 0){
////            fb.tvFragB.setTextColor(Color.rgb(fa.red, fa.green, fa.blue));
////            fa.blue = prefs.getInt("blueV", 0);
////        }

        //View Initialization
        tx1 = (TextView) findViewById(R.id.planetNameText);
        next = (Button) findViewById(R.id.nextButton);
        previous = (Button) findViewById(R.id.previousButton);
        imageViewSecond = (ImageView) findViewById(R.id.imageViewSecond);
        wv = (WebView) findViewById(R.id.webView);
        tb = (ToggleButton) findViewById(R.id.toggleButtonWeb);
        butLayout = (LinearLayout) findViewById(R.id.buttonLayout);
        fragLayout = (LinearLayout) findViewById(R.id.fragmentLayout);
        googie = (Button) findViewById(R.id.googleButton);



        //find the id of Fragment
        fa = (fragmentA) getFragmentManager().findFragmentById(R.id.fragment1);
        fb = (fragmentB) getFragmentManager().findFragmentById(R.id.fragment2);

        //Get intent Value
        final int positionId = getIntent().getIntExtra("itemPosition", 0);
        imageCounter = positionId;

        //Set it to image and text view
        imageViewSecond.setImageResource(ds.image[positionId]);
        tx1.setText(ds.planetNameData[positionId]);

        //OnClickListener for Next Button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageCounter++;
                if (imageCounter >= ds.planetNameData.length) {
                    imageCounter = 0;
                    Log.e("Inside Checker", "V is " + imageCounter);
                }
                Log.e("Outside Checker", "V is " + imageCounter);
                imageViewSecond.setImageResource(ds.image[imageCounter]);
                tx1.setText(ds.planetNameData[imageCounter]);
            }
        });

        //onClickListener for Previous Button
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageCounter--;
                if (imageCounter < 0) {
                    imageCounter = ds.planetNameData.length - 1;
                    Log.e("Inside Checker", "V is " + imageCounter);
                }
                Log.e("Outside Checker", "V is " + imageCounter);
                imageViewSecond.setImageResource(ds.image[imageCounter]);
                tx1.setText(ds.planetNameData[imageCounter]);
            }
        });

        //Toggle Button on Click
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    butLayout.setVisibility(View.GONE);
                    fragLayout.setVisibility(View.VISIBLE);
                } else {
                    fragLayout.setVisibility(View.GONE);
                    butLayout.setVisibility(View.VISIBLE);
                }

            }
        });

        //googie OnClick
        googie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                wv.setWebViewClient(new WebViewClient());
                wv.loadUrl(url);
            }
        });

        //       Shared Preference Code
//        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        if((prefs.getInt("redV", 0) != 0)){
//            fb.tvFragB.setTextColor(Color.rgb(prefs.getInt("redV",0), prefs.getInt("greenV", 0), prefs.getInt("greenV", 0)));
//            fa.red = prefs.getInt("redV", 0);
//            fa.green=prefs.getInt("greenV",0);
//            fa.blue=prefs.getInt("blueV",0);
//        }
    }
        //Fragment Color Update
        public void updateColor()
        {
            fb.tvFragB.setTextColor(Color.rgb(fa.red, fa.green, fa.blue));

        }

    }




