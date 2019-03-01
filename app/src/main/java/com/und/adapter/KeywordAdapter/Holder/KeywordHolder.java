package com.und.adapter.KeywordAdapter.Holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.und.R;
import com.und.adapter.Listenner.KeywordEventListener;
import com.und.core.Layout.common.uBaseViewHolder;

/**
 * Created by hungle on 01/03/2019.
 */

public class KeywordHolder extends uBaseViewHolder<KeywordEventListener> {

    public TextView tvTitle;

    public ImageView itemImage;

    public KeywordHolder(Context ctx, View view) {
        super(ctx, view);

        this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
