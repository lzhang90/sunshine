package com.example.lzhang90.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    private static final String LOG_TAG=DetailFragment.class.getSimpleName();

    private static final String FORECAST_SHARE_HASHTAG ="#SunshineApp";
    private String mForecastStr;

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent intent=getActivity().getIntent();
        View rootView=inflater.inflate(R.layout.fragment_detail, container, false);
        if(intent!=null){
            mForecastStr=intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView detailTextView=(TextView)rootView.findViewById(R.id.detail_text);
            detailTextView.setText(mForecastStr);
        }

        return rootView;
    }

    private Intent createShareForecastIntent(){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,mForecastStr+FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment,menu);

        MenuItem menuItem=menu.findItem(R.id.action_share);

        ShareActionProvider mShareActionProvider=(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(mShareActionProvider!=null){
            mShareActionProvider.setShareIntent(createShareForecastIntent());
        }
        else
        {
            Log.d(LOG_TAG, "Share Action Provider is null.");
        }
    }
}
