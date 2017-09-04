/*
 * Copyright (C) 2015-2016 Emanuel Moecklin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onegravity.rteditor.toolbar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.onegravity.colorpicker.ColorPickerListener;
import com.onegravity.colorpicker.SetColorPickerListenerEvent;
import com.onegravity.rteditor.RTToolbar;
import com.onegravity.rteditor.RTToolbarListener;
import com.onegravity.rteditor.effects.Effects;
import com.onegravity.rteditor.fonts.FontManager;
import com.onegravity.rteditor.fonts.RTTypeface;
import com.onegravity.rteditor.toolbar.spinner.BGColorSpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.ColorSpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.FontColorSpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.FontSizeSpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.FontSpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.SpinnerItem;
import com.onegravity.rteditor.toolbar.spinner.SpinnerItemAdapter;
import com.onegravity.rteditor.toolbar.spinner.SpinnerItems;

import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is a concrete implementation of the RTToolbar interface. It uses
 * toggle buttons for the effects with a simple on/off (like bold/not bold) and
 * Spinners for the more complex formatting (background color, font color, font
 * size).
 * <p>
 * While the included rte_toolar layout puts all icons in a row it's easy to use
 * multiple toolbars, each with a subset of formatting options (e.g. one for the
 * character formatting, one for the paragraph formatting, one for all the rest
 * like insert image, undo/redo etc.).
 */
public class HorizontalRTToolbar extends LinearLayout implements RTToolbar, View.OnClickListener {

    /*
     * We need a unique id for the toolbar because the RTManager is capable of managing multiple toolbars
     */
    private static AtomicInteger sIdCounter = new AtomicInteger(0);
    private int mId;

    private RTToolbarListener mListener;

    private ViewGroup mToolbarContainer;

    /*
     * The buttons
     */
    private RTToolbarImageButton mBold;
    private RTToolbarImageButton mItalic;
    private RTToolbarImageButton mUnderline;

    private int mCustomColorFont = Color.BLACK;
    private int mCustomColorBG = Color.BLACK;

    private int mPickerId = -1;
    private ColorPickerListener mColorPickerListener;

    // ****************************************** Initialize Methods *******************************************

    public HorizontalRTToolbar(Context context) {
        super(context);
        init();
    }

    public HorizontalRTToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalRTToolbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        synchronized (sIdCounter) {
            mId = sIdCounter.getAndIncrement();
        }
        SetColorPickerListenerEvent.setListener(mPickerId, mColorPickerListener);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // configure regular action buttons
        mBold = initImageButton(R.id.toolbar_bold);
        mItalic = initImageButton(R.id.toolbar_italic);
        mUnderline = initImageButton(R.id.toolbar_underline);

        initImageButton(R.id.toolbar_inc_indent);
        initImageButton(R.id.toolbar_dec_indent);
        initImageButton(R.id.toolbar_link);
        initImageButton(R.id.toolbar_image);
        initImageButton(R.id.toolbar_undo);
        initImageButton(R.id.toolbar_redo);
        initImageButton(R.id.toolbar_clear);

        // enable/disable capture picture depending on whether the device
        // has a camera or not
        PackageManager packageMgr = getContext().getPackageManager();
        if (packageMgr.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            initImageButton(R.id.toolbar_image_capture);
        } else {
            View imageCapture = findViewById(R.id.toolbar_image_capture);
            if (imageCapture != null) imageCapture.setVisibility(View.GONE);
        }

