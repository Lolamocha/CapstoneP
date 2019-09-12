package com.lolamocha.android.capstonep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.lolamocha.android.capstonep.ui.movieslist.MoviesActivity;

public class SecondActivity extends AppCompatActivity {


    TextView name,email;
    Button signOut;
    GoogleSignInClient mGoogleSignInClient;
    AdView mAdView;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoviesActivity();
                // startService();
            }
        });


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        //ca-app-pub-2372120906892054~7907610760

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = findViewById(R.id.adView);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("2F0038C369923491")
                .build();//2F0038C369923491

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);


        name = findViewById(R.id.textName);
        email = findViewById(R.id.textEmail);

        signOut = findViewById(R.id.signOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.signOut:
                        signOut();
                        break;
                }
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            name.setText("Name : " + personName);
            email.setText("Email : " + personEmail);
        }
    }
    private void openMoviesActivity() {
        Intent intent = new Intent(this, MoviesActivity.class);
        startActivity(intent);
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Toast.makeText(SecondActivity.this,"Sign Out Successfully",Toast.LENGTH_SHORT).show();
                        Toast.makeText(SecondActivity.this,getString(R.string.sign_out_text),Toast.LENGTH_SHORT).show();
                        // Toast.makeText(getApplicationContext(),getString(R.string.exit_survey_toast),Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }



}
