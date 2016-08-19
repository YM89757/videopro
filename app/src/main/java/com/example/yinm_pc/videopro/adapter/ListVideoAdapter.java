package com.example.yinm_pc.videopro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yinm_pc.videopro.bean.ListVideoBean;
import com.example.yinm_pc.videopro.R;

import java.util.ArrayList;

public class ListVideoAdapter extends RecyclerView.Adapter<ListVideoAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ListVideoBean> date;
    private OnItemClickLitener mOnItemClickLitener;

    public ListVideoAdapter(Context context, ArrayList<ListVideoBean> list) {
        this.context = context;
        this.date = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_listvideo, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(date.get(position).getVideoString());
        if (mOnItemClickLitener != null) {
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

        }
    }


    @Override
    public int getItemCount() {
        return this.date.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_list_video_text);
        }
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
