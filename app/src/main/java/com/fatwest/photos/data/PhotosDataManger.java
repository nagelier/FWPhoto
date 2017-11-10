package com.fatwest.photos.data;

import java.util.ArrayList;

/**
 * Created by android on 2017/11/9.
 */

public class PhotosDataManger {

    static PhotosDataManger photosDataManger;

    public static PhotosDataManger getInstance(){
        if (photosDataManger == null){
            photosDataManger = new PhotosDataManger();
        }
        return photosDataManger;
    }

    public ArrayList<String> getImageList() {
        ArrayList<String> imagesList = new ArrayList<>();
        for (int i = 1; i< 5; i++){
            String asseetName = "item" + i + ".jpg";
            String path = "file:///android_asset/" + asseetName;
            imagesList.add(path);
        }
//        imagesList.add("android.resource://com.fatwest.photos/drawable/"+ R.mipmap.item1);
//        imagesList.add("android.resource://com.fatwest.photos/drawable/"+ R.mipmap.item2);
//        imagesList.add("android.resource://com.fatwest.photos/drawable/"+ R.mipmap.item3);
        return imagesList;
    }

}
