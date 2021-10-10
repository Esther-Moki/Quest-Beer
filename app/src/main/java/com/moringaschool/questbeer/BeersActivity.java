package com.moringaschool.questbeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BeersActivity extends AppCompatActivity {

    private TextView mLocationTextView;
    private String[] beers   = new String[] {"Kentucky Brunch Brand Stout", "Pips Meadery",
            "Rare Bourbon County Brand Stout (2010)", "Goose Island Beer Co", "King JJJuliusss", "Blessed",
            "Barrel Aged Adjunct Trail", "Rare Bourbon County Brand Stout (2015)", "The Heart of Darkness",
            "Starry Noche (2020)", "Good Morning", "Assassin (2014) (Gold Wax)",
            "Double Barrel Hunahpu's", "Bourbon County Brand Vanilla Stout (2010)",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the pubs near: " + location);
    }
}