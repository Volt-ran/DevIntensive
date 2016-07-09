package com.softdesign.devintensive.ui.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.support.design.widget.AppBarLayout;
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
import android.widget.RelativeLayout;



import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.widget.RelativeLayout;


import com.softdesign.devintensive.utils.ConstantManager;
import com.squareup.picasso.Picasso;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity";


    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private ImageView mImageView;

    protected EditText mEditText;
    protected String mColorMode;
    private RelativeLayout mProfilePlaceholder;


    mProfilePlaceholder=(RelativeLayout):

    findViewById(R.id.profile_placeholder);

    mProfilePlaceholder.setOnClickListener(this);
    mProfilePlaceholder = (RelativeLayout) findViewById(R.id.profile_placeholder);
    mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
    mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mFab = (FloatingActionButton) findViewById(R.id.fab);
    mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
    mMainProfileImage = (ImageView) findViewById(R.id.main_profile_image);
    mCall = (ImageView) findViewById(R.id.button_call);
    mCall.setOnClickListener(this);
    mSendEmail = (ImageView) findViewById(R.id.button_send_email);
    mSendEmail.setOnClickListener(this);
    mShowVk = (ImageView) findViewById(R.id.button_open_vk);
    mShowVk.setOnClickListener(this);
    mShowRepos = (ImageView) findViewById(R.id.button_open_repos);
    mShowRepos.setOnClickListener(this);

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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


    private void setupDrawerHeader(NavigationView parent, Bitmap avatar, String name, String email) {
        View view = parent.getHeaderView(0);
        if (avatar != null) {
            RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(getResources(), avatar);
            dr.setCircular(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
            imageView.setImageDrawable(dr);
        }
        if (name != null) {
            TextView textView = (TextView) view.findViewById(R.id.user_name_txt);
            textView.setText(name);
        }
        if (email != null) {
            TextView textView = (TextView) view.findViewById(R.id.user_email_txt);
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

    showProfilePlaceholder();


    private void hideProfilePlaceholder() {
        mProfilePlaceholder.setVisibility(View.GONE);
    }

    private void showProfilePlaceholder() {
                mProfilePlaceholder.setVisibility(View.VISIBLE);
            }
}

    private void lockToolbar() {
        mAppBarLayout.setExpanded(true, true);
        mAppBarParams.setScrollFlags(0);
        mCollapsingToolbar.setLayoutParams(mAppBarParams);
    }

    private void unlockToolbar() {
        mAppBarParams.setScrollFlags(
                AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL |
                        AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
        );
        mCollapsingToolbar.setLayoutParams(mAppBarParams);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case ConstantManager.LOAD_PROFILE_PHOTO:
                String[] selectItems = {
                        getString(R.string.user_profile_dialog_gallery),
                        getString(R.string.user_profile_dialog_camera),
                        getString(R.string.user_profile_dialog_cancel)
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.user_profile_dialog_title));
                builder.setItems(selectItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choiceItem) {
                        switch (choiceItem) {
                            case 0:
                                loadPhotoFromGallery();
                                break;
                            case 1:
                                loadPhotoFromCamera();
                                break;
                            case 3:
                                dialog.cancel();
                                break;
                        }
                    }
                });
                return builder.create();

            default:
                return null;
        }
    }

    private void insertProfileImage(Uri selectedImage) {
        showSnackBar("insertImage" + selectedImage);
        Picasso.with(this)
                .load(selectedImage)
                // TODO: 01.07.16 сделать placeholder, transform + crop
                .into(mProfileImage);

        mDataManager.getPreferencesManager().saveUserPhoto(selectedImage);
    }

    public void openApplicationSettings() {
        Intent appSettingsIntent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + getPackageName()));
        startActivityForResult(appSettingsIntent, ConstantManager.PERMISSION_SETTINGS_REQUEST_CODE);
    }
}






