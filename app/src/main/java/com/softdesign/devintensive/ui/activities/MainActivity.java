package com.softdesign.devintensive.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.graphics.BitmapFactory;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.softdesign.devintensive.R;
import android.support.design.widget.NavigationView;
import android.widget.ImageView;
import android.widget.TextView;


import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity";


    private CoordinatorLayout mCoordinatorLayout;
    private  Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private ImageView mImageView;

    protected EditText mEditText;
    protected String mColorMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_container);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        if (savedInstanceState == null) {
            showSnackbar("Активити запускается впервые");
        } else {
            showSnackbar("Активити уже создалось");
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");

    }

    private void showSnackbar(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();

    }




    private void setupDrawerHeader(NavigationView parent, Bitmap avatar, String name, String email){
                View view = parent.getHeaderView(0);
                if (avatar != null) {
                        RoundedBitmapDrawable dr= RoundedBitmapDrawableFactory.create(getResources(),avatar);
                        dr.setCircular(true);
                        ImageView imageView = (ImageView)view.findViewById(R.id.avatar);
                        imageView.setImageDrawable(dr);
                    }
                if (name != null){
                       TextView textView = (TextView)view.findViewById(R.id.user_name_txt);
                       textView.setText(name);
                   }
                if (email != null){
                        TextView textView = (TextView)view.findViewById(R.id.user_email_txt);
                        textView.setText(email);
                    }
            }

   

    private void setupToolbar() {
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }



    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
    }
}