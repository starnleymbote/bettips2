package com.nanocomputing.bettips;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.nanocomputing.bettips.activities.TipsActivity;
import com.nanocomputing.bettips.fragments.MainFragment;
import com.nanocomputing.bettips.models.tips;
import com.nanocomputing.bettips.other.CountDrawable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainFragment.OnFragmentInteractionListener {
    private RecyclerView recyclerView,recyclerView1;
    private Context context;
    private AdView mAdView,mAdView1;
    private InterstitialAd mInterstitialAd;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {

            MainFragment p = MainFragment.newInstance();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content, p);
            ft.commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mAdView = findViewById(R.id.adView);
        /*recyclerView = findViewById(R.id.recyclerView);
        recyclerView1 = findViewById(R.id.recyclerView1);
        mAdView = findViewById(R.id.adView);
        mAdView1 = findViewById(R.id.adView1);

        TextView textView = findViewById(R.id.textView);
        String firstWord="15";
        String lastWord="FEB";
        Spannable spannable = new SpannableString(firstWord+lastWord);
        spannable.setSpan(new RelativeSizeSpan(1.1f),0, firstWord.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        spannable.setSpan(new RelativeSizeSpan(0.8f), firstWord.length(), firstWord.length() +
                lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        textView.setText( spannable );
        getDailyTips();
        getSaveTips();
        showAds();*/
        showAds();

    }

    private void showAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        //AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //mAdView1.loadAd(adRequest1);

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


    private void getDailyTips(){
        recyclerView.addItemDecoration(
                new DividerItemDecoration(context,
                        LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        List<tips> tipsList = new ArrayList<>();
        tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
        tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
       // tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
       // tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new tipsAdapter(tipsList,context) );
    }

    private void getSaveTips(){
        recyclerView1.addItemDecoration(
                new DividerItemDecoration(context,
                        LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        List<tips> tipsList = new ArrayList<>();
        tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
        tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
        tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
        // tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
        // tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView1.setAdapter(new tipsAdapter(tipsList,context) );
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this, TipsActivity.class);

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            intent.putExtra("title","Correct Score");
            startActivity(intent);


        } else if (id == R.id.nav_slideshow) {
            intent.putExtra("title","Double Chance");
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            intent.putExtra("title","Over 2.5");
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            intent.putExtra("title","Mega JackPot");
            startActivity(intent);

        } else if (id == R.id.nav_send) {

            intent.putExtra("title","Mid Week JackPot");
            startActivity(intent);

        }
        else if (id == R.id.nav_under25) {
            intent.putExtra("title","Under 2.5");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        setCount(this, "9");
        return true;
    }

    public void setCount(Context context, String count) {
        MenuItem menuItem = menu.findItem(R.id.ic_group);
        LayerDrawable icon = (LayerDrawable) menuItem.getIcon();

        CountDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_group_count);
        if (reuse != null && reuse instanceof CountDrawable) {
            badge = (CountDrawable) reuse;
        } else {
            badge = new CountDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_group_count, badge);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
