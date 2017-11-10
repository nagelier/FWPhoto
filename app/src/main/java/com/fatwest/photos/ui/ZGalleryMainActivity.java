package com.fatwest.photos.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fatwest.photos.data.PhotosDataManger;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.ZGrid;
import com.mzelzoghbi.zgallery.entities.ZColor;

import photos.fatwest.com.fwphotos.R;

/**
 * Created by android on 2017/11/9.
 */

public class ZGalleryMainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zgallery_activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void gridActivity(View v) {
        ZGrid.with(this, PhotosDataManger.getInstance().getImageList())
                .setToolbarColorResId(R.color.colorPrimary)
                .setTitle("Zak Gallery")
                .setToolbarTitleColor(ZColor.WHITE)
                .setSpanCount(3)
                .setGridImgPlaceHolder(R.color.colorPrimary)
                .show();
    }


    public void galleryActivity(View v) {
        ZGallery.with(this, PhotosDataManger.getInstance().getImageList())
                .setToolbarTitleColor(ZColor.WHITE)
                .setGalleryBackgroundColor(ZColor.WHITE)
                .setToolbarColorResId(R.color.colorPrimary)
                .setTitle("Zak Gallery")
                .show();
    }

}
