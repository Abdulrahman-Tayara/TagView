package com.tayara.flexlistlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class FlexListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private FlexListLayout.FlexAttributes attributes;
    private List<FlexModel> models;
    private FlexListLayout.OnFlexItemClickListener onFlexItemClickListener;
    private FlexListLayout.OnCloseButtonClickListener onCloseButtonClickListener;


    public FlexListAdapter(
            Context context,
            FlexListLayout.FlexAttributes attributes,
            List<FlexModel> models,
            FlexListLayout.OnFlexItemClickListener onFlexItemClickListener,
            FlexListLayout.OnCloseButtonClickListener onCloseButtonClickListener
    ) {
        this.context = context;
        this.attributes = attributes;
        this.models = models;
        this.onFlexItemClickListener = onFlexItemClickListener;
        this.onCloseButtonClickListener = onCloseButtonClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlexViewHolder(new FlexItem(context, attributes.textAndButtonSpace, attributes.itemSidesPadding));
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
        private FlexItem item;
        private TextView text;
        private ImageView closeButton;

        public FlexViewHolder(@NonNull View itemView) {
            super(itemView);
            item = (FlexItem) itemView;
            text = item.text;
            closeButton = item.closeButton;
        }

        public void bind(final String text, final int position) {
            this.text.setText(text);
            this.text.setText(text);
            this.text.setTextSize(attributes.textSize);
            this.text.setTextColor(context.getResources().getColor(attributes.textColor));
            item.setBackgroundResource(attributes.background);
            item.setCloseButtonVisibility(attributes.enableCloseButton ? View.VISIBLE : View.GONE);
            closeButton.setImageResource(attributes.closeButtonImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onFlexItemClickListener != null)
                        onFlexItemClickListener.onClick(text, position);
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