package com.fatwest.photos.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fatwest.photos.data.PhotosDataManger;
import com.fatwest.photos.ui.GalleryAnimActivity;
import com.mzelzoghbi.zgallery.ZGrid;
import com.mzelzoghbi.zgallery.entities.ZColor;

import photos.fatwest.com.fwphotos.R;

/**
 * Created by android on 2017/11/7.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context mContext;
    private int[] mColors = {R.mipmap.gallery, R.mipmap.item2};

    public MainAdapter(Context c) {
        mContext = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.main_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mColors[position % mColors.length])
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goGalleryActivity(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mColors.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    private void goGalleryActivity(int position){
        switch (position){
            case 0:
                gridActivity((Activity) mContext);
                break;
            case 1:
                Intent intent = new Intent(mContext, GalleryAnimActivity.class);
                mContext.startActivity(intent);
                break;
            case 2:
                break;
        }
    }

    public void gridActivity(Activity activity) {
        ZGrid.with(activity, PhotosDataManger.getInstance().getImageList())
                .setToolbarColorResId(R.color.colorPrimary)
                .setTitle("滑动浏览")
                .setToolbarTitleColor(ZColor.WHITE)
                .setSpanCount(3)
                .setGridImgPlaceHolder(R.color.colorPrimary)
                .show();
    }
}
