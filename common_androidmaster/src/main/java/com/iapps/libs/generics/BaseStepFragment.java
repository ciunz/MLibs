package com.iapps.libs.generics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iapps.common_library.R;
import com.iapps.libs.helpers.BaseHelper;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by korneliussendy on 1/24/17.
 */

public abstract class BaseStepFragment extends SlideFragment {


    private BaseHelper.ImagePickListener imagePickListener;

    public void setImagePickListener(BaseHelper.ImagePickListener listener) {
        this.imagePickListener = listener;
    }

    public void imagePickFail() {
        if (imagePickListener != null)
            imagePickListener.onPickFail();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BaseHelper.REQUEST_GET_IMAGE_CODE && resultCode == -1) {
            imagePickListener.onPickSuccess();
        } else {
            imagePickListener.onPickFail();
        }
    }
}