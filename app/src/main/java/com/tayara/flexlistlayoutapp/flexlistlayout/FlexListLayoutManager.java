package com.tayara.flexlistlayoutapp.flexlistlayout;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

class FlexListLayoutManager extends FlexboxLayoutManager {

    FlexListLayoutManager(Context context) {
        super(context);
        init();
    }

    public FlexListLayoutManager(Context context, int flexDirection) {
        super(context, flexDirection);
        init();
    }

    public FlexListLayoutManager(Context context, int flexDirection, int flexWrap) {
        super(context, flexDirection, flexWrap);
        init();
    }

    public FlexListLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setFlexDirection(FlexDirection.ROW);
        setJustifyContent(JustifyContent.FLEX_START);
        setAlignItems(AlignItems.FLEX_START);
    }
}
