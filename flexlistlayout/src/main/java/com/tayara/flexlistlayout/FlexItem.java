package com.tayara.flexlistlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.Nullable;

class FlexItem extends LinearLayout {

    public TextView text;
    public Space space;
    public ImageView closeButton;

    private int margin = 4, padding = 16;

    public FlexItem(Context context, int margin, int padding) {
        super(context);
        this.margin = margin;
        this.padding = padding;
        init();
    }

    public FlexItem(Context context) {
        super(context);
        init();
    }

    public FlexItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlexItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public FlexItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void initCloseButton() {
        closeButton = new ImageView(getContext());
        closeButton.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(closeButton);
    }

    private void initSpace() {
        space = new Space(getContext());
        LayoutParams spaceParam = new LayoutParams(margin, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(space, spaceParam);
    }

    private void initText() {
        text = new TextView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(text, params);
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setPadding(padding, 0, padding, 0);
        setGravity(Gravity.CENTER);
        initText();
        initSpace();
        initCloseButton();
    }

    public void setCloseButtonVisibility(int visibility) {
        closeButton.setVisibility(visibility);
        space.setVisibility(visibility);
    }
}
