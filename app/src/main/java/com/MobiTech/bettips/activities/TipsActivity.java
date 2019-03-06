package com.MobiTech.bettips.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.nanocomputing.bettips.R;
import com.nanocomputing.bettips.TheTipsAdapter;
import com.nanocomputing.bettips.models.tips;
import com.nanocomputing.bettips.tipsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private AdView mAdView,mAdView1;
    private InterstitialAd mInterstitialAd;
    String title;
    List<tips> tipsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        title = getIntent().getStringExtra("title");
        this.setTitle(title +" Tips");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = getApplicationContext();
        recyclerView = findViewById(R                                                                                           .id.recyclerView);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(context,
                        LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        mAdView = findViewById(R.id.adView);
        mAdView1 = findViewById(R.id.adView1);

        switch (title){
            case "Correct Score":
                getCorrectScore();
                break;
            case "Double Chance":
                getDoubleChance();
                break;
            case "Over 2.5":
                getOver25();
                break;
            case "Under 2.5":
                getUnder25();
                break;
            case "Mega JackPot":
                getMegaJackpot();
                break;
            case "Mid Week JackPot":
                getMidWeekJackpot();
                break;
        }
        showAds();

    }
    private void showAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView1.loadAd(adRequest1);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.intertistial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.e("Intertistial Ad TAG", "The interstitial wasn't loaded yet.");
        }
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("Intertistial Ad TAG", "The interstitial Loaded");
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.e("Intertistial Ad TAG", "The interstitial failed "+errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        });
    }

   private void getCorrectScore(){
        tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
        tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
        tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
        tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

       recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );
    }
    private void getDoubleChance(){
         tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
         tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
         tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
         tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );    }
    private void getOver25(){
         tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
         tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
         tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
         tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );
    }
    private void getUnder25(){
         tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
         tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
         tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
         tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );
    }
    private void getMegaJackpot(){
         tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
         tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
         tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
         tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );
    }
    private void getMidWeekJackpot(){
         tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
         tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
         tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
         tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

         recyclerView.setAdapter(new TheTipsAdapter(tipsList,context) );

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
        }
        return super.onOptionsItemSelected(item);
    }
}
