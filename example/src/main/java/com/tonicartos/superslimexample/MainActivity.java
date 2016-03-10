package com.tonicartos.superslimexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity {

    private static final String TAG_COUNTRIES_FRAGMENT = "tag_countries_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new CountriesFragment(), TAG_COUNTRIES_FRAGMENT)
                    .commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private CountriesFragment getCountriesFragment() {
        return (CountriesFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_COUNTRIES_FRAGMENT);
    }
}
