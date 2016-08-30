package com.example.yinm_pc.videopro.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yinm_pc.videopro.R;
import com.example.yinm_pc.videopro.customview.TextureVideoView;

/**
 * Created by zjq on 16/8/30.
 */
public class ListVideoHolder extends RecyclerView.ViewHolder {

    public TextView tv;
    public TextureVideoView textureVideoView;

    public ListVideoHolder(View view) {
        super(view);
        tv = (TextView) view.findViewById(R.id.item_list_video_text);
        textureVideoView = (TextureVideoView) view.findViewById(R.id.item_list_video);
    }
}
