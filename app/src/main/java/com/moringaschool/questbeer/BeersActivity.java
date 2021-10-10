package com.moringaschool.questbeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BeersActivity extends AppCompatActivity {

    private TextView mLocationTextView;
    private ListView mListView;
    private String[] beers   = new String[] {"Kentucky Brunch Brand Stout", "Pips Meadery",
            "Rare Bourbon County Brand Stout (2010)", "Goose Island Beer Co", "King JJJuliusss", "Blessed",
            "Barrel Aged Adjunct Trail", "Rare Bourbon County Brand Stout (2015)", "The Heart of Darkness",
            "Starry Noche (2020)", "Good Morning", "Assassin (2014) (Gold Wax)",
            "Double Barrel Hunahpu's", "Bourbon County Brand Vanilla Stout (2010)",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);

        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, beers);
        mListView.setAdapter(adapter);

      //an OnItemClickListener that will display a toast containing the beer name
        // when a list item is clicked
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String beer = ((TextView)view).getText().toString();
                Toast.makeText(BeersActivity.this, beer, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the pubs near: " + location);
    }
}