        // configure font button
//        mFont = (Spinner) findViewById(R.id.toolbar_font);
//        mFontAdapter = createDropDownNav(mFont,
//                R.layout.rte_toolbar_font_spinner,
//                R.layout.rte_toolbar_spinner_item,
//                getFontItems(), mFontListener);
//
//        // configure font size button
//        mFontSize = (Spinner) findViewById(R.id.toolbar_fontsize);
//        mFontSizeAdapter = createDropDownNav(mFontSize,
//                R.layout.rte_toolbar_fontsize_spinner,
//                R.layout.rte_toolbar_spinner_item,
//                getTextSizeItems(), mFontSizeListener);
//
//        // configure font color button
//        mFontColor = (Spinner) findViewById(R.id.toolbar_fontcolor);
//        mFontColorAdapter = createDropDownNav(mFontColor,
//                R.layout.rte_toolbar_fontcolor_spinner,
//                R.layout.rte_toolbar_fontcolor_spinner_item,
//                getFontColorItems(), mFontColorListener);
//
//        // configure bg color button
//        mBGColor = (Spinner) findViewById(R.id.toolbar_bgcolor);
//        mBGColorAdapter = createDropDownNav(mBGColor,
//                R.layout.rte_toolbar_bgcolor_spinner,
//                R.layout.rte_toolbar_bgcolor_spinner_item,
//                getBGColorItems(), mBGColorListener);
    }

    private RTToolbarImageButton initImageButton(int id) {
        RTToolbarImageButton button = (RTToolbarImageButton) findViewById(id);
        if (button != null) {
            button.setOnClickListener(this);
        }
        return button;
    }

    private SpinnerItems<FontSpinnerItem> getFontItems() {
        /*
         * Retrieve the fonts.
         */
        SortedSet<RTTypeface> fonts = FontManager.getFonts(getContext());

        /*
         * Create the spinner items
         */
        SpinnerItems<FontSpinnerItem> spinnerItems = new SpinnerItems<FontSpinnerItem>();
        spinnerItems.add(new FontSpinnerItem(null));        // empty element
        for (RTTypeface typeface : fonts) {
            spinnerItems.add(new FontSpinnerItem(typeface));
        }

        return spinnerItems;
    }

    private SpinnerItems<FontSizeSpinnerItem> getTextSizeItems() {
        SpinnerItems<FontSizeSpinnerItem> spinnerItems = new SpinnerItems<FontSizeSpinnerItem>();
        Resources res = getResources();

        // empty size
        spinnerItems.add(new FontSizeSpinnerItem(-1, "", true));

        // regular sizes
        String[] fontSizeEntries = res.getStringArray(R.array.rte_toolbar_fontsizes_entries);
        int[] fontSizeValues = res.getIntArray(R.array.rte_toolbar_fontsizes_values);
        for (int i = 0; i < fontSizeEntries.length; i++) {
            spinnerItems.add(new FontSizeSpinnerItem(fontSizeValues[i], fontSizeEntries[i], false));
        }

        return spinnerItems;
    }

    private SpinnerItems<FontColorSpinnerItem> getFontColorItems() {
        SpinnerItems<FontColorSpinnerItem> spinnerItems = new SpinnerItems<FontColorSpinnerItem>();
        Context context = getContext();

        // empty color
        String name = context.getString(R.string.rte_toolbar_color_text);
        FontColorSpinnerItem spinnerItem = new FontColorSpinnerItem(mCustomColorFont, name, true, false);
        spinnerItems.add(spinnerItem);

        // regular colors
        for (String fontColor : getResources().getStringArray(R.array.rte_toolbar_fontcolors_values)) {
            int color = Integer.parseInt(fontColor, 16);
            spinnerItem = new FontColorSpinnerItem(color, name, false, false);
            spinnerItems.add(spinnerItem);
        }

        // custom color
        name = context.getString(R.string.rte_toolbar_color_custom);
        spinnerItem = new FontColorSpinnerItem(mCustomColorFont, name, false, true);
        spinnerItems.add(spinnerItem);

        return spinnerItems;
    }

    private SpinnerItems<BGColorSpinnerItem> getBGColorItems() {
        SpinnerItems<BGColorSpinnerItem> spinnerItems = new SpinnerItems<BGColorSpinnerItem>();
        Context context = getContext();

        // empty color
        String name = context.getString(R.string.rte_toolbar_color_text);
        BGColorSpinnerItem spinnerItem = new BGColorSpinnerItem(mCustomColorFont, name, true, false);
        spinnerItems.add(spinnerItem);

        // regular colors
        for (String fontColor : getResources().getStringArray(R.array.rte_toolbar_fontcolors_values)) {
            int color = Integer.parseInt(fontColor, 16);
            spinnerItem = new BGColorSpinnerItem(color, name, false, false);
            spinnerItems.add(spinnerItem);
        }

        // custom color
        name = context.getString(R.string.rte_toolbar_color_custom);
        spinnerItem = new BGColorSpinnerItem(mCustomColorFont, name, false, true);
        spinnerItems.add(spinnerItem);

        return spinnerItems;
    }

    private <T extends SpinnerItem> SpinnerItemAdapter<T> createDropDownNav(Spinner spinner, int spinnerId, int spinnerItemId,
                                                                            SpinnerItems<T> spinnerItems,
                                                                            final DropDownNavListener<T> listener) {
        if (spinner != null) {
            Context context = getContext();

            // create custom adapter
            final SpinnerItemAdapter<T> dropDownNavAdapter = new SpinnerItemAdapter<T>(context, spinnerItems, spinnerId, spinnerItemId);

            // configure spinner
            spinner.setPadding(spinner.getPaddingLeft(), 0, spinner.getPaddingRight(), 0);
            spinner.setAdapter(dropDownNavAdapter);
            // we need this because otherwise the first item will be selected by
            // default and the OnItemSelectedListener won't get called
            spinner.setSelection(spinnerItems.getSelectedItem());
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                private AtomicBoolean mFirstCall = new AtomicBoolean(true);

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (!mFirstCall.getAndSet(false) && dropDownNavAdapter.getSelectedItem() != position) {
                        listener.onItemSelected(dropDownNavAdapter.getItem(position), position);
                    }
                    dropDownNavAdapter.setSelectedItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            return dropDownNavAdapter;
        }

        return null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (mColorPickerListener != null && mPickerId != -1) {
            SetColorPickerListenerEvent.setListener(mPickerId, mColorPickerListener);
        }
    }

    // ****************************************** RTToolbar Methods *******************************************

    @Override
    public void setToolbarContainer(ViewGroup toolbarContainer) {
        mToolbarContainer = toolbarContainer;
    }

    @Override
    public ViewGroup getToolbarContainer() {
        return mToolbarContainer == null ? this : mToolbarContainer;
    }

    @Override
    public void setToolbarListener(RTToolbarListener listener) {
        mListener = listener;
    }

    @Override
    public void removeToolbarListener() {
        mListener = null;
    }

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public void setBold(boolean enabled) {
        if (mBold != null) mBold.setChecked(enabled);
    }

    @Override
    public void setItalic(boolean enabled) {
        if (mItalic != null) mItalic.setChecked(enabled);
    }

    @Override
    public void setUnderline(boolean enabled) {
        if (mUnderline != null) mUnderline.setChecked(enabled);
    }

    @Override
    public void setStrikethrough(boolean enabled) {

    }

    @Override
    public void setSuperscript(boolean enabled) {

    }

    @Override
    public void setSubscript(boolean enabled) {

    }

    @Override
    public void setBullet(boolean enabled) {

    }

    @Override
    public void setNumber(boolean enabled) {

    }

    @Override
    public void setAlignment(Layout.Alignment alignment) {

    }

    @Override
    public void setFont(RTTypeface typeface) {

    }

    @Override
    public void setFontSize(int size) {

    }

    @Override
    public void setFontColor(int color) {

    }

    @Override
    public void setBGColor(int color) {

    }

    @Override
    public void removeFontColor() {

    }

    @Override
    public void removeBGColor() {

    }

    private void setFontColor(int color, Spinner spinner, SpinnerItemAdapter<? extends ColorSpinnerItem> adapter) {
        int color2Compare = color & 0xffffff;
        for (int pos = 0; pos < adapter.getCount(); pos++) {
            ColorSpinnerItem item = adapter.getItem(pos);
            if (!item.isEmpty() && color2Compare == (item.getColor() & 0xffffff)) {
                adapter.setSelectedItem(pos);
                spinner.setSelection(pos);
                break;
            }
        }
    }

    // ****************************************** Item Selected Methods *******************************************

    interface DropDownNavListener<T extends SpinnerItem> {
        void onItemSelected(T spinnerItem, int position);
    }

    private DropDownNavListener<FontSpinnerItem> mFontListener = new DropDownNavListener<FontSpinnerItem>() {
        @Override
        public void onItemSelected(FontSpinnerItem spinnerItem, int position) {
            RTTypeface typeface = spinnerItem.getTypeface();
            mListener.onEffectSelected(Effects.TYPEFACE, typeface);
        }
    };

    @Override
    public void onClick(View v) {
        if (mListener != null) {

            int id = v.getId();
            if (id == R.id.toolbar_bold) {
                mBold.setChecked(!mBold.isChecked());
                mListener.onEffectSelected(Effects.BOLD, mBold.isChecked());
            }

            else if (id == R.id.toolbar_italic) {
                mItalic.setChecked(!mItalic.isChecked());
                mListener.onEffectSelected(Effects.ITALIC, mItalic.isChecked());
            }

            else if (id == R.id.toolbar_underline) {
                mUnderline.setChecked(!mUnderline.isChecked());
                mListener.onEffectSelected(Effects.UNDERLINE, mUnderline.isChecked());
            }
        }
    }

}
