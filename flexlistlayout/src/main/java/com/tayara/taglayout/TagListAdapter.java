package com.tayara.taglayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class TagListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private TagLayout.TagAttributes attributes;
    private List<TagModel> models;
    private TagLayout.OnTagClickListener onTagClickListener;
    private TagLayout.OnCloseButtonClickListener onCloseButtonClickListener;


    public TagListAdapter(
            Context context,
            TagLayout.TagAttributes attributes,
            List<TagModel> models,
            TagLayout.OnTagClickListener onTagClickListener,
            TagLayout.OnCloseButtonClickListener onCloseButtonClickListener
    ) {
        this.context = context;
        this.attributes = attributes;
        this.models = models;
        this.onTagClickListener = onTagClickListener;
        this.onCloseButtonClickListener = onCloseButtonClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlexViewHolder(new TagView(
                context, attributes.textAndButtonSpace,
                attributes.itemLeftPadding,
                attributes.itemRightPadding,
                attributes.itemTopPadding,
                attributes.itemBottomPadding
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FlexViewHolder) holder).bind(models.get(position).getTitle(), position);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class FlexViewHolder extends RecyclerView.ViewHolder {
        private TagView item;
        private TextView text;
        private ImageView closeButton;

        public FlexViewHolder(@NonNull View itemView) {
            super(itemView);
            item = (TagView) itemView;
            text = item.text;
            closeButton = item.closeButton;
        }

        @SuppressLint("ResourceAsColor")
        public void bind(final String text, final int position) {
            this.text.setText(text);
            this.text.setText(text);
            this.text.setTextSize(attributes.textSize);
            this.text.setTextColor(attributes.textColor);
            item.setBackgroundResource(attributes.background);
            item.setCloseButtonVisibility(attributes.enableCloseButton ? View.VISIBLE : View.GONE);
            closeButton.setImageResource(attributes.closeButtonImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onTagClickListener != null)
                        onTagClickListener.onClick(text, position);
                }
            });
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onCloseButtonClickListener != null)
                        onCloseButtonClickListener.onClick(position);
                }
            });
        }
    }
}