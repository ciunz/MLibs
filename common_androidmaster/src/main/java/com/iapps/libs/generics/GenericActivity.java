package com.iapps.libs.generics;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.iapps.common_library.R;
import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.BaseUIHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import roboguice.activity.RoboActionBarActivity;

public class GenericActivity
        extends RoboActionBarActivity {
    int containerId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();

        ImageLoader.getInstance().init(config);
    }

    // ================================================================================
    // Fragment Functions
    // ================================================================================
    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public void addFragmentNoAnim(Fragment frag) {
        if (containerId > 0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(containerId, frag).addToBackStack(null)
                    .commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    public void addFragment(Fragment frag) {
        addFragment(this.containerId, frag);
    }

    public void addFragment(Fragment frag, String tag) {
        addFragment(this.containerId, frag, tag);
    }

    public void setFragment(Fragment frag) {
        setFragment(this.containerId, frag);
    }

    /**
     * Add fragment on top of the current one
     *
     * @param frag
     */
    public void addFragment(int containerId, Fragment frag) {
//        if (containerId > 0) {
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
//                transaction.setCustomAnimations(R.anim.up_from_bottom_slow, 0, 0,
//                        R.anim.up_from_bottom_slow_exit);
//            } else {
//                transaction.setCustomAnimations(R.anim.zoom_in, R.anim.zoom_in);
//            }
//
//            transaction.add(containerId, frag).addToBackStack(null)
//                    .commit();
//
//            if (getSupportActionBar() != null)
//                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        }
//
//        BaseUIHelper.hideKeyboard(this);
        addFragment(containerId, frag, null);
    }

    public void addFragment(int containerId, Fragment frag, String tag) {
        if (containerId > 0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
                transaction.setCustomAnimations(R.anim.up_from_bottom_slow, 0, 0,
                        R.anim.up_from_bottom_slow_exit);
            } else {
                transaction.setCustomAnimations(R.anim.zoom_in, R.anim.zoom_in);
            }
            if (BaseHelper.isEmpty(tag)){
                transaction
                        .add(containerId, frag)
                        .addToBackStack(null)
                        .commit();

//                try{
//                    transaction
//                            .add(containerId, frag)
//                            .addToBackStack(null)
//                            .commit();
//                }
//                catch (Exception e) {
//                    Log.e("Error : clear fragment", e.getMessage());
//                }
//                finally {
//                    transaction
//                            .add(containerId, frag)
//                            .addToBackStack(null)
//                            .commitAllowingStateLoss();
//                }
            }
            else
                transaction
                        .add(containerId, frag, tag)
                        .addToBackStack(tag)
                        .commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        BaseUIHelper.hideKeyboard(this);
    }

    public void addFragment(Fragment frag, int animIn, int animOut) {
        if (containerId > 0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


            transaction.setCustomAnimations(animIn, animOut, animIn, animOut);


            transaction.add(containerId, frag).addToBackStack(null)
                    .commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // setSupportProgressBarIndeterminateVisibility
        }
    }

    /**
     * Change to new fragment
     *
     * @param frag
     */
    public void setFragment(int containerId, Fragment frag) {
        if (containerId > 0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
                transaction.setCustomAnimations(R.anim.up_from_bottom_slow, 0, 0,
                        R.anim.up_from_bottom_slow_exit);
            } else {
                transaction.setCustomAnimations(R.anim.zoom_in, R.anim.zoom_in);
            }

            transaction.replace(containerId, frag).addToBackStack(null)
                    .commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // setSupportProgressBarIndeterminateVisibility
        }
    }

    public void setFragment(Fragment frag, int animIn, int animOut) {
        if (containerId > 0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


            transaction.setCustomAnimations(animIn, animOut, animIn, animOut);


            transaction.replace(containerId, frag).addToBackStack(null)
                    .commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // setSupportProgressBarIndeterminateVisibility
        }
    }

    public void addFragmentWithAnim(Fragment frag, int animIn, int animOut) {
        if (containerId > 0) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(animIn, animOut, animIn, animOut)
                    .add(containerId, frag).addToBackStack(null).commit();

            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);

            // Hide keyboard by default
            BaseUIHelper.hideKeyboard(this);
        }
    }

    /**
     * Clear all fragments
     */
    public void clearFragment() {
        try {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (Exception e) {
            Log.e("Error : clear fragment", e.getMessage());
        }
    }

    /**
     * Remove top of fragments
     */
    public void popBackstack() {
        getSupportFragmentManager().popBackStack();
    }

    // ================================================================================
    // Behavior Controller
    // ================================================================================

    /**
     * Controls behavior of the back button
     */
    @Override
    public void onBackPressed() {
        // Only close apps when there's no backstack
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }
}
