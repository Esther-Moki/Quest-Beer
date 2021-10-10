package com.moringaschool.questbeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
;import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
   // public static final String TAG = MainActivity.class.getSimpleName();

//    private Button mFindBeersButton;
//    private EditText mLocationEditText;
//    private TextView mAppNameTextView;

    //view binding generates a binding class for each XML layout file present in that module
    @BindView(R.id.findBeersButton) Button mFindBeersButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
//        mFindBeersButton= (Button)findViewById(R.id.findBeersButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        ButterKnife.bind(this);
        mFindBeersButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
               // Log.d(TAG, location);
                Intent intent = new Intent(MainActivity.this, BeersActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);

            }
        });
    }
}