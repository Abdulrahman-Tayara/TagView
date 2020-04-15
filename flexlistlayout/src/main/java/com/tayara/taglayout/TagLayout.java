package com.tayara.taglayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TagLayout extends RecyclerView {

    private List<TagModel> models = new ArrayList<>();

    private TagAttributes attributes = new TagAttributes();

    private TagListAdapter adapter;

    private OnTagClickListener onTagClickListener;
    private OnCloseButtonClickListener onCloseButtonClickListener;

    public TagLayout(@NonNull Context context) {
        super(context);
        init(null);
    }

    public TagLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TagLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.TagLayout, 0, 0);
        setEnableCloseButton(array.getBoolean(R.styleable.TagLayout_tag_close_button_enable, false));
        setCloseButtonImage(array.getResourceId(R.styleable.TagLayout_tag_close_button_image, -1));
        setItemBackground(array.getResourceId(R.styleable.TagLayout_tag_background, android.R.color.holo_orange_light));
        setTextSize(array.getDimension(R.styleable.TagLayout_tag_textSize, 12f));
        setTagMargin((int) array.getDimension(R.styleable.TagLayout_tag_margin, 8));
        setTextColor(array.getColor(R.styleable.TagLayout_tag_textColor, getResources().getColor(android.R.color.white)));
        setTagLeftPadding((int) array.getDimension(R.styleable.TagLayout_tag_left_padding, 16));
        setTagRightPadding((int) array.getDimension(R.styleable.TagLayout_tag_right_padding, 16));
        setTagTopPadding((int) array.getDimension(R.styleable.TagLayout_tag_top_padding, 16));
        setTagBottomPadding((int) array.getDimension(R.styleable.TagLayout_tag_bottom_padding, 16));
        setTextAndButtonSpace((int) array.getDimension(R.styleable.TagLayout_tag_text_button_space, 4));
        array.recycle();
    }

    private void initList() {
        setLayoutManager(new TagListLayoutManager(getContext()));
        addItemDecoration(new TagItemDecoration(attributes.itemMargin));
        onCloseButtonClickListener = new OnCloseButtonClickListener() {
            @Override
            public void onClick(int position) {
                removeTag(position);
            }
        };
        adapter = new TagListAdapter(getContext(), attributes, models, onTagClickListener, onCloseButtonClickListener);
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

    public void setTagMargin(int itemMargin) {
        this.attributes.itemMargin = itemMargin;
    }


    public void setTextSize(float textSize) {
        this.attributes.textSize = textSize;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.attributes.textColor = textColor;
    }

    public void setTagLeftPadding(int padding) {
        attributes.itemLeftPadding = padding;
    }

    public void setTagRightPadding(int padding) {
        attributes.itemRightPadding = padding;
    }

    public void setTagTopPadding(int padding) {
        attributes.itemTopPadding = padding;
    }

    public void setTagBottomPadding(int padding) {
        attributes.itemBottomPadding = padding;
    }

    public void setTextAndButtonSpace(int space) {
        attributes.textAndButtonSpace = space;
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public void setOnCloseButtonClickListener(OnCloseButtonClickListener onCloseButtonClickListener) {
        this.onCloseButtonClickListener = onCloseButtonClickListener;
    }

    public void addTag(String text) {
        models.add(new TagModel(text));
        adapter.notifyItemInserted(models.size() - 1);
    }

    public void addTags(List<String> texts) {
        for (String text : texts)
            this.models.add(new TagModel(text));
        adapter.notifyDataSetChanged();
    }

    public void clearTags() {
        models.clear();
        adapter.notifyDataSetChanged();
    }

    public void removeTag(int position) {
        models.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, models.size());
    }


    // interfaces
    public interface OnTagClickListener {
        void onClick(String text, int position);
    }

    public interface OnCloseButtonClickListener {
        void onClick(int position);
    }

    class TagAttributes {
        @DrawableRes
        int background = -1;

        @DrawableRes
        int closeButtonImage = -1;

        @ColorRes
        int textColor;

        boolean enableCloseButton = false;

        int itemMargin;

        int itemLeftPadding = 16;

        int itemRightPadding = 16;

        int itemTopPadding = 16;

        int itemBottomPadding = 16;

        int textAndButtonSpace = 4;

        float textSize = 12f;
    }
}
