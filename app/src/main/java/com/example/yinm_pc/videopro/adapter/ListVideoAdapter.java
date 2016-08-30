package com.example.yinm_pc.videopro.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yinm_pc.videopro.R;
import com.example.yinm_pc.videopro.bean.ListVideoBean;
import com.example.yinm_pc.videopro.holder.ListVideoHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListVideoAdapter extends RecyclerView.Adapter<ListVideoHolder> {

    private Context context;
    private ArrayList<ListVideoBean> date;
    private OnItemClickLitener mOnItemClickLitener;

    public ListVideoAdapter(Context context, ArrayList<ListVideoBean> list) {
        this.context = context;
        this.date = list;
    }

    @Override
    public ListVideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListVideoHolder(LayoutInflater.from(
                context).inflate(R.layout.item_listvideo, parent,
                false));
    }

    @Override
    public void onBindViewHolder(final ListVideoHolder holder, int position) {
        ListVideoBean listVideoBean = date.get(position);
        holder.tv.setText(listVideoBean.getVideoString());
        if (mOnItemClickLitener != null) {
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(v,pos);
                    return true;
                }
            });
        }

        if (!TextUtils.isEmpty(listVideoBean.getPath())) {
            holder.textureVideoView.setVisibility(View.VISIBLE);
            try {
                holder.textureVideoView.setDataSource(listVideoBean.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                holder.textureVideoView.prepareAsync(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        holder.textureVideoView.setVolume(0, 0);
                        holder.textureVideoView.setLooping(true);
                        holder.textureVideoView.start();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            holder.textureVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });

            holder.textureVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

            holder.textureVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });

        } else {
            holder.textureVideoView.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return this.date.size();
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public void addItem( List<ListVideoBean> newList) {
        date.addAll(newList);
//        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        date.remove(position);
//        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}
