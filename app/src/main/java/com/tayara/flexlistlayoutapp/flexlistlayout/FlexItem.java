package com.tayara.flexlistlayoutapp.flexlistlayout;

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

    private int margin = 4, leftPadding, rightPadding, topPadding, bottomPadding;

    public FlexItem(Context context, int margin, int leftPadding, int rightPadding, int topPadding, int bottomPadding) {
        super(context);
        this.margin = margin;
        this.leftPadding = leftPadding;
        this.rightPadding = rightPadding;
        this.topPadding = topPadding;
        this.bottomPadding = bottomPadding;
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
        setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
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
