package com.tayara.flexlistlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FlexListLayout extends RecyclerView {

    private List<FlexModel> models = new ArrayList<>();

    private FlexAttributes attributes = new FlexAttributes();

    private FlexListAdapter adapter;

    private OnFlexItemClickListener onFlexItemClickListener;
    private OnCloseButtonClickListener onCloseButtonClickListener;

    public FlexListLayout(@NonNull Context context) {
        super(context);
        init(null);
    }

    public FlexListLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FlexListLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.FlexListLayout, 0, 0);
        setEnableCloseButton(array.getBoolean(R.styleable.FlexListLayout_close_button_enable, false));
        setCloseButtonImage(array.getResourceId(R.styleable.FlexListLayout_close_button_image, -1));
        setItemBackground(array.getResourceId(R.styleable.FlexListLayout_item_background, -1));
        setTextSize(array.getDimension(R.styleable.FlexListLayout_item_textSize, 12f));
        setItemMargin((int) array.getDimension(R.styleable.FlexListLayout_item_margin, 8));
        setTextColor(array.getResourceId(R.styleable.FlexListLayout_item_textColor, getResources().getColor(android.R.color.darker_gray)));
        setItemSidesPadding((int) array.getDimension(R.styleable.FlexListLayout_item_sides_padding, 16));
        setTextAndButtonSpace((int) array.getDimension(R.styleable.FlexListLayout_item_text_button_space, 4));
        array.recycle();
    }

    private void initList() {
        setLayoutManager(new FlexListLayoutManager(getContext()));
        addItemDecoration(new FlexItemDecoration(attributes.itemMargin));
        onCloseButtonClickListener = new OnCloseButtonClickListener() {
            @Override
            public void onClick(int position) {
                removeItem(position);
            }
        };
        adapter = new FlexListAdapter(getContext(), attributes, models, onFlexItemClickListener, onCloseButtonClickListener);
        setAdapter(adapter);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private void init(AttributeSet attributeSet) {
        parseAttributes(attributeSet);
        initList();
    }

    // public methods

    public void setItemBackground(@DrawableRes int background) {
        if (background == -1)
            this.attributes.background = android.R.color.transparent;
        else
            this.attributes.background = background;
    }

    public void setCloseButtonImage(@DrawableRes int closeButtonImage) {
        if (closeButtonImage == -1)
            this.attributes.closeButtonImage = android.R.drawable.ic_menu_close_clear_cancel;
        else
            this.attributes.closeButtonImage = closeButtonImage;
    }

    public void setEnableCloseButton(boolean enableCloseButton) {
        this.attributes.enableCloseButton = enableCloseButton;
    }

    public void setItemMargin(int itemMargin) {
        this.attributes.itemMargin = itemMargin;
    }


    public void setTextSize(float textSize) {
        this.attributes.textSize = textSize;
    }

    public void setTextColor(@ColorRes int textColor) {
        this.attributes.textColor = textColor;
    }

    public void setItemSidesPadding(int sidesPadding) {
        attributes.itemSidesPadding = sidesPadding;
    }

    public void setTextAndButtonSpace(int space) {
        attributes.textAndButtonSpace = space;
    }

    public void setOnFlexItemClickListener(OnFlexItemClickListener onFlexItemClickListener) {
        this.onFlexItemClickListener = onFlexItemClickListener;
    }

    public void setOnCloseButtonClickListener(OnCloseButtonClickListener onCloseButtonClickListener) {
        this.onCloseButtonClickListener = onCloseButtonClickListener;
    }

    public void addItem(String text) {
        models.add(new FlexModel(text));
        adapter.notifyItemInserted(models.size() - 1);
    }

    public void addItems(List<String> texts) {
        for (String text : texts)
            this.models.add(new FlexModel(text));
        adapter.notifyDataSetChanged();
    }

    public void clearItems() {
        models.clear();
        adapter.notifyDataSetChanged();
    }

    public void removeItem(int position) {
        models.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, models.size());
    }


    // interfaces
    public interface OnFlexItemClickListener {
        void onClick(String text, int position);
    }

    public interface OnCloseButtonClickListener {
        void onClick(int position);
    }

    class FlexAttributes {
        @DrawableRes
        int background = -1;

        @DrawableRes
        int closeButtonImage = -1;

        @ColorRes
        int textColor;

        boolean enableCloseButton = false;

        int itemMargin;

        int itemSidesPadding = 16;

        int textAndButtonSpace = 4;

        float textSize = 12f;
    }
}
