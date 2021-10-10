package com.moringaschool.questbeer;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyBeersArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mPubs;
    private String[] mBeers;

    //adapters take three pieces of info

    public MyBeersArrayAdapter(Context mContext, int resource, String[] mPubs, String[] mBeers) {
        //Calling super() from a subclass allows you to reference a method that was overridden and also
        // allows you to call both the original and the overridden method from a subclass, or call
        // the method from the superclass from within the overriding method from the subclass
        super(mContext, resource);
        this.mContext = mContext;
        this.mPubs = mPubs;
        this.mBeers = mBeers;
    }
    @Override
    public Object getItem(int position) {
        String pub = mPubs[position];
        String beer = mBeers[position];
        return String.format("%s \nServes great: %s", pub, beer);
    }

    @Override
    public int getCount() {
        return mBeers.length;
    }
}
