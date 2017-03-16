package com.example.no_clay.justfordemo.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.no_clay.justfordemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by no_clay on 2017/3/15.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private List<Demo> mDemos;

    public Adapter(Context context, List<Demo> demos) {
        mContext = context;
        mDemos = demos;
    }


    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public List<Demo> getDemos() {
        return mDemos;
    }

    public void setDemos(List<Demo> demos) {
        mDemos = demos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.demo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Demo demo = mDemos.get(position);
        holder.mTitle.setText(demo.getTitle());
        holder.mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(demo.getIntent());
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDemos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.start)
        TextView mStart;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
