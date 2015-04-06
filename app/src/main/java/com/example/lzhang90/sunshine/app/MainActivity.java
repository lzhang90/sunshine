package com.example.lzhang90.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_settings){
            Intent intent=new Intent();
            intent.setClass(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId()==R.id.action_map){
            openPreferedLocationInMap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPreferedLocationInMap(){
        String LOG_TAG=this.getClass().getSimpleName();
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String location=prefs.getString(getString(R.string.pref_location_key),getString(R.string.pref_location_default));

        Uri geoLocation= Uri.parse("geo:0,0?").buildUpon().appendQueryParameter("q",location).build();

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d(LOG_TAG,"Couldn't call "+location+", no responses");
        }
    }






}
